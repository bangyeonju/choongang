import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Ex13_03_Server {
	public static void main(String[] args) {

		ServerSocket ss = null;
		BufferedReader br = null;
		
		try {
			ss = new ServerSocket(9999);
			
		} catch (IOException e) {
			System.err.println("9999번 포트번호는 이미 사용중");
			System.exit(1);
		}
		
		Socket cs = null;
		try {
			System.out.println("Server ready..");
			cs = ss.accept();
			
		} catch (IOException e) {
			
			System.out.println("accept 실패");
			System.exit(1);
		}

		try {
			br = new BufferedReader(
					new InputStreamReader(cs.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String line = br.readLine();
			
			System.out.println("클라이언트에서 넘어온 데이터 : "+line);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			br.close();
			cs.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}






