import java.util.*;
import java.io.*;

class Solution {
    int MOD = 20170805;
    static int answer;
    static int[][][] dp;
    public int solution(int m, int n, int[][] cityMap) {
        answer = 0;
        dp = new int[m][n][2];
        for(int i=0;i<m;i++){
            if(cityMap[i][0]==1){
                break;
            }
            dp[i][0][1]=1;
        }
        for(int j=0;j<n;j++){
            if(cityMap[0][j]==1){
                break;
            }
            dp[0][j][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                
                if(cityMap[i][j]==1) continue;
                
                // 왼쪽에서 오는 경우
                if(cityMap[i][j-1]==0){
                    dp[i][j][0] = (dp[i][j-1][0]+dp[i][j-1][1]) % MOD;
                } else if(cityMap[i][j-1]==2){
                    dp[i][j][0] = dp[i][j-1][0];
                }
                
                // 위에서 오는 경우
                if(cityMap[i-1][j]==0){
                    dp[i][j][1] = (dp[i-1][j][0]+dp[i-1][j][1]) % MOD;
                } else if(cityMap[i-1][j]==2){
                    dp[i][j][1] = dp[i-1][j][1];
                }
            }
        }
        answer = (dp[m-1][n-1][0]+dp[m-1][n-1][1]) % MOD;
        return answer;
    }
}
