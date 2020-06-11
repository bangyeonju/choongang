import java.util.Scanner;
//접근제어자 (접근지정자)
//private 외부클래스에서는 못쓰지만 내부클래스에서는 접근가능
//X(default)
//protected
//public

class Tv2 { // 멤버변수는 일반 변수와 다르게 기본값을 가지고 있다.

	private String color; // String의 기본값은 null 멤버변수를 private으로하면..?
	private int channel; // int의 기본값은 0
	private boolean power; // boolean의 기본값은 false
//							 double 의 기본값은 0.0

//	void setColor(String c) { // setter 메서드 (받아야한다)
//		color = c;
//	}
//
//	String getColor() { // getter메서드(뱉어야한다)
//		return color;
//	}
//
//	void setChannel(int c) { // setter 메서드
//		// if(c>0)
//		channel = c;
//	}
//
//	int getChannel() {// getter메서드
//		return channel;
//	}
//
//	void setPower(boolean p) { // setter 메서드
//		power = p;
//	}
//
//	boolean getPower() {// getter메서드
//		return power;
//	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public boolean isPower() { // booolean 자동완성하면 isPower()
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}
	void channelUp() { // 정의
		channel++;
	}

	void power() { // 메서드 정의
		power = !power;
	}
} // Tv클래스

public class Ex05_14_setter_getter {

	public static void main(String[] args) {

		Tv2 t = new Tv2();
		// t.color="빨강";
		t.setColor("red");
		t.setChannel(235);
		t.setPower(true);
		// t.power=false;

		System.out.println(t.getColor());
		System.out.println(t.getChannel());
		System.out.println(t.isPower());

	}

}
																													