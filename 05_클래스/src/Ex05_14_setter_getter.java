import java.util.Scanner;
//���������� (����������)
//private �ܺ�Ŭ���������� �������� ����Ŭ���������� ���ٰ���
//X(default)
//protected
//public

class Tv2 { // ��������� �Ϲ� ������ �ٸ��� �⺻���� ������ �ִ�.

	private String color; // String�� �⺻���� null ��������� private�����ϸ�..?
	private int channel; // int�� �⺻���� 0
	private boolean power; // boolean�� �⺻���� false
//							 double �� �⺻���� 0.0

	void setColor(String c) { // setter �޼��� (�޾ƾ��Ѵ�)
		color = c;
	}

	String getColor() { // getter�޼���(�����Ѵ�)
		return color;
	}

	void setChannel(int c) { // setter �޼���
		// if(c>0)
		channel = c;
	}

	int getChannel() {// getter�޼���
		return channel;
	}

	void setPower(boolean p) { // setter �޼���
		power = p;
	}

	boolean getPower() {// getter�޼���
		return power;
	}

	void channelUp() { // ����
		channel++;
	}

	void power() { // �޼��� ����
		power = !power;
	}
} // TvŬ����

public class Ex05_14_setter_getter {

	public static void main(String[] args) {

		Tv2 t = new Tv2();
		// t.color="����";
		t.setColor("red");
		t.setChannel(235);
		t.setPower(true);
		// t.power=false;

		System.out.println(t.getColor());
		System.out.println(t.getChannel());
		System.out.println(t.getPower());

	}

}
																													