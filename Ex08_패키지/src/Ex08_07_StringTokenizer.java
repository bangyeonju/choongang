import java.util.StringTokenizer;

public class Ex08_07_StringTokenizer {
	public static void main(String[] args) {
		StringTokenizer str = new StringTokenizer("2020/6|16,15:45",",/:");//앞에문자열을 구분자(,/:)만나면 잘라낸다 -> 4덩어리됨!
		int count;
		count =str.countTokens(); //끊어내는 작업 =>파싱
		System.out.println("count:"+count);
		
		while(str.hasMoreTokens()) {
			String s = str.nextToken();
			System.out.println("s:"+s);
			
			}
		
		
		
		
	}
	
}
