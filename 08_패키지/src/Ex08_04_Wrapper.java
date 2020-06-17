
public class Ex08_04_Wrapper {
	public static void main(String[] args) {
		Integer it1 = new Integer(11); // int --> Integer
		Integer it2 = 11; // 11 -> new Integer(11) : autoboxing
		Integer it3 = 22;
		System.out.println(it2 + it3);

		int it4 = 33;
		int it5 = new Integer(44);// new Integer(44) ->44 : unboxing

		int i = Integer.parseInt("100"); // ���ڿ� 100�� parseInt�� ���������� �ٲ�!
		int j = Integer.parseInt("200");
		System.out.println(i + j);
		System.out.println("100" + "200");

		Integer a = Integer.valueOf("100");// ���ڿ��� ���������� �ٲ���
		int b = Integer.valueOf("200"); //
		System.out.println(a + b);
		System.out.println();

		double c = Double.parseDouble("1234.4");
		System.out.println("c:" + c);
		try {
			i = Integer.parseInt("100.3");// new NumberFormatException()��ü �ڵ����� ����
			System.out.println("i:" + i);
		} catch (NumberFormatException e) {
			System.out.println("������ȯ�Ұ���");
			System.out.println(e.toString());
			System.out.println(e.getMessage());
		}

		System.out.println();

		int[] arr = { 1, 2, 3, 4, 5 };
		int sum = 0;
		for (i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.println("sum:" + sum);
		sum = 0;
		String[] arr2 = { "1", "2", "3", "4", "5" };
		for (i = 0; i < arr2.length; i++) {
			sum += Integer.parseInt(arr2[i]);

		}
		System.out.println("sum:" + sum);
		System.out.println();
		
		String[] str = {"����:90","ũ����Ż:70","������:80"};
		
		sum =0;
		for(i=0;i<str.length;i++) {

			System.out.println(str[i]);
			
			int pos=str[i].indexOf(":");
			System.out.println("pos"+pos);
			String s = str[i].substring(pos+1);
			System.out.println("s:"+s);
			
			int jumsu = Integer.parseInt(s);
//			sum += jumsu;
//			sum+=Integer.parseInt(str[i].substring(pos+1));
			sum += Integer.parseInt(str[i].substring(str[i].indexOf(":")+1));
			
			
		}
		System.out.println("��:"+sum);
		
		sum = 0;
		String[] str2 = {"����:90","ũ����Ż:70","������:80"};
		for(i=0;i<str2.length;i++) {
			String[] s =str2[i].split(":"); // :�� �ɰ���. 
			sum+=Integer.parseInt(s[1]);	
		}
		System.out.println(sum);
	}
}
