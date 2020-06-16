class Bike {
	BikeInfo info;
	String color;

	class BikeInfo {
		String model;
		int year;

	  BikeInfo(String model, int year) {
			this.year = year;
			this.model = model;
		}

	void BikeInfoPrint() {
		System.out.println(model);
	}
	}

	Bike(String model, int year, String color) {
		info = new BikeInfo(model, year);
		this.color = color;

	}

	void BikePrint() {
		info. BikeInfoPrint();
		System.out.println(info.model + "," + info.year + "," + color);	}

	

}

public class test {
	public static void main(String[] args) {
		Bike b = new Bike("하이브리드", 2020, "black");
		b.BikePrint();
	}

}
