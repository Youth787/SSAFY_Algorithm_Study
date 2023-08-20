import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

// buffer 입력, stringbuilder로 출력 
// List, array, hashset(중복제거) 사용

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 단어 개수 입력 받기 

        HashSet<String> wordSet = new HashSet<>(); // 중복 제거를 위해 HashSet 사용

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            wordSet.add(s);
        } // 단어 입력받기 

        List<String> wordList = new ArrayList<>(wordSet); // 리스트를 새로 생성하고, wordset hashset을 리스트로 변환

        String[] wordarray = wordList.toArray(new String[wordList.size()]);
		// 배열을 새로운 객체로 생성하고 
		// toArray 메서드를 사용하여 리스트를 배열로 변환한다.  
        
		Arrays.sort(wordarray, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 다중 조건
				if (o1.length() == o2.length()) { // 원소 길이가 같을 경우
					return o1.compareTo(o2); // 단어순으로 정렬 
				} else {
					return o1.length() - o2.length(); // 그렇지 않다면 원소의 길이를 기준으로 오름차순 정렬
				}
			}
		});
		
		// 단어 사전순 정렬은 compareTo() 메소드를 쓰면 된다.

		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<wordarray.length; i++) {
			sb.append(wordarray[i]+"\n");
		}System.out.println(sb);
	}
}
