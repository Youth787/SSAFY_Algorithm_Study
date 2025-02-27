//이분탐색
//서로다른배열4개가 아닌 문제. 헷갈렸다. 그리고 ab, cd로 둘로 나눠서 생각을 못함

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] abcd = new int[n][4];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                abcd[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] ab = new int[n * n];
        int[] cd = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i * n + j] = abcd[i][0] + abcd[j][1];
                cd[i * n + j] = abcd[i][2] + abcd[j][3];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        int abp = 0;
        int cdp = n * n - 1;
        long cnt = 0;
        while (abp < n * n && cdp > -1) {
            long abv = ab[abp];
            long cdv = cd[cdp];
            long res = abv + cdv;
            if (res < 0) abp++;
            else if (res > 0) cdp--;
            else {
                long xc = 0;
                long yc = 0;
                while (abp < n * n && abv == ab[abp]) {
                    abp++;
                    xc++;
                }
                while (cdp > -1 && cdv == cd[cdp]) {
                    cdp--;
                    yc++;
                }
                cnt += xc * yc;

            }
        }
        System.out.println(cnt);
    }


}

