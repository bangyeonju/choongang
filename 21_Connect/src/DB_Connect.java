import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {
	public static void main(String[] args) {
		try {
			//0. jar파일 포함시키기
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "jspid";
			String pw = "jsppw";
			// 2. 계정에 접속
			Connection conn = DriverManager.getConnection(url, user, pw);
			System.out.println("접속성공");
			
			
			// 5.접속끊기
			conn.close();
			System.out.println("접속끊기 성공");
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패"); //Class.forName에 오타가 있거나 jar파일을 안가져왔을때 오류생김
		} catch (SQLException e) {
			 System.out.println("접속실패");
		}
	}

}
