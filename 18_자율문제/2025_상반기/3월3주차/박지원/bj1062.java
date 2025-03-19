//백준 가르침 자바
//백트래킹, 조합

import java.util.*;
import java.io.*;


public class Main {
    private static int n, k;
    private static String[] word;
    private static int max = Integer.MIN_VALUE;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        word = new String[n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            word[i] = str;
        }
        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }
        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['c' - 'a'] = true;

        backtracking(0, 0);
        System.out.println(max);

    }
    private static void backtracking(int al, int len) {
        if (len == k - 5) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean read = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if (!visited[word[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read) count++;
            }
            max = Math.max(max, count);
            return;
        }
        for (int i = al; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i, len + 1);
                visited[i] = false;
            }
        }
    }



}
