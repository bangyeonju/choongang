interface RemoteControl {
	void turnOn();
	void turnOff();
}
//
//class Tv implements RemoteControl {
//
//	@Override
//	public void turnOn() {
//		System.out.println("Tv켠다");
//	}
//
//	@Override
//	public void turnOff() {
//		System.out.println("Tv끈다.");
//	}
//
//}

public class Ex07_03_익명 {

	public static void main(String[] args) {
//		Tv t = new Tv();
//		t.turnOff();
//		t.turnOn();
//		
		
		//완성된 RemoteControl 메소드가 두개일떄 하나씩바껭 호출을 할수밖에없드아
		new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("Tv켠다");
			}//turnOn()
		
			@Override
			public void turnOff() {
				System.out.println("Tv끈다.");
			}//turnOff()
		};
		
		//익명클래스 객체를 만들수있다!
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("Tv킨다");
			}
			
			@Override
			public void turnOff() {
				System.out.println("Tv끈다");
			}
		};
		rc.turnOff();
		rc.turnOn();
		
		}

}
