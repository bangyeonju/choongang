import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Ex12_06_�濬�� extends Frame implements ItemListener {

	String[] ��� = {"�ƽþ�","����","������ī"};
	//label->��������� �����ϼ��� �����ӿ� ����
	//�����ѳ���� 000 : 000�Դϴ�.
	Label lb1= new Label("����� ���� �����ϼ���"); 
	Label lb2= new Label("������ �����");
	
	
	//choice�ΰ��� �гο� ����
	Choice ch1= new Choice();
	Choice ch2= new Choice();

	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	String [][] ���� = { {"�ѱ�","�Ϻ�","�߱�"},
						{"����","������","������"},
						{"����Ʈ","���","�찣��"}
					   };
	Ex12_06_�濬��(String title) {
		super.setTitle(title);
		setSize(300, 200);

		p1.setBackground(Color.red);
		p2.setBackground(Color.white);
		p3.setBackground(Color.blue);
		
		
		p1.add(lb1);
		p2.add(ch1);
		p2.add(ch2);
		p3.add(lb2);
		add(p1,"North");
		add(p2,"Center");
		add(p3,"South");
		setVisible(true);
		for(int i=0;i<���.length;i++) {
			ch1.add(���[i]);
			
		}
		for(int i=0;i<����.length;i++) {
			for(int j=0;j<����[i].length;j++) {
				ch2.add(����[i][j]);
			}
		}
	
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		this.addWindowListener(new WindowAdapter() {
			
//		Frame�����ɳֱ�
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);
			}
//		x������ â������
			public void windowActivated(WindowEvent e) {
				System.out.println("windowActivated");
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Ex12_06_�濬��("Choice ����");
	
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(ch1.getSelectedItem());
		System.out.println(ch2.getSelectedItem());
//		lb2.setText(lb2+ch1.getSelectedItem());
		
	}
	
	

}
