//백준 단어수학 자바
//그리디, 자릿수대로 가중치생각해서 저장하기

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int [] arr = new int[26];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                arr[c - 'A'] += (int) Math.pow(10, str.length() - 1 - j);
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int turn = 25;
        int ans = 0;
        while(arr[turn] != 0) {
            ans += arr[turn] * num;
            turn--;
            num--;
        }

        System.out.print(ans);
    }

}
