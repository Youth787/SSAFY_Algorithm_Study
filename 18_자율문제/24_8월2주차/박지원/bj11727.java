//백준 2 * n 타일링 2 자바
//점화식만 알면 쉽게 풀리는 문제

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 2];
        arr[1] = 1;
        arr[2] = 3;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + 2 * arr[i - 2]) % 10007;
        }
        System.out.println(arr[n]);
    }
}
