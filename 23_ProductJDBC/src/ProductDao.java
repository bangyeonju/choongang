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

	ProductDao() { // ������
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ������ �߰ߵ��� �ʽ��ϴ�.(jar ���� ����)");
			e.printStackTrace();

		}
	}

	public void getConnection() {
		try {
			// 2�ܰ�
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Ŀ�ؼ� ���� ����");
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
				// �ѱ��
				bean.setId(id);
				bean.setName(name);
				bean.setStock(stock);
				bean.setPrice(price);
				bean.setCategory(category);
				bean.setInputdate(inputdate);
				// ��ƶ�
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

	// �ϳ��϶� ���� list�� �ʿ䰡 ����.
	public ProductBean getProductbyId(int id) {

		getConnection();
		ProductBean bean = null;

		String sql = "select * from products where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) { // select�Ѱ� �ϳ��ۿ������� if�� �ᵵ �ȴ�.
				int id2 = rs.getInt("id");
				String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));

				bean = new ProductBean();
				// �ѱ��
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
		ArrayList<ProductBean> lists = new ArrayList<ProductBean>(); // lists���� �ּҰ� ���ִ�. null�ƴϴ�

		String sql = "select * from products where category = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.toUpperCase()); // �빮�ڷ� �ٲپ��ش�.

			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category2 = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));
				bean = new ProductBean();// ������ ȣ��
				// �ѱ��
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
			ps.setString(1, pd.getName());// �������� �����°�(get)�߿� Name�� ����(set)�Ѵ�.
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
			//�м�
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id); //�Է��� id ���� �ִ´�.
			
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
