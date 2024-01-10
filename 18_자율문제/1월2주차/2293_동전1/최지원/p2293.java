import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n; //동전 종류
    static int k; //목표 합
    static int[] coin; // 동전 가치 저장
    static int[] dp; //i원을 만드는 경우의 수 저장

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int [n];
        dp = new int [k + 1];
             
        for(int i = 0 ; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        } //동전 가치 입력
        
        dp[0] = 1; //0원을 만드는 방법 1가지
        for(int i = 0 ; i < n; i++) { //동전 종류 도는 for문
            for (int j = coin[i]; j <= k; j++) { //그 코인 가치부터 k까지
                dp[j] += dp[j - coin[i]]; // 코인 i를 안 썼을 때의 경우의 수
            }            
        }

        System.out.println(dp[k]);
    } //main
} //class
