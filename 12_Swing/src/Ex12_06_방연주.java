import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Ex12_06_방연주 extends Frame implements ItemListener {

	String[] 대륙 = {"아시아","유럽","아프리카"};
	//label->대륙과나라를 선택하세요 프레임에 부착
	//선택한나라는 000 : 000입니다.
	Label lb1= new Label("대륙과 나라를 선택하세요"); 
	Label lb2= new Label("선택한 나라는");
	
	
	//choice두개를 패널에 부착
	Choice ch1= new Choice();
	Choice ch2= new Choice();

	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	String [][] 나라 = { {"한국","일본","중국"},
						{"영국","스위스","프랑스"},
						{"이집트","콩고","우간다"}
					   };
	Ex12_06_방연주(String title) {
		super.setTitle(title);
		setSize(300, 200);

		p1.setBackground(Color.red);
		p2.setBackground(Color.white);
		p3.setBackground(Color.blue);
		
		
		p1.add(lb1);
		p2.add(ch1);
		p2.add(ch2);
		p3.add(lb2);
		add(p1,"North");
		add(p2,"Center");
		add(p3,"South");
		setVisible(true);
		for(int i=0;i<대륙.length;i++) {
			ch1.add(대륙[i]);
			
		}
		for(int i=0;i<나라.length;i++) {
			for(int j=0;j<나라[i].length;j++) {
				ch2.add(나라[i][j]);
			}
		}
	
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		this.addWindowListener(new WindowAdapter() {
			
//		Frame종료기능넣기
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);
			}
//		x누르면 창닫히게
			public void windowActivated(WindowEvent e) {
				System.out.println("windowActivated");
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Ex12_06_방연주("Choice 과제");
	
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(ch1.getSelectedItem());
		System.out.println(ch2.getSelectedItem());
//		lb2.setText(lb2+ch1.getSelectedItem());
		
	}
	
	

}
