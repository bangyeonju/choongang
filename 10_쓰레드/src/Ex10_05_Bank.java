
class Bank {
	private int money = 10000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public synchronized void saveMoney(int save) { //이메서드 자체에 동시에 호출?하지못하도ㅗㄺ
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		money = money + save;
	}

}

class Park extends Thread {
	public void run() {
		Ex10_05_Bank.b.saveMoney(3000);
		System.out.println("Park saveMoney(3000):"+Ex10_05_Bank.b.getMoney());
			
		

	}


}

class Kim extends Thread {
	public void run() {		Ex10_05_Bank.b.saveMoney(5000);
			System.out.println("Kim saveMoney(5000)"+Ex10_05_Bank.b.getMoney());
			
		
	}
}

public class Ex10_05_Bank {
	public static Bank b = new Bank();
	public static void main(String[] args) {
		System.out.println("원금:"+b.getMoney());
		Park p = new Park();
		Kim k = new Kim();
		p.start();
		k.start();
	}
}
