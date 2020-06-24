import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;


public class Ex12_08_image extends JFrame{
	JRadioButton[] radio = new JRadioButton[3];//관리자생성
	String[] fruit = {"사과","배","체리"};
	JLabel imageLabel = new JLabel();
	ImageIcon[] image= {
						new ImageIcon("images/apple.jpg"),
						new ImageIcon("images/pear.jpg"),
						new ImageIcon("images/cherry.jpg")
						};
	Ex12_08_image(){
		//첫번째로  작업정보..
		Container contentPane = getContentPane();
		//BorderLayout으로 기본설정되어있다
		
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.gray);

					//관리자생성
//		JRadioButton r1 = new JRadioButton();
//		JRadioButton r2 = new JRadioButton();
//		JRadioButton r3 = new JRadioButton();
		
		//버튼그룹으로만드는법=>한가지만 선택될수있게!
		ButtonGroup group = new ButtonGroup();
		for(int i=0;i<radio.length;i++) {
			radio[i] = new JRadioButton(fruit[i]); 
			group.add(radio[i]);
			radioPanel.add(radio[i]);
			radio[i].addItemListener(new ImageItemEvent());
		}
		contentPane.add(radioPanel,BorderLayout.NORTH);
		contentPane.add(imageLabel,BorderLayout.CENTER);
		radio[0].setSelected(true); //시작할때 선택된거처럼 만듬
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);//가운데정렬
		setSize(350,400);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼누르면 프로그램 종료
		
	}//생성자

	class ImageItemEvent implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (radio[0].isSelected()) {
				imageLabel.setIcon(image[0]);// 이미지를ㄹ 넣고싶을떄 setIcon
			} else if (radio[1].isSelected()) {
				imageLabel.setIcon(image[1]);
			} else {
				imageLabel.setIcon(image[2]);
			}
		}

	}

	public static void main(String[] args) {
		new Ex12_08_image();
		
	}

}//Ex12_08_image


