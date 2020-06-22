import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex11_02_FileCopy {

	public static void main(String[] args)   {
		try {
			FileInputStream fis = new FileInputStream("from.txt"); //파일이 꼭있어야한다!!!!
			FileOutputStream fos = new FileOutputStream("to.txt"); //자동으로 만들어진다.
//			false,생략 : 없으면 하나생성됨, 있으면 화일안의 내용 다지워고 새로만들어짐!
//			true : 없으면 하나생성됨, 화일안의 기존의 내용뒤에 추가됨!

			while(true) {
				int i=fis.read();
				if(i==-1) {
					break;
				}
				System.out.print((char)i);
				fos.write(i);
				
			}
			fis.close();//끊어내기!!!
			fos.close();

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
