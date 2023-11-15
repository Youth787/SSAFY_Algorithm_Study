package _11월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 겹치는건싫어 {
	public static void main(String[] args) throws IOException {
//		9 2
//		3 2 5 5 6 4 4 5 7
		int cnt =0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		int[] numbers = new int[input.length];
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		
		int [] count = new int[100001];
        int start = 0, end = 0;
        int answer = Integer.MIN_VALUE;

        while (end < N) {
            // 늘릴 수 있으면 end 증가
            while (end < N && count[numbers[end]] + 1 <= K) {
                count[numbers[end++]]++;
            }
            // 더이상 늘릴 수 없음
            int len = end - start;
            answer = Math.max(answer, len);

            //start 이동
            count[numbers[start++]]--;
        }

        System.out.print(answer);
	}// main end
}
