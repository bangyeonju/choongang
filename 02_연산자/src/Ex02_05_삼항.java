
public class Ex02_05_삼항 {

	public static void main(String[] args) {

		// 이항연산자: 3+4,-,*,/
		// 단항 연산자: ++,--,-,!
		// 삼항(조건)연산자: 조건문 ? 조건문이 참일경우 실행 : 조건문이 거짓일경우 실행
//						   조건문 ? 참 : 거짓
		int a=11,b=20;
		String result;
		result = a%2 == 1 ? "홀수" : "짝수";
		System.out.println("result:" + result);
	}

}
