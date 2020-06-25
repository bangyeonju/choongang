package JTable����;

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
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JTableMain extends JFrame implements ActionListener {
	int cnt = 1;// ����/���� �����ϱ������ʟG��
	Vector<String> columnNames = null;
//	Vector<String> rowData = null; //�ѻ������ ����..
	Vector<Vector<String>> rowData = null;// ���ߺ��ͷ� ������ ����!=>�迭�� ������Ű�亸�� �÷������λ���ؼ� �����Ӱ� �������ִ�?

	String[] caption = {"�̸�:","����:","����:","����"};
	JTextField[] tf = new JTextField[4];
	
	JTableMain(String str) {
		super(str);
		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		getFile();
		compose();
		setSize(700, 300);
		setLocation(300, 200);// ��ġ����
		setVisible(true);
	
	}
	void getFile() {
		
		 File f= new File("table.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str=br.readLine())!=null) {
				TableMake(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//getFile
	private void compose() {
		
		Container contentPane = getContentPane();//�۾�����
		contentPane.setLayout(null);//��ġ������ ���� �Ⱦ��ڴ�.
//		contentPane.setLayout(BorderLayout); BorderLayout���ڴ�
		//���̺���� �۾�
		JTable table = new JTable(rowData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setBounds(250, 30, 400, 200);
//		JTextField t1= new JTextField();
//		JTextField t2= new JTextField();
//		JTextField t3= new JTextField();
//		JTextField t4= new JTextField(); 
//		 =>�迭�� �����
		for(int i =0;i<4;i++) {
			JLabel lb = new JLabel();
			lb.setText(caption[i]);
			lb.setBounds(10, (i+1)*30, 50, 20);
			contentPane.add(lb);
			tf[i] = new JTextField();
			tf[i].setBounds(80, (i+1)*30, 90, 20);
			contentPane.add(tf[i]);
	
			
		}
		
		JButton btnAdd =  new JButton("�߰�");
		btnAdd.addActionListener(new AddActionListener(table,tf));
		btnAdd.setBounds(10,160,100,20);
		contentPane.add(btnAdd);
		
		JButton btnRemove =  new JButton("����");
		btnRemove.addActionListener(new RemoveActionListener (table));
		btnRemove.setBounds(120,160,100,20);
		contentPane.add(btnRemove);
		
		JButton btnFile =  new JButton("ȭ�����");
		btnFile.addActionListener(new FilePrint(table));
		btnFile.setBounds(10,190,100,20);
		contentPane.add(btnFile);
		
		JButton btnExit =  new JButton("����");
		btnExit.addActionListener(this);
		btnExit.setBounds(120,190,100,20);
		contentPane.add(btnExit);
		
	}//compose
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
	public static void main(String[] args) {
		new JTableMain("����ó�����α׷�");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}



