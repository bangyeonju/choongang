class Pay {
	String name;
	int bonbong;
	int tax; // 1만원
	int silsu;

	// setTex(본봉받기)
	/*
	 * 본봉이 300만원 이상이면 세금은 3% 300만원이면 90000원 본봉이 200만원 이상이면 세금은 2% 본봉이 100만원 이하이면 세금은
	 * 1% 100만원 세금 만원
	 */
	/*
	 * int setTax(int i) { //메소드 정의 파라미터값 = 매개변수 if (i >= 3000000) { tax = (int) (i
	 * * 0.03); // * (int)90000.0 ==> 90000
	 * 
	 * } else if (i >= 2000000) { tax = (int) (i * 0.02); } else { tax = (int) (i *
	 * 0.01); } return; }
	 */
	void setTax() {
		if (bonbong >= 3000000) {
			tax = (int) (bonbong * 0.03); // (int)90000.0 ==> 90000

		} else if (bonbong >= 2000000) {
			tax = (int) (bonbong * 0.02);
		} else {
			tax = (int) (bonbong * 0.01);
		}
		
	}

	// 실수령액 계산(본봉, 세금) { // silsu = 본봉 -세금
	void setSilsu() {
		silsu = bonbong - tax;

	}

	// 멤버변수 4개 출력하는 메서드() {
	void display() {
		System.out.printf("이름=%s\n", name);
		System.out.printf("월급=%d\n", bonbong);
		System.out.printf("세금=%d\n", tax);
		System.out.printf("실수액=%d\n", silsu);
		System.out.println();

	}
}

public class Ex05_06_방연주 {
	public static void main(String[] args) {
		Pay p1 = new Pay(); // 객체생성
		Pay p2 = new Pay();
		Pay p3 = new Pay();

		p1.name = "윤아";
		p1.bonbong = 1000000;

		p2.name = "태연";
		p2.bonbong = 2000000;

		p3.name = "웬디";
		p3.bonbong = 5000000;

		p1.setTax(); // 2. 파라미터가가 필요없다...?
		p2.setTax();
		p3.setTax();
		p1.setSilsu();
		p2.setSilsu();
		p3.setSilsu();
		p1.display();
		p2.display();
		p3.display();
		
		
		// p1.setTax(p1.bonbong); //메소드 호출 --> 1. 위에서 이미 값을 넣었기 떄문에
		// p1.silsuSet(p1.bonbong, p1.tax);
		//
	
	}
}