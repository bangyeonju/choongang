import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11_08_InputStreamReader {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		InputStream is = System.in;//표준입력장치==>'키보드'  1byte만 입력받을수있다.->영어나 숫자만 입력가능!
//		InputStreamReader ir = new InputStreamReader(is); //InputStreamReader2byte도 입력받을수있게하겠다 ->한글도 가능!!!
//		BufferedReader br  = new BufferedReader(ir);
		
		try {
			System.out.print("파일이름입력 :");
			String fileName = br.readLine(); //readLine();//공백포함해서 엔터치기전까지 데이터를 읽어버린닷

			FileWriter fw = new FileWriter(fileName);// 경로의 폴더가 만들어져있지 않을 때 IOException 발생
			BufferedWriter bw = new BufferedWriter(fw);// 가공

			System.out.println("화일에 저장할 내용을 입력하세요");
			String text;
			int i;
			while ((text = br.readLine()) != null) {
				bw.write(text);
				bw.newLine(); // 엔터친거도 파일에 적용된다

			}

			System.out.println("입력을마칩니당.");
			bw.close();
			br.close();

			BufferedReader br2 = new BufferedReader(new FileReader(fileName));
			String line;
//			br2.readLine();//내가써논 txt파일 한줄씩 을 읽는다
			while ((line = br2.readLine()) != null) {
				System.out.println(line);
			}
			br2.close();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
