import java.util.Scanner;

class Fruit{
	private String name;
	private int price;
	
	void setName(String name,int price){
		this.name= name;
	}
	void setPrice(String name, int price) {
		this.price=price;
		
	}
	String getName(){
		return name;
	}
	int getPrice(){
		return price; 
	}
	 Fruit(String name, int price) {
	 }
}
public class test {
	public static void main(String[] args) {
		int price, i; 
		String name;
		Fruit[] f = new Fruit[5];
		
		for(i=0;i<f.length;i++) {
			Scanner sc = new Scanner(System.in);
				System.out.println("과일이름");
				name=sc.next();
				System.out.println("과일가격");
				price=sc.nextInt();
				f[i] = new Fruit(name,price);
		}
//		System.out.println(f[0].getName());
		
	}
}
