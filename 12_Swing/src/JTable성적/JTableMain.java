package JTable성적;

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
	int cnt = 1;// 제목/내용 구분하기위해필욯다
	Vector<String> columnNames = null;
//	Vector<String> rowData = null; //한사람꺼만 담음..
	Vector<Vector<String>> rowData = null;// 이중벡터로 여러개 담음!=>배열로 고정시키긴보단 컬렉션으로사용해서 자유롭게 담을수있다?

	String[] caption = {"이름:","국어:","영어:","수학"};
	JTextField[] tf = new JTextField[4];
	
	JTableMain(String str) {
		super(str);
		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		getFile();
		compose();
		setSize(700, 300);
		setLocation(300, 200);// 위치조정
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
		
		Container contentPane = getContentPane();//작업영역
		contentPane.setLayout(null);//배치관리자 따로 안쓰겠다.
//		contentPane.setLayout(BorderLayout); BorderLayout쓰겠다
		//테이블만드는 작업
		JTable table = new JTable(rowData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setBounds(250, 30, 400, 200);
//		JTextField t1= new JTextField();
//		JTextField t2= new JTextField();
//		JTextField t3= new JTextField();
//		JTextField t4= new JTextField(); 
//		 =>배열로 만들기
		for(int i =0;i<4;i++) {
			JLabel lb = new JLabel();
			lb.setText(caption[i]);
			lb.setBounds(10, (i+1)*30, 50, 20);
			contentPane.add(lb);
			tf[i] = new JTextField();
			tf[i].setBounds(80, (i+1)*30, 90, 20);
			contentPane.add(tf[i]);
	
			
		}
		
		JButton btnAdd =  new JButton("추가");
		btnAdd.addActionListener(new AddActionListener(table,tf));
		btnAdd.setBounds(10,160,100,20);
		contentPane.add(btnAdd);
		
		JButton btnRemove =  new JButton("삭제");
		btnRemove.addActionListener(new RemoveActionListener (table));
		btnRemove.setBounds(120,160,100,20);
		contentPane.add(btnRemove);
		
		JButton btnFile =  new JButton("화일출력");
		btnFile.addActionListener(new FilePrint(table));
		btnFile.setBounds(10,190,100,20);
		contentPane.add(btnFile);
		
		JButton btnExit =  new JButton("종료");
		btnExit.addActionListener(this);
		btnExit.setBounds(120,190,100,20);
		contentPane.add(btnExit);
		
	}//compose
	void TableMake(String str) {
//		str:이름/국어/영어/수학
		String[] split = str.split("/");
		if (cnt == 1) {
			for (int i = 0; i < split.length; i++) {
				columnNames.add(split[i]);
			}
			cnt++; // 2
		} else {
//			str:윤아/77/88/99
			Vector<String> one = new Vector<String>();// 한줄(한사람)만 잠깐 임시벡터를 만듬

			for (int i = 0; i < split.length; i++) {
				one.add(split[i]);
			}
//			System.out.println(one);//[윤아, 77, 88, 99]
			rowData.add(one);// 이중벡터에 한사람의 데이터를 담는다
		}

	}
	public static void main(String[] args) {
		new JTableMain("성적처리프로그램");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}



