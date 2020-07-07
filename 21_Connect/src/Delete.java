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
				
				System.out.println("접속성공");
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "jspid";
				String pw = "jsppw";
				conn= DriverManager.getConnection(url, user, pw);
				System.out.println("계정에접속");
				int del_num=2;
//				String sql ="delete from simple where num = 1";
				String sql ="delete from simple where num = ?";
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1, del_num);
				cnt=ps.executeUpdate();
				System.out.println("cnt:"+cnt);
				if(cnt == 0) {
					System.out.println("조건에 만족하는레코드 없움");
				} else {
					System.out.println("delete 성공");
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
