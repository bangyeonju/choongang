import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket cs = null;
		PrintWriter out = null;
		BufferedReader in = null;



		cs = new Socket("localhost",9999);//=>두가지 예외가 발생
		out = new PrintWriter(cs.getOutputStream(),true); //서버로정답을보내는건가?서버와으 ㅣ연결다리
		in = new BufferedReader(new InputStreamReader(cs.getInputStream()));//서버랑 연결된다리// 서버가 문제를 보내면 그것을 읽어들인다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//키보드와의 연결다리

		String fromServer, fromUser;
		while((fromServer = in.readLine())!=null) {
			System.out.println("서버:"+fromServer);
			if(fromServer.equals("quit"))
				break;
			fromUser = br.readLine(); //키보드로 답입력
			if(fromUser != null) {
				System.out.println("클라이언트:"+fromUser);
				out.println(fromUser);
			}
		}
		out.close();
		in.close();
		br.close();
		cs.close();

	}
}
