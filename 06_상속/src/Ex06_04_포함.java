class Man{
	private String name;
	int age;
	Man(){
		
	}
	Man(String name, int age ){
		this.name=name;
		this.age= age;
	}
	void display() {
		System.out.println(name+","+age);
	}
	String getName(){
		return name;
	}
}
class Worker extends Man{
	String name;
	int age;
	String company;
	Man m;
	
	Worker(){
		
	}
	Worker(String name,int age, String company){
//		this.name=name;
//		this.age=age;
		m=new Man(name,age); //�����Ļ���
		this.company=company;
	}
	void display() {
		System.out.println(m.getName());
		System.out.println(m.age);
		System.out.println(company);
	}
}
public class Ex06_04_���� {
	public static void main(String[] args) {
	
		Worker w = new Worker("����",22,"�߾�");
		w.display();
	}
}
