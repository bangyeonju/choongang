interface Camera {
	void takePhoto();// 사진찍기
}

interface Mp3 {
	void playMp3();//음악감상
}

interface DMB {
	void viewTv();//TV시청
}

class Shape2 {
	private int size;
	private String color;

		 Shape2(int size, String color) {
		 this.size= size;
		 this.color = color;
	 }
		int getSize(){
			return size; 
		 }
		String getColor() {
			return color;
		}
		
		void display() {
			System.out.println(size);
			System.out.println(color);
		}
}
class Phone extends Shape2 implements Camera,Mp3,DMB{

	Phone(int size, String color) {
		super(size, color);
	}
	public void takePhoto() {
		System.out.println("사진찍기");
	}
	public void playMp3() {
		System.out.println("음악감상");
	}
	public void viewTv() {
		System.out.println("TV시청");
	}
}
public class Ex06_12_방연주{

	public static void main(String[] args) {
		Phone p = new Phone(7,"blue");
		p.viewTv();
		p.playMp3();
		p.takePhoto();
		System.out.println(p.getSize());
		System.out.println(p.getColor());
		
		System.out.println("==================");
		//p.display();
	}

}
