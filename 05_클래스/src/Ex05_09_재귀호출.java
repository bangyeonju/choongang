
public class Ex05_09_재귀호출 {
	public static void main(String[] args) {
		show(3);
	}
	static void show(int cnt) {
		System.out.println("Hey~~~"+cnt);
		if (cnt ==1)
			return; // 호출된곳으로 리턴됨?
		show(--cnt); // 재귀호출 내가 나를 부르는것!)
		
	}
}
