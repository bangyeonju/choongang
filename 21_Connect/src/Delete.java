import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	
	
	public static void main(String[] args) {
		Connection conn =null;
		PreparedStatement ps = null;
		int cnt;
		String driver = "oracle.jdbc.driver.OracleDriver";
		
			try {
				Class.forName(driver);
				
				System.out.println("���Ӽ���");
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "jspid";
				String pw = "jsppw";
				conn= DriverManager.getConnection(url, user, pw);
				System.out.println("����������");
				int del_num=2;
//				String sql ="delete from simple where num = 1";
				String sql ="delete from simple where num = ?";
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1, del_num);
				cnt=ps.executeUpdate();
				System.out.println("cnt:"+cnt);
				if(cnt == 0) {
					System.out.println("���ǿ� �����ϴ·��ڵ� ����");
				} else {
					System.out.println("delete ����");
				}
				
			} catch (ClassNotFoundException e) {
			} catch (SQLException e) {
				try {
					if(conn !=null)
					conn.close();
				} catch (SQLException e1) {
				}
				
				try {
					if(ps !=null)
					ps.close();
				} catch (SQLException e1) {
				}
			}
		
		
	
		
		
	}
}
