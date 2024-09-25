import java.util.*;

//백준 14501 퇴사 실3 dp 
//그냥 처음부터 0~n-1 만 설정하면 쉬울걸 1~n으로 설정해서 좀 꼬였던문제
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        int[] time = new int[n];
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (i + time[i] <= n) {
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + price[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }


        System.out.println(dp[n]);
     }

}

