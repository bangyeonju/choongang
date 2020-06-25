package JTable성적;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;

//출력
public class FilePrint implements ActionListener {
	JTable table;
	
	  FilePrint(JTable table) {
		  this.table = table;//메인에서만든테이블가지고옴!
		  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedWriter bw = null;
		FileWriter fw =null;
		int rowNum= table.getRowCount();
		int colNum =table.getColumnCount();
		System.out.println(rowNum+","+colNum);
//		System.out.println("출력");
		File f = new File("table.txt");
		try {
			fw = new FileWriter(f);
			 bw = new BufferedWriter(fw);
			
			for(int i =0; i<colNum;i++) { //colNum:4
				bw.write(table.getColumnName(i));
				if(i!=colNum-1) {
					bw.write("/");
					
				} else {
					bw.newLine();
				}
			}
//			행rowNum
			for(int i =0;i<rowNum;i++) {
				for(int j = 0;j<colNum; j++) {
					Object obj =table.getValueAt(i, j);
//					System.out.print(obj+"\t");
					bw.write((String)obj);//다운캐스팅 obj>string
					if(j!=colNum-1) {
						bw.write("/");
						
					} else {
						bw.newLine();//줄바꿈
					}
				}
				System.out.println();
			}
		
		} catch (IOException e1) {//경로에 폴더가없을떄
			e1.printStackTrace();
		} finally {
			try {
				if(bw != null) //null이아니면 받아라
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	 

}
