
public class Ex05_17_�濬�� {

	public static void main(String[] args) {

		Music m1 = new Music(); // ������ ���� �ʱ�ȭ

//		m1 : getter ���� ���
		System.out.print("����:" + m1.getTitle() + " ");
		System.out.print("����:" + m1.getSinger() + " ");
		System.out.print("�帣:" + m1.getGenre() + " ");
		System.out.print("����:" + m1.getPrice() + " ");
		System.out.println();
//		m2 : �޼�Ʈ�ȿ��� ���
		System.out.println();
		Music m2 = new Music("���̾�", "��Ź", "Ʈ��Ʈ", 3000);
		m2.display();

//		m3 : �޼��忡�� ������� 4�� �ѹ��� ���Ϲ޾� ���
		System.out.println();
		Music m3 = new Music(); // setter�����ʱ�ȭ
		m3.setTitle("�ܹ߸Ӹ�");
		m3.setSinger("������");
		m3.setGenre("��");
		m3.setPrice(5000);
		System.out.println(m3.show());
		Music[] ms = new Music[4];
		ms[0]= new Music();
		ms[1]= new Music("�Ѽ�", "������", "�߶��", 2000);
		ms[2]= new Music();
		ms[2].setTitle("�ܹ߸Ӹ�");
		ms[2].setSinger("������");
		ms[2].setGenre("�߶��");
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
	// �������� Ư¡*
	// ��ü�� ����� �ڵ����� ����
	// Ŭ������ �̸��� ����
	// ����Ÿ���� ����.

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
	// �Ű������� �ִ� �����ڸ� �����...�Ű��������� �����ڴ� ��������� �ʴ´�
	public Music() {
		super();
		title = "���ø��";
		singer = "������";
		genre = "�߶��";
		price = 1000;

	}

	public Music(String title, String singer, String genre, int price) { // �Ű������ִ� ������
		super();
		this.title = title;
		this.singer = singer;
		this.genre = genre;
		this.price = price;

	}

	String show() {
		return "����:" + title + "����:" + singer + "�帣:" + genre + "����:" + price;
	}

	void display() {
		System.out.print("����:" + title);
		System.out.print("����:" + singer);
		System.out.print("�帣:" + genre);
		System.out.print("����:" + price);
		System.out.println();

	}

}
