import java.text.SimpleDateFormat;
import java.util.Date;


public class Ex08_08_Date {

	
	public static void main(String[] args) {
		Date now =new Date();//now ��������
//		Date now = new Date(120,5, 17);//(���ؿ���-1900)
		//Date now = new Date("2020/6/17");
		System.out.println(now);//�������� == ��������.toString
//		System.out.println(now.toString()); //Object toString�� ���? ==> �ּҸ���*
		System.out.println(now.getMonth());
		System.out.println(now.getDay()); //����
		System.out.println(now.getDate());
		System.out.println(now.getMinutes());
	
		 
		
		SimpleDateFormat sdf1,sdf2,sdf3;
		sdf1=new SimpleDateFormat("YY-MM-d�� E����");
		System.out.println(sdf1.format(now)); //���ο����Ŀ����߾� ���!
		
		sdf2=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
		System.out.println(sdf2.format(now));
		
		sdf3=new SimpleDateFormat("YYYY��");
		System.out.println(sdf3.format(now));
	}
	

}

