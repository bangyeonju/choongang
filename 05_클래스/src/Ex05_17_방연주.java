
public class Ex05_17_방연주 {

	public static void main(String[] args) {

		Music m1 = new Music(); // 생성자 통한 초기화

//		m1 : getter 통한 출력
		System.out.print("제목:" + m1.getTitle() + " ");
		System.out.print("가수:" + m1.getSinger() + " ");
		System.out.print("장르:" + m1.getGenre() + " ");
		System.out.print("가격:" + m1.getPrice() + " ");
		System.out.println();
//		m2 : 메서트안에서 출력
		System.out.println();
		Music m2 = new Music("찐이야", "영탁", "트로트", 3000);
		m2.display();

//		m3 : 메서드에서 멤버변수 4개 한번에 리턴받아 출력
		System.out.println();
		Music m3 = new Music(); // setter통한초기화
		m3.setTitle("단발머리");
		m3.setSinger("조용필");
		m3.setGenre("댄스");
		m3.setPrice(5000);
		System.out.println(m3.show());
		Music[] ms = new Music[4];
		ms[0]= new Music();
		ms[1]= new Music("한숨", "이하이", "발라드", 2000);
		ms[2]= new Music();
		ms[2].setTitle("단발머리");
		ms[2].setSinger("조용필");
		ms[2].setGenre("발라드");
		ms[2].setPrice(50000);
		int i;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(i=0;i<ms.length;i++) {
			System.out.println(ms[i].show());
		}
	}

}

class Music {
	private String title;
	private String singer;
	private String genre;
	private int price;

//	void setTitle(String title) {
//		this.title = title;
////		return;
//	}
//
//	void setSinger(String singer) {
//		this.singer = singer;
//	}
//
//	void setGenre(String genre) {
//		this.genre = genre;
//	}
//
//	void setPrice(int price) {
//		this.price = price;
//	}
//
//	String getTitle() {
//		return title;
//	}
//
//	String getSinger() {
//		return singer;
//	}
//
//	String getGenre() {
//		return genre;
//	}
//
//	int getPrice() {
//		return price;
//	}
	// 생성자의 특징*
	// 객체를 만들면 자동으로 생김
	// 클래스와 이름이 같다
	// 리턴타입이 없다.

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	// 매개변수가 있는 생성자를 만들면...매개변수없는 생성자는 만들어지지 않는다
	public Music() {
		super();
		title = "마시멜로";
		singer = "아이유";
		genre = "발라드";
		price = 1000;

	}

	public Music(String title, String singer, String genre, int price) { // 매개변수있는 생성자
		super();
		this.title = title;
		this.singer = singer;
		this.genre = genre;
		this.price = price;

	}

	String show() {
		return "제목:" + title + "가수:" + singer + "장르:" + genre + "가격:" + price;
	}

	void display() {
		System.out.print("제목:" + title);
		System.out.print("가수:" + singer);
		System.out.print("장르:" + genre);
		System.out.print("가격:" + price);
		System.out.println();

	}

}
