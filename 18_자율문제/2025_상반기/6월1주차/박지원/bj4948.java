//백준 베르트랑 공준 자바
//소수찾기

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) break;
            sb.append(getNum(temp)).append("\n");
        }

        System.out.println(sb.toString());
    }
    private static int getNum(int num) {
        if (num == 1) return 1;
        int count = 0;
        for (int i = num + 1; i <= num * 2; i++) {
            boolean flag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) count++;
        }
        return count;
    }
}
