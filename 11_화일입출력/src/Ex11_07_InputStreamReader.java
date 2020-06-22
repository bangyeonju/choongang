import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex11_07_InputStreamReader {
	public static void main(String[] args) throws IOException {
		System.out.print("데이터입력:");
		
//		InputStream is = System.in;//표준입력장치==>'키보드'  1byte만 입력받을수있다.->영어나 숫자만 입력가능!
//		InputStreamReader ir = new InputStreamReader(is); //InputStreamReader2byte도 입력받을수있게하겠다 ->한글도 가능!!!
//		BufferedReader br  = new BufferedReader(ir);
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();//공백포함해서 엔터치기전까지 데이터를 읽어버린닷
		System.out.println("str:"+str);
		
	}
}
