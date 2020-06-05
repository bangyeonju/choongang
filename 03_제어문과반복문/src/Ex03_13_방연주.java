
public class Ex03_13_╧Ф©╛аж {
	public static void main(String[] args) {
		int i;
		int sum =0;
		for(i=1;i<=100;i++) {
			sum= sum+i;
			if(i%10==0) {
				System.out.printf("1~%d=%d\n",i,sum);
			}
		}
		System.out.println();
		sum =0;
		for (i=1;i<=100;i++) {
			sum= sum+i;
			if(i%10==0) {
				System.out.printf("%d~%d=%d\n",i-9,i,sum);
				sum =0;
			}
			
		}
		
		
	}
}
