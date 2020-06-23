import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex11_04_DataStream { //정수밖에 못읽었는데 데이터타입으로 읽는게 가능하다고한다.

	public static void main(String[] args) {

		try {
			FileOutputStream fos = new FileOutputStream("datastream.txt");//자동으로 만들어진다
			
			DataOutputStream dos = new DataOutputStream(fos);//2차 스트림
			FileInputStream fis = new FileInputStream("datastream.txt");
			DataInputStream dis = new DataInputStream(fis);
			dos.write(65);
			dos.writeInt(123);
			dos.writeDouble(10.23);
			fos.write(65);//문자의 아스키코드값
			
			int i = dis.read();
			int j  = dis.readInt();
			double k = dis.readDouble();
			System.out.println(i);
			System.out.println(j);
			System.out.println(k);
			dis.close();
			dos.close();
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
