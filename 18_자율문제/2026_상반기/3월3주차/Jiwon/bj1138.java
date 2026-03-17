import java.util.*;
import java.io.*;

public class bj1138 {
    static int  n;
    static int BLANK = -1;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        Arrays.fill(arr, BLANK);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = 0; j < n; j++) {
                // j에서 빈곳이면 나보다 큰 곳임
                if (arr[j] == BLANK) {
                    if (count == now) {
                        arr[j] = i + 1;
                        break;
                    }
                    count++;
                }

            }
        }

        for (int a: arr) System.out.print(a + " ");
    }

}