import java.io.File;
import java.io.IOException;

public class Ex11_01_File {
	public static void main(String[] args) {
		String str = null;
//				System.out.println(str.length());
		String a = File.pathSeparator;
		String b = File.separator;
		System.out.println(a);
		System.out.println(b);

		File f1 = new File("c:" + File.separator + "sun" + File.separator + "aaa.txt");
		File f2 = new File("c:\\sun", "aaa.txt");
		File dir = new File("c:\\sun");
		File f3 = new File(dir,"aaa.txt");
		File f4 = new File("c:\\sun\\aaa.txt");
		System.out.println(f1.length());
		System.out.println(f2.length());
		System.out.println(f3.length());
		System.out.println(f4.length());
		
		
		File f5 = new File("A");//A폴더
		File f6 = new File("B");//B폴더
		File f7 = new File("c");
		File f8 = new File(f5,"aa.txt");
		if(f5.exists()) {
			f5.renameTo(f6); //이름바꿀때
			System.out.println("폴더이름바꾸기 성공");
			try {
				f8.createNewFile();//파일을 만드는 도중에 오류발생에 대비해 try catch문 을 ㅗ예외처리\
				System.out.println("파일 생성ㅎ담");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			f5.mkdir();//폴더만들기
			System.out.println("폴더없음");
		}
		if(f7.exists()) {
			boolean bb = f7.delete();
			System.out.println("bb:"+bb);
		}
		
		
	}
}
