import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//text������ �о� console â�� �ѷ��ش�
public class Ex11_02_FileCopy {

	public static void main(String[] args)   {
		try {
			
			FileInputStream fis = new FileInputStream("from.txt"); //������ ���־���Ѵ�!!!!
			FileOutputStream fos = new FileOutputStream("to.txt"); //�ڵ����� ���������.
//			false,���� : ������ �ϳ�������, ������ ȭ�Ͼ��� ���� �������� ���θ������!
//			true : ������ �ϳ�������, ȭ�Ͼ��� ������ ����ڿ� �߰���!

			while(true) {
				int i=fis.read();
				if(i==-1) {
					break;
				}
				System.out.print((char)i);
				fos.write(i);
				
			}
			fis.close();//�����!!!
			fos.close();

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
