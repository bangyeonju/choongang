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
	int cnt = 1;//제목/내용 구분하기위해필욯다
	Vector<String> columnNames = null;
//Vector<String> rowData = null; //한사람꺼만 담음..
	Vector<Vector<String>> rowData = null;// 이중벡터로 여러개 담음!=>배열로 고정시키긴보단 컬렉션으로사용해서 자유롭게 담을수있다?

	JTableEx(String title) {
		super(title);// 제목
		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();

		getFile();
		compose();
		setSize(500, 200);
		setVisible(true);

	}// 생성자

	private void compose() {
		JTable table = new JTable(rowData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		Container contentPane = getContentPane();//관리영역
		contentPane.add(scrollPane, BorderLayout.CENTER);// 스크롤생성

		JButton btn = new JButton("출력");
		btn.addActionListener(new TablePrint(table));//table정보를 TablePrint에 보낸다
		contentPane.add(btn,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);//화면종료
		
	}

	void getFile() { // 파일을 갖어오는
		File f = new File("table.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while ((str = br.readLine()) != null) {
//				System.out.println(str);table.txt파일에 있는걸 모두 읽는다
				TableMake(str);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// getFile

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
}//JTableEx
class TablePrint implements ActionListener{

	//넘어오는 값을 받을 생성자가 필요하다 (같은타입으로) 위에서 만든테이블을 사용하기위해서
	JTable table;
	public TablePrint(JTable table) {	
		this.table = table;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {//출력버튼을 누르면 여기로!
//		System.out.println("여기");
		int rowNum = table.getRowCount();//열개수
		int colNum = table.getColumnCount();//칼럼수
		System.out.println(rowNum+","+colNum);
		
		for(int i=0;i<colNum;i++) {
			String colName=table.getColumnName(i);
			System.out.print(colName+"\t");
			
		}
		System.out.println();
		
//		행rowNum
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
		JTableEx ex = new JTableEx("JTable 예제");
//		ex.setSize(500,200);
//		ex.setVisible(true);

	}
}
