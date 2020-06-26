import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Ex13_04_ChatClient extends JFrame implements ActionListener {
	BufferedReader in = null;
	BufferedWriter out = null;
	Socket socket = null;
	Receiver serverMessage;
	JTextField clientMessage;
	JScrollPane spane;
	PrintWriter pw;

	public Ex13_04_ChatClient() {
		setTitle("클라이언트 채팅 창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		serverMessage = new Receiver(); // 서버에서 받은 메시지를 출력할 컴퍼넌트
		serverMessage.setEditable(false);

		Thread t = new Thread(serverMessage);

		clientMessage = new JTextField();
		clientMessage.addActionListener(this);

		spane = new JScrollPane(serverMessage);
		add(spane, BorderLayout.CENTER);
		add(clientMessage, BorderLayout.SOUTH);
		setSize(400, 200);
		setVisible(true);

		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		t.start();
	}

	private void setupConnection() throws IOException {
		socket = new Socket("172.30.1.6", 9999); // 클라이언트 소켓 생성
		System.out.println("연결됨");

		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 서버로부터의 입력 스트림

		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 서버로의 출력 스트림

	}

	public static void main(String[] args) {
		Ex13_04_ChatClient frame = new Ex13_04_ChatClient();
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}

	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String inputMessage = null;
			while (true) {
				try {
					inputMessage = in.readLine();
				} catch (IOException e) {
					handleError(e.getMessage());
				}
				serverMessage.append("\n" + inputMessage);
				int pos = serverMessage.getText().length();
				serverMessage.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clientMessage) {
			String outputMessage = clientMessage.getText();
			try {
				out.write("클라이언트>" + outputMessage + "\n");
				out.flush();

				serverMessage.append("\n클라이언트>" + outputMessage);
				int pos = serverMessage.getText().length();
				serverMessage.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
				clientMessage.setText(null);//깨긋하게된다
			} catch (IOException e1) {
				handleError(e1.getMessage());
			}
		}
	}
}
