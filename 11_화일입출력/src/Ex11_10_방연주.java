
public class Ex11_10_방연주 {

	public static void main(String[] args) throws Exception {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		FileOutputStream fos = new FileOutputStream("voca.txt",true);
//		FileInputStream fis = new FileInputStream("voca.txt");
		
//		HashMap<String, String> map = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
	
		while (true) {
			int i = 0;
			String text;
			System.out.println("1.단어입력 2.단어검색 3.종료 >>");
			i = sc.nextInt();
			
			switch (i) {
			case 1:
				System.out.println("단어/뜻입력>>");
				text = br.readLine();
				while ((text=br.readLine())!=null) {
					
				}
			
				break;

			case 2:
				System.out.println("검색 단어 입력>>");
				break;

			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;

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
