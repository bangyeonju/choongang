import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Ex11_10_�濬�� {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw=null;
		BufferedReader br = null,br2 = null;
		Scanner sc = new Scanner(System.in);
		boolean flag = false;

		while (true) {
			int i = 0;
			int input;
			System.out.println("1.�ܾ��Է� 2.�ܾ�˻� 3.���� >>");
			input = sc.nextInt();
			String str;
			switch (input) {
			case 1:
				System.out.print("�ܾ�/���Է�>>");
				br = new BufferedReader(new InputStreamReader(System.in));//Ű����� ����ٸ�! �ָ������? Ű����� �Է¹����� �о���̴� �۾�!
				str = br.readLine();//������� �о���δ� //�����д´�
				System.out.println(str);
//				Reader : 2����Ʈ�о���ϼ��ִ�/�ѱ��� �о���϶� ���
				
				//�����͸� �������� ����ٸ�! ���۸� �̿��ؼ� �����Ͱ� �ѹ��� ���޵ɼ��ְ�!//���۴� �뷮������ �Ѿ��.
				bw = new BufferedWriter(new FileWriter("c:\\sun\\voca.txt",true)); // true ������ �ִ� ���뿡 �߰��ȴ�.
				bw.write(str);//���
				bw.newLine();
//				bw.close(); �̰͵���!
				bw.flush();
				break;

			case 2:
				System.out.println("�˻� �ܾ� �Է�>>");
				br = new BufferedReader(new InputStreamReader(System.in));//Ű����� ����ٸ�
				str =br.readLine(); // �Ʊ��Է��Ѵܾ 
				String line;
				//���پ��о���̴� �۾�! -> voca.txt�� �о���̴� ����ٸ��ʿ��ϴ�
				br2= new BufferedReader(new FileReader("c:\\sun\\voca.txt"));
				while((line = br2.readLine()) != null) {
					flag = false;
					System.out.println(line); //line = apple/���
					String[] token =line.split("/");// /�� �������� �ɰ��� // token[0]:apple token[1]:���
					if(token[0].equals(str)) {//��ū 0����� ���� �Է��� �ܾ�� ����?
						System.out.println("�ܾ�>"+token[0]);
						System.out.println("��>"+token[1]);
						flag = true;
						break;
					}
				
				}
				if(flag == false) 
					System.out.println("ã�´ܾ����");
			
				break;

			case 3:
				System.out.println("���α׷��� �����մϴ�.");
				
				if(bw!=null) 
					br.close();//�ݵ�� �ؾ��Ѵ�// null�� �ʱ�ȭ������Ѵ�
				if(bw!=null)
					bw.close();
				System.exit(0);

			default:
			}
		}
	}

}
//�Է��� �ܾ�/���� voca.txt�� ����
//1.�ܾ��Է� 2.�ܾ�˻� 3.���� >> 1
//�ܾ�/�� �Է�>>apple/���
//
//1.�ܾ��Է� 2.�ܾ�˻� 3.���� >> 1
//�ܾ�/�� �Է�>>blue sky/�Ķ� �ϴ�
//
//1.�ܾ��Է� 2.�ܾ�˻� 3.���� >> 2
//�˻� �ܾ� �Է�>>apple
//�ܾ�>apple
//�ܾ��� ��>���
//
//1.�ܾ��Է� 2.�ܾ�˻� 3.���� >> 2
//�˻� �ܾ� �Է�>>summer
//ã�� �ܾ� ����
//
//1.�ܾ��Է� 2.�ܾ�˻� 3.���� >> 3
//���α׷� �����մϴ�.
