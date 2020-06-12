class Robot {

}

class DanceRobot extends Robot {
	void dance() {
		System.out.println("������ô�.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("�뷡�� �մϴ�");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("�׸��� �׸��ϴ�.");
	}
}

public class Ex06_08_������ {
	public static void main(String[] args) {
		int a, b, c;
//		int[] arr = { 1, 2, 3 };

//		Robot[] rt= new Robot[3];

		Robot[] arr = {  
				new DanceRobot(),
				new SingRobot(),
				new DrawRobot() 
				};
		Robot da = new DanceRobot(); // ��ĳ����
//		Robot da = (Robot) DanceRobot(); //��ĳ����
//		da.dance(); 

		Robot sr = new SingRobot();
		// sr.sing();

		Robot dr = new DrawRobot();
//		dr.draw();
		int i;
		for (i = 0; i < arr.length; i++)
			action(arr[i]);
	}// main
//	Robot r = (Robot)new DanceRobot(); �ڵ����� ��ĳ����
	
	static void action(Robot r) {
		if(r instanceof DanceRobot){
			DanceRobot da = (DanceRobot)r; //�ٿ�ĳ���� 
			da.dance();						//�θ�r�� �޼��� dance�� ���⶧���� -> �ٿ�ĳ���������� �ڽ���dance�� �����ϱ�����?
	
		}
		else if(r instanceof SingRobot) {
			SingRobot sr = (SingRobot)r;
			sr.sing();
		}
		else if(r instanceof DrawRobot) {
			DrawRobot dr = (DrawRobot)r;
			dr.draw();
		}
	
	}
}
