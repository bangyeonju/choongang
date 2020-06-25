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
	Choice ch1;
	Choice ch2;
	Label lb2;
	
	String [][] ���� = { {"�ѱ�","�Ϻ�","�߱�"},
						{"����","������","������"},
						{"����Ʈ","���","�찣��"}
					   };
	Ex12_06_�濬��(String title) {
		super.setTitle(title);
		Label lb1= new Label("����� ���� �����ϼ���"); 
		lb1.setBackground(Color.cyan);
		lb1.setAlignment(Label.CENTER);
		
		lb2= new Label();
		lb2.setBackground(Color.pink);
		lb2.setAlignment(Label.CENTER);// �߾����� ����
		//choice�ΰ��� �гο� ����
		 ch1= new Choice();
		 ch2= new Choice();
		
		Panel p = new Panel();
	
		p.add(ch1);
		p.add(ch2);
		
		super.add(lb1,"North");
		super.add(p,"Center");
		super.add(lb2,"South");
		
		
		for(int i=0;i<���.length;i++) {
			ch1.add(���[i]);
			
		}
		ch2.add("                          ");
	
		setSize(300, 200);
		setVisible(true);
	
		ch1.addItemListener(this);//ItemEvent�� �߻��ʸ� �ڵ����� ItemEvent()��ü���� =>ItemStateChanged()�� ȣ��
		ch2.addItemListener(this);//ItemEvent�� �߻��Ǹ� �ڵ����� ItemEvent()��ü���� ! =>ItemStateChanged()�� ȣ��
		
			
//		Frame�����ɳֱ�
//		x������ â������
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);
			}
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
		Object obj = e.getSource();//��Ȯ���̺�Ʈ�ҽ��� ���´�
		String str = "������ ����� ����� :";
		if(obj==ch1){
			ch2.removeAll();//���������ִ����� �����
			int index = ch1.getSelectedIndex();
			for(int j=0;j<����[index].length;j++) {//������ [index]�ุŭ
				ch2.add(����[index][j]);
			}
		} 
		else if(obj==ch2) {
			str += ch1.getSelectedItem()+":";
			
			str += ch2.getSelectedItem();
			lb2.setText(str);
			
		}
	}
	
	

}
