import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex11_03_BufferedStream {
	public static void main(String[] args) {
		//데이터가 많다면 버퍼를 이용하자!
		BufferedOutputStream bos;//임시저장소
		BufferedInputStream bis;
		try {
			FileOutputStream fos = new FileOutputStream("data.txt"); // 내보내기만 할수있다! //1차스트림(목표지점에 직접연결되는스트림0)
			bos = new BufferedOutputStream(fos,5);//5번째 한꺼번에//2차스트림(원하는용도로가공!)
			FileInputStream fis = new FileInputStream("data.txt");
			bis = new BufferedInputStream(fis,5);

			for (int i = 1; i < 9; i++) {
				System.out.print(i);
				fos.write(48 + i);// 1:1(49) 2:2(50)
			}
			int num;
			// data.txt에 있는 123456789을 문자로 생각하기때문에 아스키코드 숫자로 보여주기때문에 char형으로 형변환?
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
