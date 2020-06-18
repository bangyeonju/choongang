import java.util.HashSet;
import java.util.Iterator;

public class Ex09_09_set {
	public static void main(String[] args) {
		int[] arr = new int[6];
		int i;
//			1~10정수 난수 6개 발생
		for (i = 0; i < 6; i++) {
			arr[i] = (int) ((Math.random() * 10) + 1);
		}
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		HashSet<Integer> hs = new HashSet<Integer>();
//		Iterator<Integer> iterator = set.iterator();
		int count = 0;
		while (true) {
			int num = (int) ((Math.random() * 10) + 1);
			hs.add(num);
			count++;
			if(hs.size() ==6)
				break;
		}
		System.out.println(hs);
		System.out.println("반복횟수:"+count);
		Integer [] arr2 = new Integer[hs.size()];
		hs.toArray(arr2);
		
		for (i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}
}
