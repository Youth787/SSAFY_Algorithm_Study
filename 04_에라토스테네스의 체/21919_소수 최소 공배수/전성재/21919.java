import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int[] isPrime = new int[max + 1];
        isPrime[1] = 1;
        long ans = 1;

        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i] == 1) {
                continue;
            }
            for (int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (isPrime[arr[i]] == 1) {
            	continue;
               
            }
            else {
            	 ans *= arr[i];
                 isPrime[arr[i]] = 1;
            }
        }

        if (ans == 1) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
