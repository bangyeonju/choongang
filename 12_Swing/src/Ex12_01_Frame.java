import java.awt.Frame;

public class Ex12_01_Frame {
	public static void main(String[] args) {
			Frame f = new Frame("제목자리");
			
			
			f.setTitle("첫번째 frame");
			f.setVisible(true);// 화면에 보여줌 *필수*
			f.setSize(400, 300);
			f.setLocation(100,200); //꼭지점위치..
	}
}
