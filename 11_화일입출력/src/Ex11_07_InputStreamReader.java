import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex11_07_InputStreamReader {
	public static void main(String[] args) throws IOException {
		System.out.print("�������Է�:");
		
//		InputStream is = System.in;//ǥ���Է���ġ==>'Ű����'  1byte�� �Է¹������ִ�.->��� ���ڸ� �Է°���!
//		InputStreamReader ir = new InputStreamReader(is); //InputStreamReader2byte�� �Է¹������ְ��ϰڴ� ->�ѱ۵� ����!!!
//		BufferedReader br  = new BufferedReader(ir);
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();//���������ؼ� ����ġ�������� �����͸� �о������
		System.out.println("str:"+str);
		
	}
}
