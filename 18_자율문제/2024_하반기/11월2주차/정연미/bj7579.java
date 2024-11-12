package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr= new int[N][2];
        int maxcost = 0;

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i][0] = Integer.parseInt(st1.nextToken());
            arr[i][1] = Integer.parseInt(st2.nextToken());
            maxcost += arr[i][1];
        }

        int[][] dp = new int[N][maxcost+1];

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            int cost = arr[i][1];
            for(int j=0; j<maxcost+1; j++){
                if (i == 0) {
                    if(j>=cost) dp[i][j] = arr[i][0];
                }else{
                    if(j>=cost) dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i][1]]+arr[i][0]);
                    else dp[i][j] = dp[i-1][j];
                }
                if (dp[i][j] >= M) {
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);
    }
}


