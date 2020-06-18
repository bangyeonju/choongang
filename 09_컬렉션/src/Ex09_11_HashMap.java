import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex09_11_HashMap {
	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		dic.put("pencil", "연필");
		dic.put("sky", "하늘");
		dic.put("desk", "책상");
		dic.put("face", "얼굴");
		System.out.println("dic" + dic);
		Scanner sc = new Scanner(System.in);
		String word;

		do {

			System.out.print("찾는 단어는?(q입력시 종료)");
			word = sc.next();

			if (word.equals("q")) {// 빠져나가는(종료하는)조건 먼저 작성!!!
				break;
			}
			if (dic.get(word) == null) { // 내가 입력한 값이 dic해쉬 value에 없는 값일때
//			if(dic.containsKey(word)==false) { //내가 입력한값이 dic에 포함x 
				System.out.println("잘못입력하셨음!");
			} else {
				System.out.println("뜻:"+dic.get(word));
				
			}

		} while (true);
		System.out.println("프로그램을 종료합니다.");

	}
}
