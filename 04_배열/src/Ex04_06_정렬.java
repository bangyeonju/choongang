
public class Ex04_06_Á¤·Ä {

	public static void main(String[] args) {

			int [] arr = {8,3,5,2,9};
			int a =10, b=20;
			int i,j,temp;
			System.out.println(a+","+b);
			temp = b;
			b=a;
			a=temp;
			for(i=0;i<arr.length;i++) {
				System.out.print(arr[i]+ "  ");
				
			}
			for (i=0; i<arr.length-1;i++) {
				for (j=i+1;j<arr.length;j++) {
					if(arr[i]>arr[j]) {
						temp= arr[j];
						arr[j]= arr[i];
						arr[i]=temp;
					} 			
				}
			}
			
			System.out.println();
			for(i=0;i<arr.length;i++) {
				System.out.print(arr[i]+ "  ");
				
			}
			
			
	}

}
