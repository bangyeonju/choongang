import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class ItemEventEx extends Frame implements ItemListener {

	Choice ch = new Choice();
	//�г� �����
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();//

	Label lb = new Label("���� �����ϼ���");// ���ڳְ������ Label
	// 1��
	Label result = new Label("                                         ");
	public ItemEventEx() {
		//��漳���ϰ�
		p1.setBackground(Color.pink);
		p2.setBackground(Color.LIGHT_GRAY);
		p3.setBackground(Color.yellow);
//		result.setBackground(Color.white);
//		setLayout(new BorderLayout());//Frame �� �⺻ ��ġ�����ڴ� BorderLayout());
//		lb.setBackground(Color.white);
		String[] flower = { "���޷�", "���", "��ȭ", "����", "������" };
//		ch.add("���޷�");
//		ch.add("���");
		int i;
		for (i = 0; i < flower.length; i++) {
			ch.add(flower[i]);
		}
		ch.addItemListener(this);//itemStateChanged��ӹ޾ƾ��Ѵ�
		// new ItemEvent() ��ü�� �ڵ��� ���������.
		
		//�����ӿ� ����!
		p1.add(lb);
		p2.add(ch);
		p3.add(result);
		add(p1, "North");
		add(p2, "Center");
		add(p3,"South");
//		super.setSize(400, 300);
//		setVisible(true);
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) { // (ItemEvent e) �Ѿ���� ItemEvent��ü�� ��������
//		System.out.println("����");
		System.out.print(ch.getSelectedIndex()+":");
		System.out.println(ch.getSelectedItem());
		result.setText(ch.getSelectedItem());//���ھ���
	}

}

public class Ex12_03_ItemEvent {
	public static void main(String[] args) {
		// 2��
		ItemEventEx f = new ItemEventEx();
		f.setSize(400, 300);
		f.setVisible(true);
	}
}
