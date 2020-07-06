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
			System.out.println("드라이버 로딩성공");
			
			String url ="jdbc:oracle:thin:@localhost:1521:orcl"; 
			String user = "jspid";
			String pw = "jsppw";
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("접속성공");
			
			//3. sql문 분석
			String sql = "select * from simple";
			 ps = conn.prepareStatement(sql); //sql문자열분석해라
			
			//sql문 실행(select)
			rs = ps.executeQuery();
			
			
			//rs변수가 관리하는 데이터가 있으면 내부적으로 true 
			while(rs.next()){
//				int num = rs.getInt("nun"); 없는 칼럼명 입력시 sqlexception발생
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				System.out.println(num +":"+name+":"+addr );
			}
			
			//5.접속끊기
//			rs.close();
//			ps.close();
//			conn.close();
			System.out.println("접속끊기 성공");
			
		} catch (ClassNotFoundException e1) {
			 System.out.println("드라이버 로딩실패");
			 
		} catch (SQLException e) {
			System.out.println("접속실패");
		} finally { //중간에서 에러가 나오더라도 무조건 실행
			try { 
				
				if(rs!=null)
				rs.close();
				if(ps!=null) //분석이 잘됬다면 Null이 아님 => 반납?
				ps.close();
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}



			
				
		
	}
}
