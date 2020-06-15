class Person{
	 private String name;
	 private int age;
	 
	 Person(String name, int age) {
		 this.name = name;
		 this.age= age;
		 
	 }
	 
	 public String toString() { //public ��������?
		return name + "," + age;
	}
	 //�������̵�~
	 public boolean equals(Object obj) {  //public ��������?
//		 System.out.println(obj.age); // �θ�� �θ� ������ �͸� �����ִ�. age�� �θ� �����ذ� �ƴϱ� ������
		 if(obj instanceof Person) {
			 Person p = (Person) obj; //�ٿ�ĳ����
			 return this.age  == p.age;
//			 System.out.println(p.age);
				
		 }
		 return false;
	 }
}
public class Ex08_01_toString {

	public static void main(String[] args) {
		Object man = new Person("����", 30);//��ĳ���� //�θ� �ڽ��� �����Ҽ��ִ�. Object�� ??����???
		Object woman = new Person("����",30);
		System.out.println(man.toString()); //��ü�ּҸ� ��ȯ?
		System.out.println(woman.toString());
//		System.out.println(woman); //��������(�ּҸ� �������ִº���) == ��������.toString() // toString�� ���������� �ᵵ �ڵ����� ȣ��ȴ�. 
//		System.out.println(man.equals(woman)); // equals ==> �ּҸ� ���ϴ� �޼���
		System.out.println(man.equals(woman));
	}

}
