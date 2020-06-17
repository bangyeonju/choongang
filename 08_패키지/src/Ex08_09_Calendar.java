import java.util.Calendar;

public class Ex08_09_Calendar {
	public static void main(String[] args) {
		
		//직접적으로 객체를 못만든다.
//		Calendar cal = new Calendar();//객체을 만들면 생성자호출 calendar은  protected이므로  같은 패키지 +다른패키지만 상속받느 자식만 //직접적으로 객체를 못만든다. 
		
		Calendar cal = Calendar.getInstance();
		System.out.println("cal:"+cal);
		System.out.print("오늘날짜는 " +cal.get(Calendar.YEAR)+"년 ");
		System.out.print(cal.get(Calendar.MONDAY)+1 +"월 ");
		System.out.print(cal.get(Calendar.DATE)+"일");
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)+"요일");
		String[] week = {" ","일","월","화","수","목","금","토"};
		
		System.out.print(week[cal.get(Calendar.DAY_OF_WEEK)]+"요일");
		
		
	}
}
