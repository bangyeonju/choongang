import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex11_03_BufferedStream {
	public static void main(String[] args) {
		//�����Ͱ� ���ٸ� ���۸� �̿�����!
		BufferedOutputStream bos;//�ӽ������
		BufferedInputStream bis;
		try {
			FileOutputStream fos = new FileOutputStream("data.txt"); // �������⸸ �Ҽ��ִ�! //1����Ʈ��(��ǥ������ ��������Ǵ½�Ʈ��0)
			bos = new BufferedOutputStream(fos,5);//5��° �Ѳ�����//2����Ʈ��(���ϴ¿뵵�ΰ���!)
			FileInputStream fis = new FileInputStream("data.txt");
			bis = new BufferedInputStream(fis,5);

			for (int i = 1; i < 9; i++) {
				System.out.print(i);
				fos.write(48 + i);// 1:1(49) 2:2(50)
			}
			int num;
			// data.txt�� �ִ� 123456789�� ���ڷ� �����ϱ⶧���� �ƽ�Ű�ڵ� ���ڷ� �����ֱ⶧���� char������ ����ȯ?
			System.out.println();
			while ((num = fis.read()) != -1) {
				System.out.print((char) num + " ");
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}

	}
}
