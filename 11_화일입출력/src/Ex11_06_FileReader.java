import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex11_06_FileReader {
	//파일쓰고읽고
	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		try {
			fw = new FileWriter("write.txt"); // 한글가능
			fw.write("즐거운 자바수업789");
			fw.flush();
			fr = new FileReader("write.txt");
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
