class Robot {

}

class DanceRobot extends Robot {
	void dance() {
		System.out.println("춤을춥시다.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("노래를 합니다");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("그림을 그립니다.");
	}
}

public class Ex06_08_다형성 {
	public static void main(String[] args) {
		int a, b, c;
//		int[] arr = { 1, 2, 3 };

//		Robot[] rt= new Robot[3];

		Robot[] arr = {  
				new DanceRobot(),
				new SingRobot(),
				new DrawRobot() 
				};
		Robot da = new DanceRobot(); // 업캐스팅
//		Robot da = (Robot) DanceRobot(); //업캐스팅
//		da.dance(); 

		Robot sr = new SingRobot();
		// sr.sing();

		Robot dr = new DrawRobot();
//		dr.draw();
		int i;
		for (i = 0; i < arr.length; i++)
			action(arr[i]);
	}// main
//	Robot r = (Robot)new DanceRobot(); 자동으로 업캐스팅
	
	static void action(Robot r) {
		if(r instanceof DanceRobot){
			DanceRobot da = (DanceRobot)r; //다운캐스팅 
			da.dance();						//부모r에 메서드 dance가 없기때문에 -> 다운캐스팅을해줘 자식의dance에 접근하기위해?
	
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
