import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int h = Integer.parseInt(s[2]);
        int [][] dp = new int[n+1][1001];
 
        List<Integer>[] list = new ArrayList[n+1];
 
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
 
        for(int i=0; i<=n; i++){
            dp[i][0]=1;
        }
 
        for(int i=1; i<=n; i++){
            for(int j=1; j<=h; j++){
                for(Integer integer: list[i]){
                    if(j>=integer){
                        dp[i][j] += dp[i-1][j-integer];
                        dp[i][j] %=10007;
                    }
                }
                dp[i][j] += dp[i-1][j];
                dp[i][j] %=10007;
            }
        }
        System.out.println(dp[n][h]);
    }
}
