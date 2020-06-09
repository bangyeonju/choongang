class Pay {
	String name;
	int bonbong;
	int tex; // 1만원
	int silsu;

	// setTex(본봉받기)
	/*
	 * 본봉이 300만원 이상이면 세금은 3% 300만원이면 90000원 본봉이 200만원 이상이면 세금은 2% 본봉이 100만원 이하이면 세금은
	 * 1% 100만원 세금 만원
	 */
	int setTex(int bonbong) {
		if (bonbong >= 3000000) {
			tex = (int) (bonbong * 0.03);

		} else if (bonbong >= 2000000) {
			tex = (int) (bonbong * 0.02);
		} else {
			tex = (int) (bonbong * 0.01);
		}
		return tex;

	}

	// 실수령액 계산(본봉, 세금) {
//	silsu = 본봉 -세금
	int silsuSet(int bonbong, int tex) {
		silsu = bonbong - tex;
		return silsu;
	}

	// 멤버변수 4개 출력하는 메서드() {
	void info(){
		System.out.printf("이름=%s\n", name);
		System.out.printf("월급=%d\n",bonbong);
		System.out.printf("세금=%d\n",tex);
		System.out.printf("실수액=%d\n",silsu);
		System.out.println();
	}


	
	
	
}

public class Ex05_06_방연주 {
	public static void main(String[] args) {
		Pay p1 = new Pay();
		Pay p2 = new Pay();
		Pay p3 = new Pay();

		p1.name = "윤아";
		p1.bonbong = 4000000;
		
		p2.name = "민아";
		p2.bonbong = 2000000;
		
		p3.name = "진아";
		p3.bonbong = 1000000;
		int money = p1.setTex(p1.bonbong);
		int silmoney = p1.silsuSet(p1.bonbong, p1.tex);
		
		int money2 = p2.setTex(p2.bonbong);
		int silmoney2 = p2.silsuSet(p2.bonbong, p2.tex);
		
		int money3 = p3.setTex(p1.bonbong);
		int silmoney3 = p3.silsuSet(p3.bonbong, p3.tex);
		
		p1.info();
		p2.info();
		p3.info();
	}
}
