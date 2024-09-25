package _20240911;

import java.util.*;
import java.io.*;

public class _2607_비슷한단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String firstWord = br.readLine();
        int[] firstWordCount = getAlphabetCount(firstWord);
        int answer = 0;

        for (int i=0;i<N-1;i++) {
            String compareWord = br.readLine();
            int[] compareWordCount = getAlphabetCount(compareWord);

            if (isSimilar(firstWordCount, compareWordCount, firstWord.length(), compareWord.length())) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 알파벳 빈도수를 계산하는 함수
    static int[] getAlphabetCount(String word) {
        int[] count = new int[26]; // 알파벳 a-z 개수는 26개
        for (char c : word.toCharArray()) {
            count[c - 'A']++; // 대문자 기준으로 카운트
        }
        return count;
    }

    // 두 단어가 비슷한지 비교하는 함수
    static boolean isSimilar(int[] firstCount, int[] compareCount, int firstSize, int compareSize) {
        int diff = 0; // 다른 알파벳의 개수를 카운트
        int added = 0, removed = 0;

        // 각 알파벳의 개수를 비교
        for (int i=0;i<26;i++) {
            int difference = firstCount[i] - compareCount[i];
            if (difference > 0) {
                removed +=difference;
            } else {
            	// 비교할 단어에만 추가로 있는 글자 수만 카운트된다
                added -=difference;
            }
        }

        // 단어의 길이가 같으면,
        // 한 글자만 다르거나 완전히 동일해야 한다
        if (firstSize == compareSize) {
            return removed==1 || added==1 || removed+added==0;
        }
        // 첫 번째 단어가 더 길다면, 글자가 한 개만 삭제되어야 한다
        else if (firstSize - compareSize == 1) {
            return removed == 1 && added == 0;
        }
        // 두 번째 단어가 더 길다면, 글자가 한 개만 추가되어야 한다
        else if (compareSize - firstSize == 1) {
            return added == 1 && removed == 0;
        }
        return false;
    }
}
