
public class Ex07_06_throws {
	public static void main(String[] args) {
		try {
//			call(); // 에러를 받는다?
			call2();
			System.out.println("정상실행");
		} catch (Exception e) {
		
			System.out.println(e.toString());
			System.out.println("처리중 에러발생");

		}
	}

	static void call() {
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			System.out.println("call():" + e.toString());
			throw e; // 에러를 던진다
		}
		return;
	}

	static void call2() throws Exception{ //떠넘기고싶을때* throws Exceptions 
		int i = 10 / 0; // new ArithmeticException();
		
	}

}
