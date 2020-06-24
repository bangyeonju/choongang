import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex12_07_Add extends JFrame {
	Ex12_07_Add(String title){
		super(title);
//		setSize(400, 300);
		
		
		Container contentPane = getContentPane();///작업영역에대한정보를가져와서어쩌구저쩌구...
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.yellow);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.pink);
		
		//2가지방법
		contentPane.add(p1,BorderLayout.CENTER);
		contentPane.add(p2,BorderLayout.SOUTH);
//		contentPane.add(p1,"Center");
//		contentPane.add(p2,"South");
		
		JTextField text1 = new JTextField(5);
		JTextField text2 = new JTextField(5);
		JTextField text3 = new JTextField(5);
		
		p1.add(text1);
		p1.add(new JLabel("+"));
		p1.add(text2);
		p1.add(new JLabel("="));
		p1.add(text3);
		
		JButton b1 = new JButton("확인");
		JButton b2= new JButton("취소");
		
		OkButton ok = new OkButton(text1,text2,text3);
//		b1.addActionListener(new OkButton(text1,text2,text3));
		b1.addActionListener(ok);//actionPerformed 현재클래스안에없다. ok는 actionPerformed의 위치
		
		CancelButton cancel =new CancelButton(text1,text2,text3);
		b2.addActionListener(cancel);
		
		p2.add(b1);
		p2.add(b2);
		//종료하는 기능 (간단)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();//딱맞게
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Ex12_07_Add("덧셈프로그램");
		
		
	}

}//Ex12_07_Add
class OkButton implements ActionListener{
	JTextField text1;
	JTextField text2;
	JTextField text3;
	
	public OkButton(JTextField text1, JTextField text2, JTextField text3) {
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		

	}

	@Override
	//확인버튼 눌렀을때생기는 일~
	public void actionPerformed(ActionEvent e) {
		System.out.println("확인버튼 클릭");
		
//		String num1 = text1.getText();
//		String num2 = text2.getText();
//		문자를 int형으러
		int num1 = Integer.parseInt(text1.getText());
		int num2 = Integer.parseInt(text2.getText());
		int sum = num1+num2;
//		Integer.parseInt("12")=>12  문자형을 정수형으로
//		String.valueOf(12)=>"12" 정수형을 문자형으로
		
	
		text3.setText(String.valueOf(sum)); //정수형을 문자형을 
//		text3.setText(sum+"");
//		Integer.parse
		System.out.println(num1+num2);
	}
	
}
class CancelButton implements ActionListener{
	JTextField text1;
	JTextField text2;
	JTextField text3;
	 CancelButton(JTextField text1, JTextField text2, JTextField text3) {
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("취소버튼클릭");
		text1.setText("");
		text2.setText("");
		text3.setText("");
	
		
	}
	
}
