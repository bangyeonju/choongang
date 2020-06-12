class Car {
	String color = "white";
	int door = 4;

	void drive() {
		System.out.println("Cardrive");

	}

	void stop() {
		System.out.println("Carstop");
	}

}// Car

class FireEngine extends Car {
	int door = 6;
	int wheel = 10;

	void drive() {
		System.out.println("FEdrive");
	}

	void water() {
		System.out.println("water!");
	}
}// fireEngine

public class Ex06_07_다형성 {
	public static void main(String[] args) {
		double a = (double)1; //(double)생략가능
		int b=(int)3.2;//(int)생략불가능
		
		Car c = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		c =(Car)fe; // 자식은 자기것이 있으면 자신것 부터사용하고, 자신 것이없으면 부모한테 접근해서 사용한다. //(Car)생략가능 //업캐스팅(자식타입->부모타입) 자동으로 
		System.out.println(c.door);//4
		System.out.println(c.color);//white
//		System.out.println(c.wheel); 부모는 자식에게 접근할수없다.
		System.out.println(fe.door);
		System.out.println(fe.color);
		System.out.println(fe.wheel);
//					*변수와 메서드의 큰 차이*
		c.drive(); //why Cardrive가 안나오는가?
//					부모에 drive가 없으면 에러 
//			 		부모에 drive가 있으면  -> 자식에 drive메서드가 있는지 확인하고 ->자식 drive호출 
		fe.drive();
		
		if (c instanceof FireEngine) {
			System.out.println("다운캐스팅가능");
		} else {
			System.out.println("다운캐스팅 불가능");
		}
		
		fe2=(FireEngine)c; //(FireEngine)생략 불가능 //자식에 부모를 넣을려면 타입을 맞추어 주어야한다.~
		//다운캐스팅(부모타입->자식타입) 다운캐스팅은 업캐스팅해야 ? 사용가능?
		
		fe2.water();
		fe2.drive();
		
	}
	
} 








