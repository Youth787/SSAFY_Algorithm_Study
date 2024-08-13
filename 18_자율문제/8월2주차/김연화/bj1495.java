import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,S,M;
    static int [] V;
    static boolean [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N = 곡의 개수
        S = Integer.parseInt(st.nextToken()); // S = 시작 볼륨
        M = Integer.parseInt(st.nextToken()); // M = 볼륨의 최대

        st = new StringTokenizer(br.readLine());
        V = new int[N + 1]; // 각 곡이 시작하기 전에 줄 수 있는 볼륨의 차이

        dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {
                    int plus = j + V[i];
                    int minus = j - V[i];

                    if (plus <= M) dp[i][plus] = true;
                    if (minus >= 0) dp[i][minus] = true;
                }
            }
        }
        int answer = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }
}
