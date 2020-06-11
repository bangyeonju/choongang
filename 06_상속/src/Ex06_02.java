
class Sports2 {
	String name;
	int inwon;

	Sports2(String name, int inwon) {
		this.name = name;
		this.inwon = inwon;
	}

	void show() {
		System.out.println(name);
		System.out.println(inwon);
	}
}

class Baseball2 extends Sports2 {
	double ta;

	Baseball2(String name, int inwon, double ta) {
		super(name, inwon);
		this.ta = ta;
	}
	void show() {
		super.show();
		System.out.println(ta);
	}
}

class Football2 extends Sports2 {
	int goal;

	Football2(String name, int inwon, int goal) {
		super(name, inwon);
		this.goal = goal;
	}
	void show() {
		super.show();
		System.out.println(goal);
		
	}
}

public class Ex06_02 {
	public static void main(String[] args) {
		Baseball2 b = new Baseball2("야구", 9, 0.258);
		Football2 f = new Football2("축구", 11, 15);
		b.show();
		f.show();
	}
}
