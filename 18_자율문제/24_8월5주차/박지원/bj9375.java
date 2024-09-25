//백준 패션왕 신해빈 자바
//맵을 쓰면 쉽게 풀리는 문제

import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t  = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] temp = br.readLine().split(" ");
                map.put(temp[1], map.getOrDefault(temp[1], 0) + 1);
            }
            int answer = 1;
            for (String s: map.keySet()) {
                answer *= (map.get(s) + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
