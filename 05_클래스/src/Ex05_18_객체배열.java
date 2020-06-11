class Book{
	private String title;
	private int price;
	
	//생성자
	Book(String title, int price){
		this.title=title;
		this.price= price;
		
	}
	Book(){
		
	}
	void display() {
		System.out.println("title"+title);
		System.out.println("price"+price);
		System.out.println();
	}
	void setTitle(String title){
		this.title = title;
	}
	void setPrice(int price) {
		this.price = price;
		
	}
	String getTitle() {
		return  title;
	}
	int getPrice() {
		return price;
	}
}
public class Ex05_18_객체배열 {

	public static void main(String[] args) {
		int i=2,b=2,c=3;
		int[] arr1 = {1,2,3};
		
		int[] arr2 = new int[] {1,2,3};
		
		int[] arr3 = new int[3];
		arr3[0]=1;
		arr3[1]=2;
		arr3[2]=3;
		
		Book b1 =new Book("자바",1000);
		Book b2 = new Book("HTML",2000);
		
		b1.display();
		b2.display();
		System.out.println("---------------------------------");
		//배열을 이용해서 출력1
//		Book[] bk = new Book[3];//주소가 들어오ㅏ있지않고 공간만 생성됨@
//		bk[0] = new Book("자바",1000);//이때 객체생성 
//		bk[1] = new Book("HTML",2000);//이때 객체생성
//		bk[2] = new Book(); //JSP,3000 =>setter메서드
		
		//배열을 이용해서 출력2
		Book[] bk= {
				new Book("자바",1000),
				new Book("HTML",2000),
				new Book()
				};
		
		bk[2].setTitle("JSP");
		bk[2].setPrice(3000);
		
		bk[0].display();
		bk[1].display();
		bk[2].display();
		System.out.println("**********************");
		
		for(i=0;i<bk.length;i++) {
			bk[i].display();
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(bk[2].getPrice());
		System.out.println(bk[2].getTitle());
		
	}

}
