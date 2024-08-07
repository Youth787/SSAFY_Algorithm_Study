//백준 AC 자바
//문자열 입출력 처리, Deque문제

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringBuilder sb = new StringBuilder();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1, str.length() - 1);  // 양 끝 대괄호 제거
            String[] arr = str.isEmpty() ? new String[0] : str.split(",");
            Deque<Integer> q = new LinkedList<>();
            for (String s : arr) {
                if (!s.isEmpty()) {  // 빈 문자열 확인
                    q.add(Integer.parseInt(s));
                }
            }

            boolean flag = true;
            boolean front = true;
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (c == 'R') {
                    front = !front;
                } else {
                    if (!q.isEmpty()) {
                        if (front) q.pollFirst();
                        else q.pollLast();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (!flag) {
                System.out.println("error");
            } else {
                sb.append("[");
                while (!q.isEmpty()) {
                    sb.append(front ? q.pollFirst() : q.pollLast());
                    if (!q.isEmpty()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
