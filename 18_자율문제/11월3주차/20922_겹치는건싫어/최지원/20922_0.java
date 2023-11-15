import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int [] count = new int[100001];
        int start = 0;
        int end = 0;
        int answer = Integer.MIN_VALUE;

        while (end < n) {
            // 늘릴 수 있으면 end 증가
            while (end < n && count[num[end]] + 1 <= k) {
                count[num[end++]]++;
            }
            // 더이상 늘릴 수 없음
            int len = end - start;
            answer = Math.max(answer, len);

            //start 이동
            count[num[start++]]--;
        }

        System.out.print(answer);
    }
}
