class Car {
	CarInfo info; // (model, year) //Ex06_04_����
	String color;

	class CarInfo {// ����Ŭ����
		String model;
		int year;

		CarInfo(String model, int year) {
			this.model = model;
			this.year = year;
		}

		void CarInfoPrint() {
			System.out.println(model + "," + year);
		}
	} // Carinfo

	Car(String model, int year, String color) {
		info = new CarInfo(model, year); //info������ ����
		this.color = color;

	}// Car������
	
	void CarPrint() {
		info.CarInfoPrint();
		
		System.out.println(info.model + "," + info.year + "," + color);
	}
}// Car

public class Ex07_01_inner {

	public static void main(String[] args) {
		
		Car pride = new Car("�����̵�", 2020,"�Ķ�");
		pride.CarPrint();
		pride.info.CarInfoPrint();
	}

}
