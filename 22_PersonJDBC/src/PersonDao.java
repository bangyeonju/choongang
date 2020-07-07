import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DB 관련 작업(i,u,d,s)
public class PersonDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	// 1단계작업 => 드라이버 로드
	PersonDao() {
		System.out.println("PersonDao");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	void getConnect() {
		try {
			// 2단계작업 => 계정에 접속
			conn = DriverManager.getConnection(url, id, pw);
			// conn변수안에는 jspid계정에 접속됐다는 정보가 들어온다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PersonBean> getAllPerson() {
//		2.계정에 접속하기 위해 호출
		getConnect();
		// 3.sql문 분석
		String sql = "select * from person";

		ArrayList<PersonBean> lists = new ArrayList<PersonBean>();
		try {
			ps = conn.prepareStatement(sql);
			// 4.sql문 실행
			rs = ps.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				Date birth = rs.getDate("birth");

				PersonBean bean = new PersonBean();
				bean.setNum(num);
				bean.setName(name);
				bean.setAge(age);
				bean.setGender(gender);
				bean.setBirth(String.valueOf(birth));
				lists.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
			}
		} // finally
		System.out.println(lists.size());
		return lists;

	}

	public ArrayList<PersonBean> getPersonByGender(String findGender) {
		getConnect();

		String sql = "select * from person where gender = ?";
		ArrayList<PersonBean> lists = new ArrayList<PersonBean>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, findGender);

			rs = ps.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				
				Date birth = rs.getDate("birth");
				
				PersonBean bean = new PersonBean();
				bean.setNum(num);
				bean.setName(name);
				bean.setAge(age);
				bean.setGender(gender);
				bean.setBirth(String.valueOf(birth));
				lists.add(bean);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null) 
					ps.close();
				if (conn != null) 
					conn.close();
					
				
			} catch (Exception e) {
			}
		}//finally
		System.out.println("검색한 성별은:" +lists.size()+"명 입니다.");
		return lists;

	}//getPersonByGender

	public int insertData(String name,int age, String gender, String birth) {
		getConnect();
		int cnt= -1;
		String sql = "insert into person(num,name,age,gender,birth)"
				+ "values(perseq.nextval,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setInt(2,age);
			ps.setString(3,gender);
			ps.setString(4,birth);
			
			cnt=ps.executeUpdate();
			
			System.out.println("cnt:"+cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
				ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

}
