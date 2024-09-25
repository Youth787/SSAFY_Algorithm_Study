
import java.util.*;
import java.io.*;

class Main {
    static int n, d, k, c;
    static int[] sushi, count;

	public static void main (String[] args) throws java.lang.Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken()) - 1;
        sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine()) - 1;
        }
        count = new int[d]; // 각 스시를 몇개 먹었나요
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < k; i++) { // K개 먹은거 표시
            if (count[sushi[i]]++ == 0) cnt++;
        }
        for (int i = 0; i < n; i++) {
            if (res <= cnt) {
                if (count[c] == 0) res = cnt + 1;
                else res = cnt;
            }
            int j = (i + k) % n; //순환 인덱스
            if (count[sushi[j]]++ == 0) cnt++;
            if (--count[sushi[i]] == 0) cnt--;
            
        }
        System.out.println(res);
	}	    
}

//https://velog.io/@dot2__/BOJ-2531%EB%B2%88-%ED%9A%8C%EC%A0%84-%EC%B4%88%EB%B0%A5-Java
