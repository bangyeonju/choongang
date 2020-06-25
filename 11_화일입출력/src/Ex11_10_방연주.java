import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Ex11_10_방연주 {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw=null;
		BufferedReader br = null,br2 = null;
		Scanner sc = new Scanner(System.in);
		boolean flag = false;

		while (true) {
			int i = 0;
			int input;
			System.out.println("1.단어입력 2.단어검색 3.종료 >>");
			input = sc.nextInt();
			String str;
			switch (input) {
			case 1:
				System.out.print("단어/뜻입력>>");
				br = new BufferedReader(new InputStreamReader(System.in));//키보드와 연결다리! 왜만들었나? 키보드로 입력받은걸 읽어들이는 작업!
				str = br.readLine();//공백까지 읽어들인당 //한줄읽는당
				System.out.println(str);
//				Reader : 2바이트읽어들일수있다/한글을 읽어들일때 사용
				
				//데이터를 쓰기위한 연결다리! 버퍼를 이용해서 데이터가 한번에 전달될수있게!//버퍼는 용량이차야 넘어간다.
				bw = new BufferedWriter(new FileWriter("c:\\sun\\voca.txt",true)); // true 기존에 있던 내용에 추가된다.
				bw.write(str);//써라
				bw.newLine();
//				bw.close(); 이것도됨!
				bw.flush();
				break;

			case 2:
				System.out.println("검색 단어 입력>>");
				br = new BufferedReader(new InputStreamReader(System.in));//키보드와 연결다리
				str =br.readLine(); // 아까입력한단어를 
				String line;
				//한줄씩읽어들이는 작업! -> voca.txt를 읽어들이는 연결다리필요하다
				br2= new BufferedReader(new FileReader("c:\\sun\\voca.txt"));
				while((line = br2.readLine()) != null) {
					flag = false;
//					System.out.println(line); //line = apple/사과
					String[] token =line.split("/");// /을 기준으로 쪼개라 // token[0]:apple token[1]:사과
					if(token[0].equals(str)) {//토큰 0번방과 내가 입력한 단어와 같니?
						System.out.println("단어>"+token[0]);
						System.out.println("뜻>"+token[1]);
						flag = true;
						break;
					}
				
				}
				if(flag == false) 
					System.out.println("찾는단어없음");
			
				break;

			case 3:
				System.out.println("프로그램을 종료합니다.");
				
				if(bw!=null) 
					br.close();//반드시 해야한다// null로 초기화해줘야한당
				if(bw!=null)
					bw.close();
				System.exit(0);

			default:
			}
		}
	}

}
//입력한 단어/뜻은 voca.txt에 쓰기
//1.단어입력 2.단어검색 3.종료 >> 1
//단어/뜻 입력>>apple/사과
//
//1.단어입력 2.단어검색 3.종료 >> 1
//단어/뜻 입력>>blue sky/파란 하늘
//
//1.단어입력 2.단어검색 3.종료 >> 2
//검색 단어 입력>>apple
//단어>apple
//단어의 뜻>사과
//
//1.단어입력 2.단어검색 3.종료 >> 2
//검색 단어 입력>>summer
//찾는 단어 없음
//
//1.단어입력 2.단어검색 3.종료 >> 3
//프로그램 종료합니다.
