import java.util.*;
import java.io.*;

public class bj1744 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int sum = 0;
        int idx = -1;
        for (int i= 1; i < n; i+=2) {
            if (arr[i - 1] >= 0 || arr[i] > 0) break;
            check[i - 1] = true;
            check[i] = true;
            sum += arr[i] * arr[i - 1];
            idx = i;
        }

        int start = idx + 1;
        for (int i = n - 1; i - 1 >= start; i-=2) {
            if (arr[i] <= 0 || arr[i - 1] <= 0) break;
            if (arr[i] + arr[i - 1] > arr[i] * arr[i - 1]) {
                sum += arr[i] + arr[i - 1];
                check[i] = true;
                check[i - 1] = true;
                continue;
            }
            check[i] = true;
            check[i - 1] = true;
            sum += arr[i] * arr[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) sum += arr[i];
        }

        System.out.println(sum);
    }

}