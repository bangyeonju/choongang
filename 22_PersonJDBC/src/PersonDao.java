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
		String sql = "select * from person order by num";

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
		} // finally
		System.out.println("검색한 성별은:" + lists.size() + "명 입니다.");
		return lists;

	}// getPersonByGender

	public int insertData(String name, int age, String gender, String birth) {
		getConnect();
		int cnt = -1;
		String sql = "insert into person(num,name,age,gender,birth)" + "values(perseq.nextval,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			ps.setString(4, birth);

			cnt = ps.executeUpdate();

			System.out.println("cnt:" + cnt);

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

	public int updateData(PersonBean bean) {

		System.out.println(bean.getNum());
		System.out.println(bean.getName());
		System.out.println(bean.getAge());
		System.out.println(bean.getGender());
		System.out.println(bean.getBirth());

		getConnect();
		String sql = "update person set name=?,age=?,gender=?,birth=? where num=?";
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			// 분석한 중에 ? 발견하면 ? 자리에 값 세팅하고 실행해야 한다.
			ps.setString(1, bean.getName());// String으로 세팅한다. bean객체에 묶인 이름값을 갖고온다
			ps.setInt(2, bean.getAge());
			ps.setString(3, bean.getGender());
			ps.setString(4, bean.getBirth());
			ps.setInt(5, bean.getNum());

			// 4.실행: 실행하는 명령어에서 에러가 뜨면 sql문에 문제가있을 확률이 높다
			cnt = ps.executeUpdate();
			
			// 조건에 맞는 데이터가 없다 : 0
			// 조건에 맞는 데이터가 있다 : 1
			// 수정실패 :-1 =>cnt를 -1로 설정한 이유

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(conn!=null)
					conn.close();
					if(ps!=null)
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
			return cnt;
			
			
	}//updateData
	
	public int deleteData(int num) {
		int cnt = -1;
		System.out.println(num);
		getConnect();
		String sql = "delete from person where num = ?";
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, num);
			cnt =ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
		return cnt;
	}//deleteData
	

}
