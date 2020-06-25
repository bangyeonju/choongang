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
	Choice ch1;
	Choice ch2;
	Label lb2;
	
	String [][] 나라 = { {"한국","일본","중국"},
						{"영국","스위스","프랑스"},
						{"이집트","콩고","우간다"}
					   };
	Ex12_06_방연주(String title) {
		super.setTitle(title);
		Label lb1= new Label("대륙과 나라를 선택하세요"); 
		lb1.setBackground(Color.cyan);
		lb1.setAlignment(Label.CENTER);
		
		lb2= new Label();
		lb2.setBackground(Color.pink);
		lb2.setAlignment(Label.CENTER);// 중앙정렬 설정
		//choice두개를 패널에 부착
		 ch1= new Choice();
		 ch2= new Choice();
		
		Panel p = new Panel();
	
		p.add(ch1);
		p.add(ch2);
		
		super.add(lb1,"North");
		super.add(p,"Center");
		super.add(lb2,"South");
		
		
		for(int i=0;i<대륙.length;i++) {
			ch1.add(대륙[i]);
			
		}
		ch2.add("                          ");
	
		setSize(300, 200);
		setVisible(true);
	
		ch1.addItemListener(this);//ItemEvent가 발생됨면 자동으로 ItemEvent()객체생성 =>ItemStateChanged()가 호출
		ch2.addItemListener(this);//ItemEvent가 발생되면 자동으로 ItemEvent()객체생성 ! =>ItemStateChanged()가 호출
		
			
//		Frame종료기능넣기
//		x누르면 창닫히게
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);
			}
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
		Object obj = e.getSource();//정확한이벤트소스를 얻어온다
		String str = "선택한 대륙과 나라는 :";
		if(obj==ch1){
			ch2.removeAll();//ㅅ기존에있던것을 지운다
			int index = ch1.getSelectedIndex();
			for(int j=0;j<나라[index].length;j++) {//나라의 [index]행만큼
				ch2.add(나라[index][j]);
			}
		} 
		else if(obj==ch2) {
			str += ch1.getSelectedItem()+":";
			
			str += ch2.getSelectedItem();
			lb2.setText(str);
			
		}
	}
	
	

}
