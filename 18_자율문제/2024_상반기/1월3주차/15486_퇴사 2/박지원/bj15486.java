import java.util.*;
import java.io.*;
public class Main {

    static int n, max;
    static int[] t, p, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
      //마지막날에 t가 1이라면 그것도 일 할수있어서 p 더해줘야함!! 
      //그래서 n+2개받아와서 n+1날까지 봐야됨
        t = new int[n + 2];
        p = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        max = -1;
        dp = new int[n + 2];

        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, dp[i]);
            int next = i + t[i];
          //이 일 끝내고도 퇴사날이 아닌가요 ?;; 그러면 일해야죠;;
            if (next < n + 2)
                dp[next] = Math.max(dp[next], max + p[i]);
        }

        System.out.println(dp[n + 1]);
    }
}

//https://loosie.tistory.com/219
