package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1699 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            result =Integer.MAX_VALUE;
            for(int j=1; j<=(int)i/2; j++){
                if(j*j ==i){
                    result = 1;
                    break;
                }else result = Math.min(result, dp[j]+dp[i-j]);
            }
            dp[i] = result;
        }
        System.out.println(result);
    }
}
