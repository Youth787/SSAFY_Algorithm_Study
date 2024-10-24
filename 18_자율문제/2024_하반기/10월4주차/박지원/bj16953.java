//백준 A->B 자바
//수학 (bfs + queue풀이의 기본문제인듯 하지만 수학으로 풀었다..)

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (b > 0) {
            if (b == a) break;
            if (b < a) {
                cnt = 0;
                break;
            }
            if (b % 10 == 1) {
                b /= 10;
                cnt++;
            } else if (b % 2 == 0) {
                b /= 2;
                cnt++;
            } else {
                cnt = 0;
                break;
            };
        }
        if (cnt == 0) System.out.println(-1);
        else System.out.println(cnt + 1);
    }
}
