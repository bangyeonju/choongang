class Big extends Thread{ //run메소드를 상속받기위해서 thread를 상속받아야한다
	
	 public void run() { //Thread는 꼭 run*(이름이 정해져있다.)
//		System.out.println("big()");
		
		for(char i='A';i<='Z';i++) {
			System.out.print(i+" ");
			
			try {
				sleep(100); //1초 잠재운당 잠 public static void sleep​(long millis) throws InterruptedException
			} catch (InterruptedException e) {

			}
		}
		System.out.println();
	}
	
}// Big
class Small implements Runnable{
	
	
	public void run() {
		for (char i='a';i<='z';i++) {
			System.out.print(i+" ");
			try {
				Thread.sleep(300);//*Runnable를 상속하고있기때문에 Thread.sleep();*
			} catch (InterruptedException e) {
				
			}
			
		}
	}
	
	
}// Small
public class Ex10_01_Thread {

	
	public static void main(String[] args) {
		System.out.println("프로그램시작");
		Big b = new Big();
		b.start();//Thread클래스가 start 메서드를 가지고있다.! run메서드 호출할때 start호출해야한다.
		Small s = new Small();
		Thread th = new Thread(s);
		th.start();
		System.out.println("프로그램끝");
	}

}
