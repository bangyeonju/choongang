import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class BookDao {

	String driver = "oracle.jdbc.driver.OracleDriver";

	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "jspid";
	String pw = "jsppw";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	BookDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 발겨되지 않습니다.(jar 파일)");
			e.printStackTrace();
		}

	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			System.out.println("커넷션 생성오류");
			e.printStackTrace();
		}

	}

	public ArrayList<BookBean> getAllBook() {
		getConnection();
		String sql = "select * from book order by no asc";
		BookBean bean;
		ArrayList<BookBean> lists = new ArrayList<BookBean>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				bean = new BookBean();
//				int no =rs.getInt("no");
//				String title = rs.getString("title");
//				String author = rs.getString("author");
//				String publisher = rs.getString("publisher");
//				int price = rs.getInt("price");
//				String pub_day = rs.getString("pub_day");
//				System.out.println("no"+no);
//				bean.setNo(no);
//				bean.setTitle(title);
//				bean.setAuthor(author);
//				bean.setPublisher(publisher);
//				bean.setPrice(price);
//				bean.setPub_day(pub_day);
			
				bean.setNo(rs.getInt("no"));
				bean.setTitle(rs.getString("title"));
				bean.setAuthor(rs.getString("author"));
				bean.setPublisher(rs.getString("publisher"));
				bean.setPrice(rs.getInt("price"));
				bean.setPub_day(String.valueOf(rs.getDate("pub_day")));

				lists.add(bean);
			}

		} catch (SQLException e) {

		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lists;
	}

	public int insertBook(BookBean bean) {
		getConnection();

		String sql = "insert into book values(bsep.nextval,?,?,?,?,to_date(?,'yyyy/mm/dd'))";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getAuthor());
			ps.setString(3, bean.getPublisher());
			ps.setInt(4, bean.getPrice());
			ps.setString(5, bean.getPub_day());

			cnt = ps.executeUpdate();// 실행해라

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (Exception e) {

			}
		}
		return cnt;

	}

	public int updateBook(BookBean book) {
		int cnt = -1;
		getConnection();
		String sql = "update book set title=?, author= ?,publisher=?,price=?,pub_day=to_date(?,'yyyy/mm/dd') where no=?";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			ps.setString(5, String.valueOf(book.getPub_day()));
			ps.setInt(6, book.getNo());

			cnt = ps.executeUpdate();
			conn.commit();// 수정된거 저장해라!

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {

			}
		}
		return cnt;
	}

	public int deleteBook(int no) {
		getConnection();
		int cnt = -1;
		String sql = "delete from book where no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			cnt = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {

			}
		}

		return cnt;
	}

	public ArrayList<BookBean> getBookBySearch(String column, String search_word) {
		getConnection();
		ArrayList<BookBean> lists = new ArrayList<BookBean>();

//		String sql = "select * from book where "+column+" like ? order by no"; //방법 1
//		String sql = "select * from book where "+column+" like '%"+search_word+"%'order by no"; //방법2
		String sql = "select * from book where " + column + " like '%' ||?|| '%' order by no";//방법 3 sql 연결  => ||
		try {
			ps = conn.prepareStatement(sql);
//			ps.setString(1, "%"+search_word+"%");// 방법 1: 1번 물음표에  %"+search_word+"%게 넣겠다.
			ps.setString(1, search_word);//방법 3
			rs = ps.executeQuery();
			while (rs.next()) {

				BookBean bean = new BookBean();
			
				bean.setNo(rs.getInt("no"));
				bean.setTitle(rs.getString("title"));
				bean.setAuthor(rs.getString("author"));
				bean.setPublisher(rs.getString("publisher"));
				bean.setPrice(rs.getInt("price"));
				bean.setPub_day(String.valueOf(rs.getDate("pub_day")));

				lists.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lists;
	}

}
