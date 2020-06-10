
public class Ex05_10_¿Á±Õ»£√‚ {

	public static void main(String[] args) {
		System.out.println("4 factorial:"+fact(4));
	}
	static int fact(int n) {
		if(n==1)
			return 1;
		else 
			return n*fact(n-1);
	}

}
