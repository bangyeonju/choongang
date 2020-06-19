import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Movie {
	private String title;
	private int age;
	
	Movie(String title , int age){
		super();
		this.title = title;
		this.age = age ;
	}
	void setTitle(String title) {
		this.title= title;
	}
	void setAge(int age) {
		this.age = age;
	}
	String getTitle() {
		return title;
	}
	int getAge() {
		return age;
	}
	public String toString() {
		return title +"/" + age;
	}
	
}

public class Ex09_12_HashMap {
	public static void main(String[] args) {
		Map<String ,Movie> hm = new HashMap<String,Movie>();
		Movie m1 = new Movie("결백", 15);
		Movie m2 = new Movie("침입자", 19);
		Movie m3 = new Movie("아이언맨", 12);
		
		hm.put(new String("롯데시네마"), m1);
		hm.put("서울극장", m2);
		hm.put("메가박스", m3);
//		hm.put("서울극장", m1);//KEY값이 중복!
		hm.put("CGV", m1);
		int i;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("영화관 : ");
		String theater = sc.next();
		
		if(hm.get(theater)== null) {
			System.out.println("영화관 잘못입력");
		}
		else {
			System.out.println(hm.get(theater));
		}
		Movie m4 = new Movie("곡성", 15);
		hm.replace("서울극장", m4);
		System.out.println(hm);
		
		hm.remove("CGV");
		System.out.println(hm);
		
		hm.clear();
		System.out.println(hm);
		
		
	}
}
