import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단순 재귀를 활용해서 조합으로 풀 경우, 시간초과 문제가 발생한다. 
// DP를 사용해서 풀어야한다. 

/*
 * What is dp?
 * 
 * 1. dp 사용 조건 
 *     - 큰 문제를 작은 문제로 나눌 수 있다. 
 *  - 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다. 
 *  
 * 2. 메모이제이션 
 *  - dp를 구현하는 방법 중 한 종류이다.
 *  - 한번 구한 결과를 메모리 공간에 메모해두고, 같은 식을 호출하면 메모한 결과를 그대로 가져오는 기법이다. 
 *  - 값을 기록해 놓는다는 점에서 캐싱이라고도 한다. 
 *  
 *  3. 탑다운, 바텀업
 *   - DP문제를 푸는 방법은 탑다운과 바텀업이 있다. 
 *   - DP의 전형적인 형태는 바텀업 방식이다. 결과 저장용 리스트는 DP 테이블이라고 부른다. 
 *   
 * */
public class 다리놓기_1010 {
    static int N;
    static int R;
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            sb.append(combination(N, R)+"\n");
        } // test case end
        System.out.println(sb);
    }// main end

    public static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        } else if (n == r || r == 0) {
            return dp[n][r] = 1;
        } else {
            return dp[n][r] = combination(n - 1, r) + combination(n - 1, r - 1);
        }
    }
}