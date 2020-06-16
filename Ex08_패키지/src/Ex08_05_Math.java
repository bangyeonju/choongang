
import java.lang.Math.*;
public class Ex08_05_Math {

	public static void main(String[] args) {
		System.out.println(Math.PI);

		System.out.println(Math.abs(-3)); //절대값 |-3|=> 3

		long num1= Math.round(3.856); //반올림
		System.out.println("num1:"+num1);
		
		double num2 = Math.ceil(4.32);
		System.out.println("num2:"+num2);
	
		double num3 = Math.floor(4.7);
		System.out.println("num3:"+num3);
		
		int num4 =(int)(Math.random()*36)+13;
	
		System.out.println("num4:"+num4);
		//13~48
		
	}

}
