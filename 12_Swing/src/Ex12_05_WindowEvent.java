import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WAdapter extends Frame {
	WAdapter() {
		setSize(400, 200);
		setBackground(Color.red);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);
			}

			public void windowActivated(WindowEvent e) {
				System.out.println("windowActivated");
			}
		});// Frame
	}

}

public class Ex12_05_WindowEvent {

	public static void main(String[] args) {
		Frame f = new WAdapter();
	}

}
