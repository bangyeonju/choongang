
public class Ex11_10_�濬�� {

	public static void main(String[] args) throws Exception {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		FileOutputStream fos = new FileOutputStream("voca.txt",true);
//		FileInputStream fis = new FileInputStream("voca.txt");
		
//		HashMap<String, String> map = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
	
		while (true) {
			int i = 0;
			String text;
			System.out.println("1.�ܾ��Է� 2.�ܾ�˻� 3.���� >>");
			i = sc.nextInt();
			
			switch (i) {
			case 1:
				System.out.println("�ܾ�/���Է�>>");
				text = br.readLine();
				while ((text=br.readLine())!=null) {
					
				}
			
				break;

			case 2:
				System.out.println("�˻� �ܾ� �Է�>>");
				break;

			case 3:
				System.out.println("���α׷��� �����մϴ�.");
				break;

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
