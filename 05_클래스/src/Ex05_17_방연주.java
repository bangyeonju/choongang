
public class Ex05_17_방연주 {

	public static void main(String[] args) {

		Music m1 = new Music(); // 생성자 통한 초기화

//		m1 : getter 통한 출력
		System.out.print("제목:"+m1.getTitle());
		System.out.print("가수:"+m1.getSinger());
		System.out.print("장르:"+m1.getGenre());
		System.out.print("가격:"+m1.getPrice());
//		m2 : 메서트안에서 출력
		System.out.println();

		Music m2 = new Music("찐이야", "영탁", "트로트", 3000);
		System.out.print(m2.show());
		//m3 : 메서드에서 멤버변수 4개 한번에 리턴받아 출력
		System.out.println();
		Music m3 = new Music(); // setter통한초기화
		m3.setTitle("뚜두뚜뚜");
		m3.setSinger("블랙핑크");
		m3.setGenre("댄스");
		m3.setPrice(5000);
		m3.display();
	}

}

class Music {
	private String title;
	private String singer;
	private String genre;
	private int price;

	void setTitle(String title) {
		this.title = title;
	}

	void setSinger(String singer) {
		this.singer = singer;
	}

	void setGenre(String genre) {
		this.genre = genre;
	}

	void setPrice(int price) {
		this.price = price;
	}

	String getTitle() {
		return title;
	}

	String getSinger() {
		return singer;
	}

	String getGenre() {
		return genre;
	}

	int getPrice() {
		return price;
	}

	Music() { // 생성자
		this.title = "우울시계";
		this.singer = "아이유";
		this.genre = "발라드";
		this.price = 10000;

	}

	Music(String title, String singer, String genre, int price) { //생성자
		this.title = title;
		this.singer = singer;
		this.genre = genre;
		this.price = price;
		
	}

	String show(){
		return "제목:" + title +"가수:"+singer+"장르:"+genre+"가격:"+price;
	}
	
	void display() {
		System.out.print("제목:" + title);
		System.out.print("가수:" + singer);
		System.out.print("장르:" + genre);
		System.out.print("가격:" + price);

	}

}
