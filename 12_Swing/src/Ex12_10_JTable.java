import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class JTableEx extends JFrame {
	int cnt = 1;//����/���� �����ϱ������ʟG��
	Vector<String> columnNames = null;
//Vector<String> rowData = null; //�ѻ������ ����..
	Vector<Vector<String>> rowData = null;// ���ߺ��ͷ� ������ ����!=>�迭�� ������Ű�亸�� �÷������λ���ؼ� �����Ӱ� �������ִ�?

	JTableEx(String title) {
		super(title);// ����
		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();

		getFile();
		compose();
		setSize(500, 200);
		setVisible(true);

	}// ������

	private void compose() {
		JTable table = new JTable(rowData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		Container contentPane = getContentPane();//��������
		contentPane.add(scrollPane, BorderLayout.CENTER);// ��ũ�ѻ���

		JButton btn = new JButton("���");
		btn.addActionListener(new TablePrint(table));//table������ TablePrint�� ������
		contentPane.add(btn,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);//ȭ������
		
	}

	void getFile() { // ������ �������
		File f = new File("table.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while ((str = br.readLine()) != null) {
//				System.out.println(str);table.txt���Ͽ� �ִ°� ��� �д´�
				TableMake(str);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// getFile

	void TableMake(String str) {
//		str:�̸�/����/����/����
		String[] split = str.split("/");
		if (cnt == 1) {
			for (int i = 0; i < split.length; i++) {
				columnNames.add(split[i]);
			}
			cnt++; // 2
		} else {
//			str:����/77/88/99
			Vector<String> one = new Vector<String>();// ����(�ѻ��)�� ��� �ӽú��͸� ����

			for (int i = 0; i < split.length; i++) {
				one.add(split[i]);
			}
//			System.out.println(one);//[����, 77, 88, 99]
			rowData.add(one);// ���ߺ��Ϳ� �ѻ���� �����͸� ��´�
		}

	}
}//JTableEx
class TablePrint implements ActionListener{

	//�Ѿ���� ���� ���� �����ڰ� �ʿ��ϴ� (����Ÿ������) ������ �������̺��� ����ϱ����ؼ�
	JTable table;
	public TablePrint(JTable table) {	
		this.table = table;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {//��¹�ư�� ������ �����!
//		System.out.println("����");
		int rowNum = table.getRowCount();//������
		int colNum = table.getColumnCount();//Į����
		System.out.println(rowNum+","+colNum);
		
		for(int i=0;i<colNum;i++) {
			String colName=table.getColumnName(i);
			System.out.print(colName+"\t");
			
		}
		System.out.println();
		
//		��rowNum
		for(int i =0;i<rowNum;i++) {
			for(int j = 0;j<colNum; j++) {
				Object obj =table.getValueAt(i, j);
				System.out.print(obj+"\t");
			}
			System.out.println();
		}
	}
	
}

public class Ex12_10_JTable {
	public static void main(String[] args) {
		JTableEx ex = new JTableEx("JTable ����");
//		ex.setSize(500,200);
//		ex.setVisible(true);

	}
}
