import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            String str = br.readLine();
            int[] count = new int[n];
            for (int i = 0; i < n; i++) {
                count[i] = str.charAt(i) - '0';
            }
            String mine = br.readLine();
            int result = 0;

            for (int i= 0; i < n; i++) {
                if (i == 0) {
                    if (count[0] != 0 && count[1] != 0) {
                        count[0]--;
                        count[1]--;
                        result++;
                    }
                } else if (i == n - 1) {
                    if (count[n - 1] != 0 && count[n - 2] != 0) {
                        count[n - 1]--;
                        count[n - 2]--;
                        result++;
                    }
                } else {
                    if (count[i - 1] != 0 && count[i] != 0 && count[i + 1] != 0) {
                        count[i - 1]--;
                        count[i]--;
                        count[i + 1]--;
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");



        }
        System.out.println(sb);
    }

}
