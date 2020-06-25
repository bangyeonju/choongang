package JTable성적;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//삭제..
public class RemoveActionListener implements ActionListener{

	JTable table;
	 RemoveActionListener(JTable table) {
		 this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		System.out.println("row:"+row);
		DefaultTableModel model =(DefaultTableModel) table.getModel();//table에 removeRow메소드가 없기때문에 
		model.removeRow(row);
	}

}
