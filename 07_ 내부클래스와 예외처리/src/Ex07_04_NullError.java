
public class Ex07_04_NullError {

	public static void main(String[] args) {
		int a;
		try {
			String str = "banana";
			System.out.println(str.length()); // 예외가 발생시
			System.out.println("try 안이다");
			// new NullPointerException(); ->클래스 *객체가 자동으로 만들어짐! *
			a = 3 / 0;
			System.out.println("a:" + a);
			int[] arr = { 1, 2, 3 };
			System.out.println(arr[4]); // new ArrayIndexOutOfBoundsException(); 객체가 만들어진다.
			
		} 
	
		catch (NullPointerException e1) {
			System.out.println("null로 초기화된 변수 사용불가");
			System.out.println(e1.toString());
			System.out.println(e1.getMessage());

		} catch (ArithmeticException e2) {
			System.out.println("0으로 나눔");
			System.out.println(e2.toString());
			System.out.println(e2.getMessage());
			
		} catch (ArrayIndexOutOfBoundsException e3) {
			System.out.println("@3번방은 없습니다@");
		}	
		catch(Exception e) { //exception이 nullpointexception,arridextoutofboundsexception등등 부모 ,Exception은 마지막 catch문에*
			System.out.println(e.toString()); //모든 에러를 잡ㅇ르수잇다
		}
		 finally { // 예외가 발생 하던 안하던 무조건 처리!
			System.out.println("finally 구문 실행");
		}
		System.out.println("예외처리");

	}

}
