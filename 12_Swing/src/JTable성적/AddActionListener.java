package JTable����;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddActionListener implements ActionListener{
	JTable  table;
	JTextField[] tf =  new JTextField[4];
	String[] str = new String[4];
						//�Ѿ���� ���״�� �޴´�
	 AddActionListener(JTable table, JTextField[] tf) { //�Ѿ�� ������ �ּҵ��� �־��ش� 
		 this.table = table;
		 for(int i=0;i<tf.length;i++) {
			 this.tf[i] = tf[i];
		 }
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("�߰�");
//		System.out.println(tf[0].getText());
//		System.out.println(tf[1].getText());
		
		for(int i=0;i<tf.length;i++) {
			str[i] = tf[i].getText();
		}
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addRow(str);//������ ������ �߰�
		for(int i=0;i<tf.length;i++) {
			tf[i].setText("");
		}
	
	}

}
