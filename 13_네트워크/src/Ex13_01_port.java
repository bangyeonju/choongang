import java.io.IOException;
import java.net.ServerSocket;

public class Ex13_01_port {

	public static void main(String[] args) {
		ServerSocket ss  = null;
		for(int i =0;i<65535;i++) {
			try {
				ss = new ServerSocket(i);
				ss.close();
			} catch (IOException e) {
				System.out.println(i+"번 포트는 이미사용중");
			}
		}
		
	}

}
