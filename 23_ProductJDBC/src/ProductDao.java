import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String username = "jspid";
	String password = "jsppw";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	ProductDao() { // 생성자
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 발견되지 않습니다.(jar 파일 누락)");
			e.printStackTrace();

		}
	}

	public void getConnection() {
		try {
			// 2단계
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}

	}

	public ArrayList<ProductBean> getAllProduct() {
		getConnection();
		ProductBean bean = null;
		String sql = "select * from products order by id asc";
		ArrayList<ProductBean> lists = new ArrayList<ProductBean>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));

				bean = new ProductBean();
				// 넘기고
				bean.setId(id);
				bean.setName(name);
				bean.setStock(stock);
				bean.setPrice(price);
				bean.setCategory(category);
				bean.setInputdate(inputdate);
				// 담아라
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

	// 하나일때 굳이 list쓸 필요가 없다.
	public ProductBean getProductbyId(int id) {

		getConnection();
		ProductBean bean = null;

		String sql = "select * from products where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) { // select한게 하나밖에없으면 if문 써도 된다.
				int id2 = rs.getInt("id");
				String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));

				bean = new ProductBean();
				// 넘기고
				bean.setId(id2);
				bean.setName(name);
				bean.setStock(stock);
				bean.setPrice(price);
				bean.setCategory(category);
				bean.setInputdate(inputdate);

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
		}

		return bean;
	}// getProductById

	public ArrayList<ProductBean> getProductByCategory(String category) {
		getConnection();
		ProductBean bean = null;
		ArrayList<ProductBean> lists = new ArrayList<ProductBean>(); // lists에는 주소가 들어가있다. null아니다

		String sql = "select * from products where category = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.toUpperCase()); // 대문자로 바꾸어준다.

			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category2 = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));
				bean = new ProductBean();// 생성자 호출
				// 넘기고
				bean.setId(id);
				bean.setName(name);
				bean.setStock(stock);
				bean.setPrice(price);
				bean.setCategory(category2);
				bean.setInputdate(inputdate);
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

	public int insertData(ProductBean pd) {
		int cnt = -1;
		getConnection();
		String sql = "insert into products (id,name,stock,price,category,inputdate) values(prdseq.nextval,?,?,?,?,?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pd.getName());// 묶음으로 가져온것(get)중에 Name을 세팅(set)한다.
			ps.setInt(2, pd.getStock());
			ps.setInt(3, pd.getPrice());
			ps.setString(4, pd.getCategory());
			ps.setString(5, pd.getInputdate());

			cnt = ps.executeUpdate();
			System.out.println("insert cnt:" + cnt);
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

	}// insertData

	public int updateData(ProductBean bean) {
		getConnection();
		int cnt = -1;
		String sql = "update products set name=?,stock=?,price=?, category=?,inputdate=? where id=?";
		try {
			
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getName());
			ps.setInt(2, bean.getStock());
			ps.setInt(3, bean.getPrice());
			ps.setString(4, bean.getCategory());
			ps.setString(5, bean.getInputdate());
			ps.setInt(6, bean.getId());

			cnt = ps.executeUpdate();
			System.out.println("cnt:" + cnt);
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

	public int deleteData(int id) {
		int cnt=-1;
		getConnection();
		String sql = "delete from products where id = ?";
		try {
			//분석
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id); //입력한 id 값을 넣는다.
			
			cnt=ps.executeUpdate();
			
			System.out.println("cnt :"+cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
}
