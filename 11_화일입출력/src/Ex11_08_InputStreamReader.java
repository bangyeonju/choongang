import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11_08_InputStreamReader {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		InputStream is = System.in;//ǥ���Է���ġ==>'Ű����'  1byte�� �Է¹������ִ�.->��� ���ڸ� �Է°���!
//		InputStreamReader ir = new InputStreamReader(is); //InputStreamReader2byte�� �Է¹������ְ��ϰڴ� ->�ѱ۵� ����!!!
//		BufferedReader br  = new BufferedReader(ir);
		
		try {
			System.out.print("�����̸��Է� :");
			String fileName = br.readLine(); //readLine();//���������ؼ� ����ġ�������� �����͸� �о������

			FileWriter fw = new FileWriter(fileName);// ����� ������ ����������� ���� �� IOException �߻�
			BufferedWriter bw = new BufferedWriter(fw);// ����

			System.out.println("ȭ�Ͽ� ������ ������ �Է��ϼ���");
			String text;
			int i;
			while ((text = br.readLine()) != null) {
				bw.write(text);
				bw.newLine(); // ����ģ�ŵ� ���Ͽ� ����ȴ�

			}

			System.out.println("�Է�����Ĩ�ϴ�.");
			bw.close();
			br.close();

			BufferedReader br2 = new BufferedReader(new FileReader(fileName));
			String line;
//			br2.readLine();//������� txt���� ���پ� �� �д´�
			while ((line = br2.readLine()) != null) {
				System.out.println(line);
			}
			br2.close();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
