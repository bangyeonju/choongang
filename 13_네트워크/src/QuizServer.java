import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class QuizServer {
	public static void main(String[] args) throws IOException {

		ServerSocket ss = null; // 서버소켓
		Socket cs = null;//클라이언트 소켓
		ss= new ServerSocket(9999);
		System.out.println("Server ready...");
		cs = ss.accept();
		System.out.println("연결됨.");

		PrintWriter out = new PrintWriter(cs.getOutputStream(),true);//클라이언트로 문제를 보내려는 연결다리

		BufferedReader in = new BufferedReader(
				new InputStreamReader(cs.getInputStream()));//문제를 읽어들이는 연결다리

		String inputLine, outputLine;
		QuizProtocol qp = new QuizProtocol();
		outputLine = qp.process(null);//null를 보냇당
		out.println(outputLine);

		while((inputLine = in.readLine())!=null) {
			outputLine = qp.process(inputLine);
			System.out.println(outputLine);
			out.println(outputLine); //ln꼭쓸것

			if(outputLine.equals("quit"))
				break;
		}
		out.close();
		in.close();
		cs.close();
		ss.close();


	}

}
