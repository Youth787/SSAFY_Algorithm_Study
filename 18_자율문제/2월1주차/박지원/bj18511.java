import java.io.*;
import java.util.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, ans;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = 0;
        num = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        solve(0);
        System.out.println(ans);
    }

    //정렬해서 큰것부터 숫자 넣어가면서 비교 후 갱신해주기
    static void solve(int number) {
        if (number > n) return;
        if (ans < number) ans = number;

        for (int i = k - 1; i >= 0; i--) {
            solve(number * 10 + num[i]);
        }
    }

}
