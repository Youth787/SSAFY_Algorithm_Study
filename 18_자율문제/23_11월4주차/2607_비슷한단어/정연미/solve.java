package _11월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class 비슷한단어 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			words[i] = input;
		} // 입력받기 완료

		int count = 0;

		// 첫 번째 단어를 기준으로 비슷한 단어 찾기
		for (int i = 1; i < N; i++) {
			if (isSimilar(words[0], words[i])) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean isSimilar(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}

		char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
		
       if(charArray1.toString().equals(charArray2.toString())) {
    	   return true;
       }
        
		Set<Character> charSet1 = new LinkedHashSet<>();
		Set<Character> charSet2 = new LinkedHashSet<>();

		for (char c : charArray1) {
			charSet1.add(c);
		}

		for (char c : charArray2) {
			charSet2.add(c);
		}

		return charSet1.equals(charSet2);
	}
}
