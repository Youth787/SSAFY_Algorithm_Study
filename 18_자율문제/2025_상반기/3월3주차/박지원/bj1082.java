//백준 방 번호 자바
//그리디..

import java.util.*;
import java.io.*;


public class Main {
    private static String str, answer;
    private static int n, m;
    private static int[] stationery;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stationery = new int[n];
        int min = 50;
        int index = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stationery[i] = Integer.parseInt(st.nextToken());
            if (min >= stationery[i]) {
                min = stationery[i];
                index = i;
            }
        }
        m = Integer.parseInt(br.readLine());
        char[] digits = new char[51];
        int cnt = 0;
        while (m >= min) { //가장 비용이 작으면서, 숫자는 큰 수로 배열을 완성하기
            digits[cnt++] = (char) (index + '0');
            m -= min;
        }
        int start = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = n - 1; j >= 0; j--) {
                //현재 돈에 min더한 값이 stationery[j]보다 크다는 것은
                //더 큰 숫자를 살 수 있다는 뜻
                if (stationery[j] <= m + min) {
                    digits[i] = (char) (j + '0');
                    m += min - stationery[j];
                    break;
                }
            }
            //digits[start]가 0이라는 뜻은
            //현재 돈으로는 더 큰 숫자를 못산다는 의미
            //그래서 자릿수 1개 포기하고 min만큼의 돈을 돌려받기
            if (digits[start] == '0') {
                start++;
                m += min;
            }
        }
        if (start == cnt) {
            answer = "0";
        } else {
            answer = "";
            for (int i = start; i < cnt; i++) answer += digits[i];
        }
        System.out.println(answer);
    }


}
