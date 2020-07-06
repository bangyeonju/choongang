import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
	public static void main(String[] args) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε�����");
			
			String url ="jdbc:oracle:thin:@localhost:1521:orcl"; 
			String user = "jspid";
			String pw = "jsppw";
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("���Ӽ���");
			
			//3. sql�� �м�
			String sql = "select * from simple";
			 ps = conn.prepareStatement(sql); //sql���ڿ��м��ض�
			
			//sql�� ����(select)
			rs = ps.executeQuery();
			
			
			//rs������ �����ϴ� �����Ͱ� ������ ���������� true 
			while(rs.next()){
//				int num = rs.getInt("nun"); ���� Į���� �Է½� sqlexception�߻�
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				System.out.println(num +":"+name+":"+addr );
			}
			
			//5.���Ӳ���
//			rs.close();
//			ps.close();
//			conn.close();
			System.out.println("���Ӳ��� ����");
			
		} catch (ClassNotFoundException e1) {
			 System.out.println("����̹� �ε�����");
			 
		} catch (SQLException e) {
			System.out.println("���ӽ���");
		} finally { //�߰����� ������ �������� ������ ����
			try { 
				
				if(rs!=null)
				rs.close();
				if(ps!=null) //�м��� �߉�ٸ� Null�� �ƴ� => �ݳ�?
				ps.close();
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}



			
				
		
	}
}
