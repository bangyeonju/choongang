import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumsDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "jspid";
	String pw = "jsppw";

	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection conn = null;

	AlbumsDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<AlbumsBean> selectAllAlbums() {
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		getConnection();
		String sql = "select * from albums order by num";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AlbumsBean bean = new AlbumsBean();
				int num = rs.getInt("num");
				String song = rs.getString("song");
				String singer = rs.getString("singer");
				String company = rs.getString("company");
				int price = rs.getInt("price");
				String pub_day = String.valueOf(rs.getDate("pub_day"));

				bean.setNum(num);
				bean.setSong(song);
				bean.setSinger(singer);
				bean.setCompany(company);
				bean.setPrice(price);
				bean.setPub_day(pub_day);
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

	public int insertAlbums(AlbumsBean bean) {
		
		getConnection();
		int cnt = -1;
		String sql = "insert into albums values(albumseq.nextval,?,?,?,?,?)";

		try {
			System.out.println(bean.getSong());
			ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getSong());
			ps.setString(2, bean.getSinger());
			ps.setString(3, bean.getCompany());
			ps.setInt(4, bean.getPrice());
			ps.setString(5, String.valueOf(bean.getPub_day()));

			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

	public int updateAlbums(AlbumsBean bean) {
		getConnection();
		int cnt = -1;
		String sql = "update albums set song=?, singer=?,company=?,price =? ,pub_day =? where num = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getSong());
			ps.setString(2, bean.getSinger());
			ps.setString(3, bean.getCompany());
			ps.setInt(4, bean.getPrice());
			ps.setString(5, bean.getPub_day());
			ps.setInt(6, bean.getNum());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

	public int deleteAlbums(int num) {
		getConnection();
		int cnt = -1;
		String sql = "delete from albums where num = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;

	}

	public ArrayList<AlbumsBean> searchAlbums(String column, String inputWord) {
		getConnection();
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		String sql = "select * from albums where lower("+column+ ") like ? order by num";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+inputWord.toLowerCase()+"%");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				AlbumsBean bean = new AlbumsBean();
				
				int num =rs.getInt("num");
				String song = rs.getString("song");
				String singer = rs.getString("singer");
				String company = rs.getString("company");
				int price =rs.getInt("price");
				String  pub_day = String.valueOf(rs.getDate("pub_day"));
				bean.setNum(num);
				bean.setSong(song);
				bean.setSinger(singer);
				bean.setCompany(company);
				bean.setPrice(price);
				bean.setPub_day(pub_day);
				
				lists.add(bean);
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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

	public ArrayList<AlbumsBean> selectRank(int sn, int ln) {
		getConnection();
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
//		String sql = "select num,song,singer,company,price,pub_day\r\n" + 
//				"from(select num,song,singer,company,price,pub_day,rownum as rank \r\n" + 
//				"from albums \r\n" + 
//				"order by price desc ,singer asc)\r\n" + 
//				"where rank between ? and ?";
		String sql = "select rownum,num,song,singer,company,price ,pub_day, rank "
				+ "from (select rownum,num,song,singer,company,price, pub_day, rank() over (order by price desc,singer asc) as rank  "+ 
				" from albums) " + " where rank between ? and ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sn);
			ps.setInt(2, ln);
			rs=ps.executeQuery();
			while(rs.next()) {
				AlbumsBean bean = new AlbumsBean();
				
				int num =rs.getInt("num");
				String song = rs.getString("song");
				String singer = rs.getString("singer");
				String company = rs.getString("company");
				int price =rs.getInt("price");
				String pub_day = String.valueOf(rs.getDate("pub_day"));
				bean.setNum(num);
				bean.setSong(song);
				bean.setSinger(singer);
				bean.setCompany(company);
				bean.setPrice(price);
				bean.setPub_day(pub_day);
				
				lists.add(bean);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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

	public ArrayList<AlbumsBean> selectAlign(String column,String way) {
		getConnection();
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		String sql = "select * from albums order by "+ column +  " " + way;
		try {
			ps=conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while (rs.next()) {
				AlbumsBean bean = new AlbumsBean();
				int num = rs.getInt("num");
				String song = rs.getString("song");
				String singer = rs.getString("singer");
				String company = rs.getString("company");
				int price = rs.getInt("price");
				String pub_day = String.valueOf(rs.getDate("pub_day"));
				
				bean.setNum(num);
				bean.setSong(song);
				bean.setSinger(singer);
				bean.setCompany(company);
				bean.setPrice(price);
				bean.setPub_day(pub_day);
				lists.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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