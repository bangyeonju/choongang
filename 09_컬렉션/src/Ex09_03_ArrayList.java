import java.util.ArrayList;
import java.util.Scanner;
class Food{
	 String name;
	int price;
	
	public String toString(String name , int price) {
		return name + price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	Food(String name, int price){
		
	}
}
public class Ex09_03_ArrayList {
	public static void main(String[] args) {
		ArrayList<String> fruit = new ArrayList<String>();
		ArrayList<Food> list = new ArrayList<Food>();
		fruit.add("banana");
		fruit.add("orange");
		fruit.add("apple");
		System.out.println(fruit.toString());
		System.out.println(fruit.get(1));
		fruit.add(2, "melon");
		System.out.println(fruit.toString());
		Scanner sc = new Scanner (System.in);
		String name= sc.next();
		int price = sc.nextInt();
		Food f = new Food("¹Ù³ª³ª",100);
		list.add(f);
		System.out.println(list);
			
		} 
}
