
public class Ex03_09_while {
	public static void main(String[] args) {
		
		
		int i;
		for(i=1;i<=5;i++) {
			System.out.println("Hello");
		}
		/*
		while(조건식) {
			반복할문장1;
		}
		*/
		i = 6;
		while(i<=5) {
			System.out.println("while"+i);
			i++;
			
		}
		System.out.println("while밖 "+i);
		
		System.out.println();
		/*
		do {
			반복할문장;
		} while(조건);
		
		*/
		i=6;
		do {
			System.out.println("do~while"+i); 
			i++;							  	
		} while(i<=5);
		System.out.println("do~while밖"+i);
		
	}
}
