class Sports{
	String name;
	int inwon;
	 Sports() {
		 System.out.println("Sports()");
	}
	 Sports(String name, int inwon) {
		 this.name=name;
		 this.inwon=inwon;
	}
	 
	 void display() {
		 System.out.println("�����̸�"+name);
		 System.out.println("�ο���"+inwon);
		 System.out.println();
	 }
	 
} //Sports
//Baseball = �ڽ�  Sports =�θ�
//class �ڽ� extends �θ�
class Baseball extends Sports{ //sports�� ��ӹ޴´پ�
//	String name;
//	int inwon;
	double ta;
	 
	 Baseball(String name,int inwon,double ta) {
//		 super();//�θ��� �����ڸ� ȣ�� / �����Ǿ�����!/�������� ��ù�ٿ� ����!
		 super(name,inwon);
// 		 this.name=name; //�θ� ������!
//		 this.inwon=inwon;
		 this.ta=ta;
	 }
	 void disply() {
//		 System.out.println("�����̸�="+name);
//		 System.out.println("�ο���="+inwon);
		 super.display();//�θ� �������ִ� display()�޼ҵ带 ȣ���ϰڵ�� super.disply(); ���� dispy();�� ȣ���ϸ� ���ȣ���!
		 System.out.println("Ÿ��="+ta);	
		 System.out.println();
	 }
}//baseball
class Football extends Sports {
//	String name;
//	int inwon;
	int goal;
	Football(String name, int inwon, int goal){
		//super();//�θ������ȣ�⸣��̷�
		super(name,inwon);
//		this.name= name;
//		this.inwon=inwon;
		this.goal=goal;
	}
	void display() {
		super.display();
//		System.out.println("�̸�"+name);
//		System.out.println("�ο���"+inwon);
		System.out.println("��"+goal);
	}
}//football
public class Ex06_01_���_�߱��౸ {
	public static void main(String[] args) {
		Sports s = new Sports("������",1); // ��ü���� -> ������ ȣ��
		s.display();
		
		Baseball b = new Baseball("�߱�",9, 0.314);
		b.disply();
		
		Football f = new Football("�౸",11,20);
		f.display();
	}
}
