import java.util.*;
import java.io.*;

class Solution {
    static final int Num = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n][m];
        for(int[] p : puddles){
            dp[p[1]-1][p[0]-1]=-1;
        }
        dp[0][0]=1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                if(i-1>=0){
                    dp[i][j] =(dp[i][j] + dp[i-1][j]) % Num;
                }
                if(j-1>=0){
                    dp[i][j] =(dp[i][j] + dp[i][j-1]) % Num;
                }
                
            }
        }
        return dp[n-1][m-1];
    }
}
