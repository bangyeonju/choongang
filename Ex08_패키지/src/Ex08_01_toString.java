class Person{
	 private String name;
	 private int age;
	 
	 Person(String name, int age) {
		 this.name = name;
		 this.age= age;
		 
	 }
	 
	 public String toString() { //public 쓰는이유?
		return name + "," + age;
	}
	 //오버라이딩~
	 public boolean equals(Object obj) {  //public 쓰는이유?
//		 System.out.println(obj.age); // 부모는 부모가 물려준 것만 쓸수있다. age는 부모가 물려준게 아니기 때문에
		 if(obj instanceof Person) {
			 Person p = (Person) obj; //다운캐스팅
			 return this.age  == p.age;
//			 System.out.println(p.age);
				
		 }
		 return false;
	 }
}
public class Ex08_01_toString {

	public static void main(String[] args) {
		Object man = new Person("보검", 30);//업캐스팅 //부모가 자식을 관리할수있다. Object는 ??상위???
		Object woman = new Person("윤아",30);
		System.out.println(man.toString()); //객체주소를 반환?
		System.out.println(woman.toString());
//		System.out.println(woman); //참조변수(주소를 가지고있는변수) == 참조변수.toString() // toString은 참조변수만 써도 자동으로 호출된단. 
//		System.out.println(man.equals(woman)); // equals ==> 주소를 비교하는 메서드
		System.out.println(man.equals(woman));
	}

}
