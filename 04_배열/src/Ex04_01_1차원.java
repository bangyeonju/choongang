
public class Ex04_01_1���� {

	public static void main(String[] args) {
		// �迭�̶�?
		// ���� ������Ÿ���� ���� �������� ����
		int a = 1, b = 2, c = 3;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		int[] arr1 = { 1, 2, 3 }; // �迭 ������1
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		// System.out.println(arr1[3]);
		System.out.println("���ǰ���(length):" + arr1.length);
		System.out.println(arr1); // �� 3���� ù���� �ּҰ� ����.

		int i;
		for (i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

		System.out.println();

		int[] arr2 = new int[] { 1, 2, 3, 4, 5 }; //�迭������2
		arr2[2]=33; //Ư���� �� ����
//		arr2[5]=100; ���� �濡�� ���� �Ұ�
		for(i=0;i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println();
		
		int[] arr3 = new int[10]; //�迭������3
		arr3[3]=3;
		arr3[4]=4;
		
		for (i=0;i<arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		
		System.out.println();
		
		//Ȯ�� for�� ��ü���� �����˱�����..?
		for(int temp : arr3) { // : �ݷ� 
			System.out.printf("temp:%d\n",temp);
		}
		
		
		double d1[] ={1.1,2.2,3.3};
		for(i=0;i<d1.length;i++) {
			System.out.println(d1[i]);
		}
		
		System.out.println();
		
		double[] d2 = new double[] {1.1,2.2,3};
		for(i=0;i<d2.length;i++) {
			System.out.println(d2[i]);
		}
		System.out.println();
		double[] d3= new double[3];
		d3[0]=1.1;
		d3[1]=2.2;
		d3[2]=3.3;
		
		for(double temp : d3) {
			System.out.print(temp+" ");
		}
		
		for(i=0;i<d3.length;i++) {
			System.out.print(d3[i]+" ");
		}

	}
}
