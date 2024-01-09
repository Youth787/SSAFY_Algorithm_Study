import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j])
                    max = Math.max(dp[j], max);
            }
            dp[i] = max + 1;
        }

        Arrays.sort(dp);
        System.out.println(dp[n]);
    }
}


//https://small-stap.tistory.com/13#google_vignette
