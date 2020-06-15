
public class Ex04_01_1차원 {

	public static void main(String[] args) {
		// 배열이란?
		// 같은 데이터타입을 갖는 변수들의 집합
		int a = 1, b = 2, c = 3;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		int[] arr1 = { 1, 2, 3 }; // 배열 선언방법1
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
//		System.out.println(arr1[3]); //new ArrayIndexOutOfBoundsException(); 객체가 자동으로 만들어진다
		// System.out.println(arr1[3]);
		System.out.println("방의개수(length):" + arr1.length);
		System.out.println(arr1); // 방 3개의 첫방의 주소가 들어간다.

		int i;
		for (i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

		System.out.println();

		int[] arr2 = new int[] { 1, 2, 3, 4, 5 }; //배열선언방법2
		arr2[2]=33; //특정방 값 변경
//		arr2[5]=100; 없는 방에는 변경 불가
		for(i=0;i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println();
		
		int[] arr3 = new int[10]; //배열선언방법3
		arr3[3]=3;
		arr3[4]=4;
		
		for (i=0;i<arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		
		System.out.println();
		
		//확장 for문 전체방의 값을알기위해..?
		for(int temp : arr3) { // : 콜론 
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
