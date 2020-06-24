import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ExPanel extends Frame implements ActionListener {

	Button b1, b2, b3,b4;	 // b1 cannot be resolved to a variable

	ExPanel(String title) {
		super(title);
		super.setSize(400, 300);
		super.setResizable(false);
		super.setVisible(true);

//		setLayout(new BorderLayout());
		setLayout(new FlowLayout());

		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
//		Panel p4 = new Panel();


		p1.setBackground(Color.green);
		p2.setBackground(Color.DARK_GRAY);
		p3.setBackground(Color.orange);
//		p4.setBackground(Color.magenta);
		
		b1 = new Button("��ư1");
		b2 = new Button("��ư2");
		b3 = new Button("��ư3");
		b4 = new Button("��ư4");
		
		b1.addActionListener(this);// this�� ���� Ŭ���� ExPanel //addActionListener��--> actionPerformedȣ��
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		b1.setBackground(Color.cyan);
		b2.setBackground(Color.yellow);
		b3.setBackground(Color.PINK);
		b4.setBackground(Color.blue);
		

		p1.add(b1);
		p2.add(b2);
		p3.add(b3);
		p3.add(b4);
		this.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				}
				);

		// BorderLayout�� ����
		super.add(p1, "North"); 
		super.add(p2, "South");
		super.add(p3, "Center");
		super.add(b4);
	}

	@Override
//	ActionEvent e = new ActionEvent() �ڵ����� ��ü�� ��������� // (*���ܰ� �߻��ϸ� �ڵ����� ��ü�� ���������.)
	public void actionPerformed(ActionEvent e) { // ��ư�� ������ �ڵ����� ȣ��ȴ�
//		System.out.println("action Event �߻�");
		Object obj = e.getSource();
	
		if (obj == b1) {
			super.setBackground(Color.lightGray);
		} else if (obj == b2) {
			super.setBackground(Color.red);
		} else if (obj == b3) {
			super.setBackground(Color.BLACK);
		} else if(obj == b4) {
			super.setBackground(Color.white);
		}

	}

}

public class Ex12_02_Panel {

	public static void main(String[] args) {
		ExPanel ex = new ExPanel("panel ����");
//			ex.setVisible(true);

	}

}
