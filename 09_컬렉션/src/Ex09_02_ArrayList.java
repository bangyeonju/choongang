import java.util.ArrayList;

public class Ex09_02_ArrayList {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>(); // 문자열로 확정지어라!
		System.out.println("al.size():" + al.size());// al:[윤아, 태얀, 수영, 효연, 수영]
		al.add("윤아");
		al.add("태얀");
		al.add("수영");// 수영
		al.add("효연");
		al.add("수영");// 데이터의 중복을 허용한다. 수영
		System.out.println("al:" + al.toString());
		System.out.println("al.size():" + al.size());
		System.out.println(al.get(0));// arrayLish 순ㅅㅓ가있다*
		System.out.println(al.get(2));
//		length:배열의 방의 개수
//		length():문자열의갯수
//		size():컬렉션 저장공간의 크기

		al.add(1, "서현");// 특정 위치에 삽입가능 al:[윤아, 서현, 태얀, 수영, 효연, 수영]
//		al.add(10, "서현"); error
		System.out.println("al:" + al.toString());

		String s = "hello";
		System.out.println("s:" + s.toString());// 즈소값이안나오고 toString이 오버라이딩되있어서 값이나온다
//		System.out.println(str.length());

		ArrayList<String> add = new ArrayList<String>();
		add.add("아이유");
		add.add("수지");

		al.addAll(add);
		System.out.println(al.toString());
		System.out.println(al.size());

		String str = al.remove(1);// 위치인덱스
		boolean b = al.remove("수영");//
		System.out.println(al.toString());
		System.out.println(al.size());
		System.out.println(str + "," + b);
		al.add("수영");
		System.out.println(al.toString());

		ArrayList<String> rm = new ArrayList<String>();
		rm.add("수영");
		
		al.removeAll(rm);
		System.out.println(al.toString());
		System.out.println(al.size());
		
		int pos = al.indexOf("효연");		
		System.out.println("pos"+pos);
		pos = al.indexOf("웬디");
		System.out.println("pos"+pos);// 0보다 작은숫자 나오면 없음
		
		boolean isExist = al.contains("효연");
		System.out.println("isExist:"+isExist);
		
		isExist = al.contains("웬디");
		System.out.println("isExist:"+isExist);
		
		
		al.set(1, "유리");
		System.out.println(al.toString());
		System.out.println(al.size());
		
		
		al.clear();
		System.out.println(al.toString());
		System.out.println(al.size());
		
		
		ArrayList<Integer> al2 = new ArrayList<Integer>(); // integer형으로!
		al2.add(10);
		al2.add(20);
		al2.add(30);
		System.out.println("al2:" + al2.toString());// ArrayList가 위에 아버지나 할아버지에게서 toString을 상속받아 주소값이아니고 값이나온다.
		System.out.println("al2.size():" + al2.size());
		System.out.println(al2.get(1));// 입력값에 따라 integer나string 등 return값이 다르다.

	}
}
///컬렉션은 자동으로 메모리를 확장할수이있다.
//동적으로 메뫼를 ㄹ확장할수이따ㅏ.
