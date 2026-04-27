import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lecture = new int[n];
        int right = 0;
        st = new StringTokenizer(br.readLine());
        int left = 0;
        for (int i = 0; i < n; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            right += lecture[i];
            left = Math.max(left, lecture[i]);
        }

        int mid;
        long total;
        while (left <= right) {
            total = 0;
            mid = (left + right) / 2;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                total += lecture[i];
                if (total > mid) {
                    total = lecture[i];
                    cnt++;
                }
            }
            if (cnt <= m) right = mid - 1;
            else left = mid + 1;
        }
        System.out.println(left);


    }

}