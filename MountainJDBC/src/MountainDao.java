import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MountainDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "jspid";
	String pw = "jsppw";

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	MountainDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("1");
			e.printStackTrace();
		}

	}

	void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			System.out.println("2");
			e.printStackTrace();
		}

	}

	public ArrayList<MountainBean> allMountainInfo() {
		ArrayList<MountainBean> lists = new ArrayList<MountainBean>();
		getConnection();
		String sql = "select * from mountain order by no";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				MountainBean bean = new MountainBean();

				int no = rs.getInt("no");

				String name = rs.getString("name");
				String place = rs.getString("place");
				String top = rs.getString("top");
				String who = rs.getString("who");

				bean.setNo(no);
				bean.setName(name);
				bean.setPlace(place);
				bean.setTop(top);
				bean.setWho(who);

				lists.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("10");
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
		}

		return lists;
	}

	public ArrayList<MountainBean> searchMountain(String col, String searchWord) {
		ArrayList<MountainBean> lists = new ArrayList<MountainBean>();
		getConnection();
		String sql = "select * from mountain where " + col + " like ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + searchWord + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				MountainBean bean = new MountainBean();
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String place = rs.getString("place");
				String top = rs.getString("top");
				String who = rs.getString("who");

				bean.setNo(no);
				bean.setName(name);
				bean.setPlace(place);
				bean.setTop(top);
				bean.setWho(who);
				lists.add(bean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
		}
		return lists;
	}

	public int insertMountain(MountainBean bean) {
		getConnection();
		int cnt = -1;
		String sql = "insert into mountain values(mountainseq.nextval,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPlace());
			ps.setString(3, bean.getTop());
			ps.setString(4, bean.getWho());

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
			}
		}
		return cnt;

	}

	public int updateData(MountainBean bean) {
		int cnt = -1;
		getConnection();
		String sql = "update mountain set name=?,place=?,top=?,who=? where no =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPlace());
			ps.setString(3, bean.getTop());
			ps.setString(4, bean.getWho());
			ps.setInt(5, bean.getNo());

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
			}
		}

		return cnt;
	}

	public int deleteOne(int no) {
		int cnt = -1;
		getConnection();
		String sql = "delete from mountain where no = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
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
			}
		}
		return cnt;

	}

	public int deleteAll(String col, String inputText) {
		int cnt = -1;
		getConnection();
		String sql = "delete from mountain where " + col + " like ?";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + inputText + "%");
			cnt = ps.executeUpdate();
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

	public ArrayList<MountainBean> allMountainPhone() {
		ArrayList<MountainBean> lists = new ArrayList<MountainBean>();
		getConnection();
		String sql = "select m.name,place ,top, phone from mountain m inner join m_info i on m.name = i.name";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MountainBean bean = new MountainBean();
				String name = rs.getString("name");
				String place = rs.getString("place");
				String top = rs.getString("top");
				String phone = rs.getString("phone");
				System.out.println(rs.getString("name"));
				bean.setName(name);
				bean.setPlace(place);
				bean.setTop(top);
				bean.setPhone(phone);
				lists.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
			}
		}

		return lists;
	}

}
