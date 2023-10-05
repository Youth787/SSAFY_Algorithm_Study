// 블로그 링크
// 이해하려고 노력중,,
// https://record-developer.tistory.com/164
// https://welog.tistory.com/331


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    static int answer = 0;
 
    public static void dfs(int[] arr, int[] mult, int q, int ind) {
        if (ind == arr.length) {
            int result = Arrays.stream(mult).reduce(1, (x, y) -> x * y);
            answer = Math.max(answer, result);
            return;
        }
        for (int i = 0; i < mult.length; i++) {
            mult[i] += arr[ind];
            dfs(arr, mult, q, ind + 1);
            mult[i] -= arr[ind];
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
 
        st = new StringTokenizer(br.readLine());
        int p = Integer.valueOf(st.nextToken());
        int q = Integer.valueOf(st.nextToken());
        int[] mult = new int[q + 1];
 
        dfs(arr, mult, q, 0);
 
        System.out.println(answer);
 
    }
}
