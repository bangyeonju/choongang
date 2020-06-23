import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class ItemEventEx extends Frame implements ItemListener {

	Choice ch = new Choice();
	//패널 만들고
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();//

	Label lb = new Label("꽃을 선택하세용");// 글자넣고싶을때 Label
	// 1번
	Label result = new Label("                                         ");
	public ItemEventEx() {
		//배경설정하고
		p1.setBackground(Color.pink);
		p2.setBackground(Color.LIGHT_GRAY);
		p3.setBackground(Color.yellow);
//		result.setBackground(Color.white);
//		setLayout(new BorderLayout());//Frame 의 기본 배치관리자는 BorderLayout());
//		lb.setBackground(Color.white);
		String[] flower = { "진달래", "장미", "국화", "벚꽃", "개나리" };
//		ch.add("진달래");
//		ch.add("장미");
		int i;
		for (i = 0; i < flower.length; i++) {
			ch.add(flower[i]);
		}
		ch.addItemListener(this);//itemStateChanged상속받아야한다
		// new ItemEvent() 객체가 자동을 만들어진다.
		
		//프레임에 부착!
		p1.add(lb);
		p2.add(ch);
		p3.add(result);
		add(p1, "North");
		add(p2, "Center");
		add(p3,"South");
//		super.setSize(400, 300);
//		setVisible(true);
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) { // (ItemEvent e) 넘어오는 ItemEvent객체를 받으려고
//		System.out.println("여기");
		System.out.print(ch.getSelectedIndex()+":");
		System.out.println(ch.getSelectedItem());
		result.setText(ch.getSelectedItem());
	}

}

public class Ex12_03_ItemEvent {
	public static void main(String[] args) {
		// 2번
		ItemEventEx f = new ItemEventEx();
		f.setSize(400, 300);
		f.setVisible(true);
	}
}
