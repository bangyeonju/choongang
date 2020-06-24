import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//split?배열?
public class Ex11_11_WordCount방연주 {

	public static void main(String[] args) throws IOException {
		/*
		 * String lyrics = "When I find myself"+ "in times of trouble"+
		 * "Mother Mary comes to me"+ "Speaking words of wisdom let it be"+
		 * "And in my hour of darkness"+ "She is standing right in front of me"+
		 * "Speaking words of wisdom let it be"+ "Let it be let it be"+
		 * "Let it be let it be"+ "Whisper words of wisdom let it be"+
		 * "And when the broken hearted people"+ "Living in the world agree"+
		 * "There will be an answer let it be"+ "For though they may be parted"+
		 * "There is still a chance that"+ "they will see"+
		 * "There will be an answer let it be"+ "Let it be let it be"+
		 * "Let it be let it be"+ "Yeah there will be an answer let it be"+
		 * "Let it be let it be"+ "Let it be let it be"+
		 * "Whisper words of wisdom let it be"+ "Let it be let it be"+
		 * "Ah let it be yeah let it be"+ "Whisper words of wisdom let it be"+
		 * "And when the night is cloudy"+ "There is still a light"+
		 * "that shines on me"+ "Shine on until tomorrow let it be"+
		 * "I wake up to the sound of music"+ "Mother Mary comes to me"+
		 * "Speaking words of wisdom let it be"+ "Let it be let it be"+
		 * "Let it be yeah let it be"+ "Oh there will be an answer let it be"+
		 * "Let it be let it be"+ "Let it be yeah let it be"+
		 * "Whisper words of wisdom let it be";
		 */
		FileReader fr = new FileReader("lyrics.txt"); // lyrics.txt 읽는 연결다리
		BufferedReader br = new BufferedReader(fr);
//		BufferedReader br = new BufferedReader(new FileReader("lyrice.txt"));
		String str, lyrics = "";
		int lineCount = 0, i;
		
		while ((str = br.readLine()) != null) {
//			System.out.println(str);
			lyrics += str + " ";
			lineCount++;
		}
		System.out.println(lyrics);
		System.out.println("lineCount:" + lineCount);

		String[] result = lyrics.split(" ");// " "으로 쪼갠다
		System.out.println(result.length); // 배열방 개수
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); // key는 문자열 value는 정수로 !
		for (i = 0; i < result.length; i++) {
			if (hm.get(result[i]) == null) {
				// hm.put("when", 1);
				hm.put(result[i], 1);

			} else {
				// 두개가 같음!
				
//				Integer v = hm.get(result[i]);
				hm.put(result[i], hm.get(result[i]) + 1);
			}
		}
		Set<String> s =  hm.keySet(); //Set : 중복허용안함 순서없음
		System.out.println("s:"+s);
		System.out.println(s.size());//중복빼고 키 개수
		
		Iterator<String> iter =s.iterator();
		while(iter.hasNext()) {
			String st = iter.next();
			System.out.println(st+":"+hm.get(st));
		}
	}

}
