//백준 다각형의 면적 자바
//기하학,, 신발끈공식 ,,

import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];
        long sumA = 0;
        long sumB = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        x[n] = x[0];
        y[n] = y[0];
        
        for (int i = 0; i < n; i++) {
            sumA += x[i] * y[i + 1];
            sumB += x[i + 1] * y[i];
        }
        String area = String.format("%.1f", (Math.abs(sumA - sumB) / 2.0));
        System.out.println(area);
    }


}
