import java.util.ArrayList;
import java.util.Scanner;

class Student {
	private String name;
	private int kor;
	private int eng;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public Student(String name, int kor, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	@Override
	public String toString() {
		return name+"/"+kor+"/"+eng;
	}
	
}

public class test {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		String name,retry;
		int eng,kor,i;
		while(true) {
		System.out.println("�̸�");
		name = sc.next();
		System.out.println("����");
		kor = sc.nextInt();
		System.out.println("����");
		eng = sc.nextInt();
		Student s = new Student(name, kor, eng);
		list.add(s);
		System.out.println("���");
		retry= sc.next();
		if(retry.equals("n")) {
			break;
		}
		
		}
		for(i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list);
		
		do {
			boolean flag = false;
			System.out.println("ã���̸�");
			name= sc.next();
			for(i=0;i<list.size();i++) {
			if(name.equals(list.get(i).getName())) {
				System.out.println(list.get(i).getKor());
				System.out.println(list.get(i).getKor());
				flag = true;
				break;
			}
			
			
			if(flag == false) {
				System.out.println("ã�� �̸�����");
				break;
			}
			}
			System.out.println("���");
			retry= sc.next();
			if(retry.equals("n")) {
				
				break;
			}
			
			
		}while(true);
		System.out.println("����");
	}
}
//�̸�:kim
//����:33
//����:44
//���?(y/n) : y
//�̸�:park
//����:77
//����:88
//���?(y/n) : n
//[kim/33/44, park/77/88]
//
//kim/33/44
//park/77/88
//
//ã�� �̸� : park
//����:77
//����:88
//���?y
//ã�� �̸� : choi
//ã�� �̸� ����
//���?n
//���α׷��� �����մϴ�.
//
//