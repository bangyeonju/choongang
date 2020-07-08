import java.util.ArrayList;
import java.util.Scanner;

//console창

public class PersonMain {

	PersonDao dao = new PersonDao(); //생성자 =>1단계 드라이버로드
	Scanner sc = new Scanner(System.in);
	PersonMain() {
		System.out.println("PersonMain()");
		init(); //init 호출
		
	}

	void init() {
		while (true) {
			System.out.println("\n=======메뉴선택하기=======");
			System.out.println("1.전체 정보 조회");
			System.out.println("2.성별로 조회");
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제 ");
			System.out.println("5.정보 추가");
			System.out.println("6.프로그램 종료");
			System.out.print(">>메뉴 번호 입력:");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				ArrayList<PersonBean> lists = dao.getAllPerson();//리턴값을  lists에 담는다.
				showPerson(lists);
				break;
			case 2:
				inputGender();
				break;
			case 3:
				updateData();
				break;
			case 4:
				deleteData();
				break;
			case 5:
				insertData();
				
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;

			default:
				System.out.println("1~6사이의 번호만 입력가능");
			}
		}
	}//init
	void showPerson(ArrayList<PersonBean> lists) {
		String title="번호\t이름\t나이\t성별\t생년월일";
				System.out.println(title);
				for(int i=0;i<lists.size();i++) {
					
					String result = lists.get(i).getNum()+"\t"+
							lists.get(i).getName()+"\t"+
							lists.get(i).getAge()+"\t"+
							lists.get(i).getGender()+"\t"+
							lists.get(i).getBirth()+"\t";
							System.out.println(result);
							
					
					
//					System.out.print(lists.get(i).getNum()+"\t");
//					System.out.print(lists.get(i).getName()+"\t");
//					System.out.print(lists.get(i).getAge()+"\t");
//					System.out.print(lists.get(i).getGender()+"\t");
//					System.out.print(lists.get(i).getBirth()+"\t");
				}
	}//showPerson
	 void inputGender() {
		 System.out.print("찾으려는 성별 입력 : ");
		 String findGender=sc.next();
			ArrayList<PersonBean> lists = dao.getPersonByGender(findGender);
			if(lists.size()==0) {
				System.out.println("해당 성별은 존재하지 않음");
			} 
			else {
			showPerson(lists);
			}
		 
	 }
	 void insertData() {
		 System.out.println("번호는 시퀀스로 입력됩니다.(생략)");
		 System.out.print("이름입력:");
		 String name =sc.next();
		 System.out.print("나이입력:");
		 int age =sc.nextInt();
		 System.out.print("성별입력:");
		 String gender=sc.next();
		 System.out.print("생년월일 입력:");
		 String birth = sc.next();
		 
		int cnt = dao.insertData(name,age,gender,birth); //dao의insertData로 간다.
		if (cnt<0) {
			System.out.println("insert 실패");
			
		}else {
			System.out.println("insert 성공");
		}
		
	 }
	 void updateData() {
		 System.out.println("수정할 번호 입력");
		 int num =sc.nextInt();
		 //번호를 조건으로 수정
		 System.out.print("이름입력:");
		 String name =sc.next();
		 System.out.print("나이입력:");
		 int age =sc.nextInt();
		 System.out.print("성별입력:");
		 String gender=sc.next();
		 System.out.print("생년월일 입력:");
		 String birth = sc.next();
		 
		 PersonBean bean = new PersonBean(); //정보를 한번에 넘기기위해 personbean 객체 생성
		 
		 bean.setNum(num);
		 bean.setName(name);
		 bean.setAge(age);
		 bean.setGender(gender);
		 bean.setBirth(birth);
		 
		int cnt = dao.updateData(bean);//다섯개의 정보가 한번에 묶여서 dao로 넘어간다
		if(cnt==-1) 
			System.out.println("수정 실패");
		 else if (cnt==0)
			System.out.println("조건에 맞는 데이터 없음");
		else
			System.out.println("수정 성공");

		 
	 }
	 void deleteData(){
		 System.out.print("삭제할 번호 입력: ");
		 int num = sc.nextInt();
		 int cnt = dao.deleteData(num);
		 
		 if(cnt==-1) 
				System.out.println("삭제 실패");
			 else if (cnt==0)
				System.out.println("조건에 맞는 데이터 없음");
			else
				System.out.println("삭제 성공");
		 
	 }
	 
	public static void main(String[] args) {

		new PersonMain();//객체만들면서 생성자호출

	}

}
