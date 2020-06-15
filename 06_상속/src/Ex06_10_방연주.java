
abstract class Employee2 {
	private String empno;
	private String name;
	private int pay;

	Employee2(String empno, String name, int pay) {
		this.empno = empno;
		this.name = name;
		this.pay = pay;
	}

	abstract double getMonthPay();

	void display() {
		System.out.println();
		System.out.println(empno);
		System.out.println(name);
		System.out.println(pay);

	}
	double getPay(){
		return pay;
	}
}

class FullTime extends Employee2 {
	private int bonus;

	FullTime(String empno, String name, int pay, int bonus) {
		super(empno, name, pay);
		this.bonus = bonus;
	}

	double getMonthPay() {
		
		return (getPay() / (double) 12) + (bonus / (double) 12);
	}

	void display() {
		super.display();
		System.out.println(bonus);

	}

}

class Contract extends Employee2 {
	private int hireYear;

	Contract(String empno, String name, int pay, int hireYear) {
		super(empno, name, pay);
		this.hireYear = hireYear;
	}

	double getMonthPay() {
		return getPay() / (double) 12 * hireYear;

	}

	void display() {
		super.display();
		System.out.println(hireYear);

	}

}

class PartTime extends Employee2 {
	private int workDay;

	PartTime(String empno, String name, int pay, int workDay) {
		super(empno, name, pay);
		this.workDay = workDay;
	}

	double getMonthPay() {
		return getPay() * workDay;

	}

	void display() {
		super.display();
		System.out.println(workDay);

	}

}

public class Ex06_10_방연주 {

	public static void main(String[] args) {
		int i;
		FullTime f = new FullTime("F001", "성유리", 500, 30);
		Contract c = new Contract("C001", "이효리", 400, 3);
		PartTime p = new PartTime("P001", "이진", 300, 7);

		System.out.println("===========================");
		f.display();
		System.out.println(f.getMonthPay());
		c.display();
		System.out.println(c.getMonthPay());
		p.display();
		System.out.println(p.getMonthPay());
		// 4개의 변수를 출력하는 메서드
//		System.out.println(f.getMonthPay());

		// 배열로 만들어서 할것
		Employee2[] em = { 
				new FullTime("F001", "성유리", 500, 30), 
				new Contract("C001", "이효리", 400, 3),
				new PartTime("P001", "이진", 300, 7) };

		for (i = 0; i < em.length; i++) {
//			System.out.println(em[i]);
			System.out.printf("======배열을 이용한출력%d=====",i+1);
			em[i].display();
			System.out.println(em[i].getMonthPay());
		}

//		FullTime f = new FullFime("F001","성유리",500,30);
//		Contract c = new Contract("C001","이효리",400,3);
//		PartTime p = new PartTime("P001","이진",300,7);
//		//4개의 변수를 출력하는 메서드
//		System.out.println(getMethodPay());
	}
/*
	static void action(Employee2 e2) {
		if (e2 instanceof FullTime) {
			FullTime f = (FullTime) e2;
			f.display();
			System.out.println(e2.getMonthPay());
		} else if (e2 instanceof Contract) {
			Contract c = (Contract) e2;
			c.display();
			System.out.println(e2.getMonthPay());
		} else if (e2 instanceof PartTime) {
			PartTime p = (PartTime) e2;
			p.display();
			System.out.println(e2.getMonthPay());
		}

	}
	*/

}
//getMonthPay추상메서드로
//계약직 pay/(double)12*hireyear