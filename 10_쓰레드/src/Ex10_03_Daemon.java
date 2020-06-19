import java.awt.dnd.Autoscroll;

class DaemonTest extends Thread {
	public void run() {
		while (true) {
			try {
				sleep(3 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (Ex10_03_Daemon.autoSave == true) {
				autoSave();//
				
			}
		}

	}// run

	public void autoSave() {
		System.out.println("�۾�ȭ���� �ڵ� ����Ǿ����ϴ�.");
	}
}

public class Ex10_03_Daemon {

	static boolean autoSave = false;

	public static void main(String[] args) {

		DaemonTest t = new DaemonTest();
		t.setDaemon(true); //main�̳������ ���������嵵 ����ɼ��ְԲ�....*
		t.start();
		for (int i = 1; i <= 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(i);
			if (i == 5)
				autoSave = true;
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
}
