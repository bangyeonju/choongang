interface RemoteControl {
	void turnOn();
	void turnOff();
}
//
//class Tv implements RemoteControl {
//
//	@Override
//	public void turnOn() {
//		System.out.println("Tv�Ҵ�");
//	}
//
//	@Override
//	public void turnOff() {
//		System.out.println("Tv����.");
//	}
//
//}

public class Ex07_03_�͸� {

	public static void main(String[] args) {
//		Tv t = new Tv();
//		t.turnOff();
//		t.turnOn();
//		
		
		//�ϼ��� RemoteControl �޼ҵ尡 �ΰ��ϋ� �ϳ����ٲ� ȣ���� �Ҽ��ۿ������
		new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("Tv�Ҵ�");
			}//turnOn()
		
			@Override
			public void turnOff() {
				System.out.println("Tv����.");
			}//turnOff()
		};
		
		//�͸�Ŭ���� ��ü�� ������ִ�!
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("TvŲ��");
			}
			
			@Override
			public void turnOff() {
				System.out.println("Tv����");
			}
		};
		rc.turnOff();
		rc.turnOn();
		
		}

}
