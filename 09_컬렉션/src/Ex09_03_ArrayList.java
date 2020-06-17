import java.util.ArrayList;

public class Ex09_03_ArrayList {
	public static void main(String[] args) {
		ArrayList<String> fruit = new ArrayList<String>();
		fruit.add("banana");
		fruit.add("orange");
		fruit.add("apple");
		System.out.println(fruit.toString());
		System.out.println(fruit.get(1));
		fruit.add(2, "melon");
		System.out.println(fruit.toString());
		
		} 
}
