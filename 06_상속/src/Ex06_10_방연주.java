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

public class Ex06_10_�濬�� {

	public static void main(String[] args) {
		FullTime f = new FullTime("F001", "������", 500, 30);
		Contract c = new Contract("C001", "��ȿ��", 400, 3);
		PartTime p = new PartTime("P001", "����", 300, 7);
		
		f.display();
		c.display();
		p.display();
		System.out.println("===========================");
		System.out.println(f.getMonthPay());
		System.out.println(c.getMonthPay());
		System.out.println(p.getMonthPay());
		// 4���� ������ ����ϴ� �޼���
//		System.out.println(f.getMonthPay());

		// �迭�� ���� �Ұ�
//		FullTime f = new FullFime("F001","������",500,30);
//		Contract c = new Contract("C001","��ȿ��",400,3);
//		PartTime p = new PartTime("P001","����",300,7);
//		//4���� ������ ����ϴ� �޼���
//		System.out.println(getMethodPay());
	}

}
//getMonthPay�߻�޼����
//����� pay/(double)12*hireyear