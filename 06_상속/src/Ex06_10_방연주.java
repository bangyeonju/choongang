abstract class Employee2 {
	String empno;
	String name;
	double pay;

	Employee2(String empno, String name, int pay) {
		this.empno = empno;
		this.name = name;
		this.pay = pay;
	}

	abstract double getMonthPay();

	void display() {
		System.out.println(empno);
		System.out.println(name);
		System.out.println(pay);

	}
}

class FullTime extends Employee2 {
	int bonus;

	FullTime(String empno, String name, int pay, int bonus) {
		super(empno, name, pay);
		this.bonus = bonus;
	}

	double getMonthPay() {
		pay = (pay / (double) 12) + (bonus / (double) 12);
		return pay;
	}

	void display() {
		super.display();
		System.out.println(bonus);

	}

}

class Contract extends Employee2 {
	int hireYear;

	Contract(String empno, String name, int pay, int hireYear) {
		super(empno, name, pay);
		this.hireYear = hireYear;
	}

	double getMonthPay() {
		pay = pay / (double) 12 * hireYear;
			return pay;

	}

	void display() {
		super.display();
		System.out.println(hireYear);

	}

}

class PartTime extends Employee2 {
	int workDay;

	PartTime(String empno, String name, int pay, int workDay) {
		super(empno, name, pay);
		this.workDay = workDay;
	}

	double getMonthPay() {
		pay = pay * workDay;
		return pay;

	}

	void display() {
		super.display();
		System.out.println(workDay);

	}

}

public class Ex06_10_방연주 {

	public static void main(String[] args) {
		FullTime f = new FullTime("F001", "성유리", 500, 30);
		Contract c = new Contract("C001", "이효리", 400, 3);
		PartTime p = new PartTime("P001", "이진", 300, 7);
		
		f.display();
		c.display();
		p.display();
		System.out.println("===========================");
		System.out.println(f.getMonthPay());
		System.out.println(c.getMonthPay());
		System.out.println(p.getMonthPay());
		// 4개의 변수를 출력하는 메서드
//		System.out.println(f.getMonthPay());

		// 배열로 만들어서 할것
//		FullTime f = new FullFime("F001","성유리",500,30);
//		Contract c = new Contract("C001","이효리",400,3);
//		PartTime p = new PartTime("P001","이진",300,7);
//		//4개의 변수를 출력하는 메서드
//		System.out.println(getMethodPay());
	}

}
//getMonthPay추상메서드로
//계약직 pay/(double)12*hireyear