import java.awt.Desktop.Action;

class Sports {
	String name;
	int inwon;

	Sports() {
		System.out.println("Sports()");
	}

	Sports(String name, int inwon) {
		this.name = name;
		this.inwon = inwon;
	}

	void display() {
		System.out.println("종목이름" + name);
		System.out.println("인원수" + inwon);
		System.out.println();
	}

} // Sports
//Baseball = 자식  Sports =부모
//class 자식 extends 부모

class Baseball extends Sports { // sports를 상속받는다악
//	String name;
//	int inwon;
	double ta;

	Baseball(String name, int inwon, double ta) {
//		 super();//부모의 생성자를 호출 / 생략되어있음!/생성자의 맨첫줄에 선언!
		super(name, inwon);
// 		 this.name=name; //부모가 물려줌!
//		 this.inwon=inwon;
		this.ta = ta;
	}

	void display() {
//		 System.out.println("구단이름="+name);
//		 System.out.println("인원수="+inwon);
		super.display();// 부모가 가지고있는 display()메소드를 호출하겠드아 super.disply(); 만약 dispy();로 호출하면 재귀호출됨!
		System.out.println("타율=" + ta);
		System.out.println();
	}
}// baseball

class Football extends Sports {
//	String name;
//	int inwon;
	int goal;

	Football(String name, int inwon, int goal) {
		// super();//부모생성자호출르루ㅜ룰
		super(name, inwon);
//		this.name= name;
//		this.inwon=inwon;
		this.goal = goal;
	}

	void display() {
		super.display();
//		System.out.println("이름"+name);
//		System.out.println("인원수"+inwon);
		System.out.println("골" + goal);
	}
}// football

public class Ex06_01_상속_야구축구 {
	public static void main(String[] args) {
		Sports s = new Sports("스포츠", 1); // 객체생성 -> 생성자 호출
		s.display();

		Sports b = new Baseball("야구", 9, 0.314);
		b.display();

		Sports f = new Football("축구", 11, 20);
		f.display();

		System.out.println("==================");

		Sports[] spo = {
				new Sports("스포츠", 1),
				(Sports) new Baseball("야구", 9, 0.332),
				new Football("축구", 11, 6) 
				};

		int i;
		for (i = 0; i < spo.length; i++) {

			spo[i].display();
		}

	}

}
