import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
//ObjectOutputStream °´Ã¼
class Person implements Serializable {
	String name = "È«±æµ¿";
	int age = 20;
}

public class Ex11_05_Serializable {

	public static void main(String[] args) {
		Person p = new Person();
		try {
			FileOutputStream fos = new FileOutputStream("object.txt"); // ¿µ¾î³ª¼ýÀÚ...
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			FileInputStream fis = new FileInputStream("object.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			oos.writeObject(p);
			oos.writeObject(new Date());
			oos.close();

			Person p2 = (Person) ois.readObject();
			System.out.println(p2.name + "," + p2.age);
			Date d2 = (Date) ois.readObject();
			System.out.println(d2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
