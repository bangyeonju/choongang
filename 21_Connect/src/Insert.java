import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		int cnt;
		String driver = "oracle.jdbc.driver.OracleDriver";

		String url= "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jspid";
		String pw ="jsppw";
		
		try {
			Class.forName(driver);
			
			 conn = DriverManager.getConnection(url, user, pw);
			 System.out.println("������ ����");
//			 3.sql�� �м�
			 int in_num = 4;
			 String in_name = "song";
			 String in_addr = "����";
//			 String sql="insert into simple values(4,'lee','��õ')";
//			 String sql="insert into simple values("+in_num+",'"+in_name+"','"+in_addr+"')";
			 String sql="insert into simple values(?,?,?)";
			 ps = conn.prepareStatement(sql);
			 System.out.println("�м���");
			 // ?(��ġȦ��) �ڸ� ����
			 ps.setInt(1,in_num);
			 ps.setString(2,in_name);
			 ps.setString(3,in_addr);
			 
			 
//			 4.sql�� ����
			 cnt= ps.executeUpdate(); //���������� ����� ������ ���� 
			 System.out.println("cnt:" +cnt);
			 if(cnt == 0)
				 System.out.println("insert ����");
			 else
				 System.out.println("insert ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			
			System.out.println("SQLException");
		} finally {
			
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}


				if(conn!=null)
					try {
						conn.close(); //������ �ڵ����� commit�̵ȴ�.
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
		}
				
		

	}

}
