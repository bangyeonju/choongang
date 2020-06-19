import java.util.ArrayList;

class Top<T> {//확정되지 않은 자료형자리 T
	private T data; //확정되지 않은 자료형자리 T

	void setData(T data) {
		this.data= data;
	}

	T getData() {
		return data;
	}

}
//class Top2 {
//	private int data;
//
//	void setData(int data) {
//		this.data= data;
//	}
//
//	int getData() {
//		return data;
//	}
//
//}

public class Ex09_01_generic {
	//하나의 코드를 여러타입에 대하여 재화룡라해ㅓㅅ
	public static void main(String[] args) {
	Top<String> t1 = new Top<String>();//t1이 관리하는 객체를 String형태로 만들겠다
	t1.setData("Hello");
	System.out.println(t1.getData());
		
	Top<Integer> t2 = new Top<Integer>();
	t2.setData(10);
	System.out.println(t2.getData());
	
	}


}
