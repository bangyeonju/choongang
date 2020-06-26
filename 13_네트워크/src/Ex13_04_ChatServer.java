import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Ex13_04_ChatServer extends JFrame implements ActionListener {
	BufferedReader in = null;
	BufferedWriter out = null;
	ServerSocket listener = null;
	Socket socket = null;
	JTextField serverMessage;
	JScrollPane spane;
	Receiver clientMessage;
	
	
	public Ex13_04_ChatServer() {
		setTitle("서버 채팅 창"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		clientMessage = new Receiver(); 
						// 클라이언트에서 받은 메시지를 출력할 컴포넌트
		clientMessage.setEditable(false); 
		
		Thread t = new Thread(clientMessage); 
		
		serverMessage = new JTextField();
		serverMessage.addActionListener(this);
		spane = new JScrollPane(clientMessage); 
		
		add(spane,BorderLayout.CENTER);
		add(serverMessage,BorderLayout.SOUTH);
		setSize(400, 200);
		setVisible(true);
		
		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
			e.printStackTrace();
		}
		t.start();
	}
	
	private void setupConnection() throws IOException {
		listener = new ServerSocket(9999); // 서버 소켓 생성
		socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
		System.out.println("연결됨");
		in = new BufferedReader(new InputStreamReader(
				socket.getInputStream())); // 클라이언트로부터의 입력 스트림 //읽어들이는 
		
		out = new BufferedWriter(new OutputStreamWriter(
				socket.getOutputStream())); // 클라이언트로의 출력 스트림//클라이언트로 데이터를 내보내기 위한 연결다리...
	}
	
	public static void main(String[] args) {
		Ex13_04_ChatServer frame = new Ex13_04_ChatServer();
	}

	private static void handleError(String string) {//에러가 발생했을때 에러 출력
		System.out.println(string);
		System.exit(1); 
	}
	
	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() { 
			String inputMessage=null;
			while (true) {
				try {
					inputMessage = in.readLine(); 
				} catch (IOException e) {
					handleError(e.getMessage());
					e.printStackTrace();
				}
				clientMessage.append("\n" + inputMessage);
				int pos = clientMessage.getText().length();
				clientMessage.setCaretPosition(pos); //화면의 위치를 가장마지막에쓴글자가 보이게!
				
			}
		}
	} 

	@Override
	public void actionPerformed(ActionEvent e) { 
		if (e.getSource() == serverMessage) { 
			String outputMessage = serverMessage.getText(); 
			try {
				out.write("서버>" + outputMessage+"\n"); // 클라이언트로 문자열 전송
				out.flush();
				clientMessage.append("\n서버>" + outputMessage); 
				int pos = clientMessage.getText().length();
				clientMessage.setCaretPosition(pos); 
								// caret 포지션을 가장 마지막으로 이동
				serverMessage.setText(null); 
			} catch (IOException e1) {
				handleError(e1.getMessage());
				e1.printStackTrace();
			} 
		}
	}
}



