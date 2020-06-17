import java.text.SimpleDateFormat;
import java.util.Date;


public class Ex08_08_Date {

	
	public static void main(String[] args) {
		Date now =new Date();//now 참조변수
//		Date now = new Date(120,5, 17);//(올해연도-1900)
		//Date now = new Date("2020/6/17");
		System.out.println(now);//참조변수 == 참조변수.toString
//		System.out.println(now.toString()); //Object toString의 기능? ==> 주소리턴*
		System.out.println(now.getMonth());
		System.out.println(now.getDay()); //요일
		System.out.println(now.getDate());
		System.out.println(now.getMinutes());
	
		 
		
		SimpleDateFormat sdf1,sdf2,sdf3;
		sdf1=new SimpleDateFormat("YY-MM-d일 E요일");
		System.out.println(sdf1.format(now)); //새로운형식에맞추어 출력!
		
		sdf2=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
		System.out.println(sdf2.format(now));
		
		sdf3=new SimpleDateFormat("YYYY년");
		System.out.println(sdf3.format(now));
	}
	

}

