package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {

	String driver = "orcle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "jspid";
	String pw = "jsppw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	ProductDao() {
		System.out.println("ProductDao");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 발견되지 않습니다.(jar 파일 누락)");
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

	}}
