import javax.swing.JOptionPane;

public class Ex10_02_Thread {

	public static void main(String[] args) {
		NumberPrint np = new NumberPrint();
		np.start();
		
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println("입력한값은 " + input + " 입니다.");
		
		System.out.println("메인끝");
	}

}
class NumberPrint extends Thread{
	public void run() {
		int i;
		for (i = 10; i > 0; i--) {
		System.out.println(i + " ");
		try {
			sleep(1000);
		} catch (Exception e) {
		}
	}
		
	}
}