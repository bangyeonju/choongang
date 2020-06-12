class Car {
	private String color;
	private String name;
	private int price;

	void setColor(String color) {
		this.color = color;
	}

	void setName(String name) {
		this.name = name;
	}

	void setPrice(int price) {
		this.price = price;

	}

	String getColor() {
		return color;
	}

	String getName() {
		return name;
	}

	int getPrice() {
		return price;
	}

	Car() {
		this.color = "°ËÁ¤";
		this.name = "º¥Ã÷";
		this.price = 43254534;
	}

	 Car(String color, String name, int price) {
		this.color=color;
		this.name=name;
		this.price=price;
				
	}
	void show(){
		System.out.println(color);
		System.out.println(name);
		System.out.println(price);
	}
	String display() {
		return color+name+price;
	}
	
}

public class test01 {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.setColor("»¡°­");
		c1.setName("bmw");
		c1.setPrice(1000000000);
		System.out.println(c1.getColor());
		System.out.println(c1.getName());
		System.out.println(c1.getPrice());
		System.out.println("---------");
		c1.show();
		System.out.println("---------");
		

		Car c2 = new Car();
		System.out.println(c2.getColor());
		System.out.println(c2.getName());
		System.out.println(c2.getPrice());

		Car c3 = new Car("³ë¶û", "Çö´ë", 5325646);
		System.out.println("==============");
		c3.show();
		System.out.println("==============");
		
		Car c4 = new Car();
		 c4.setColor("Èò»ö");
		 c4.setName("±â¾Æ");
		 c4.setPrice(10000343);
		 c4.show();
		 System.out.println("****************");
		System.out.println(c4.display()); 
		 System.out.println("****************");
	}
}
