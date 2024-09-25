//백준 정수 삼각형 자바
//누적합

import java.io.*;
import java.util.*;

public class Main{
    private static int n, max;
    private static ArrayList<ArrayList<Integer>> list, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = 0;
        list = new ArrayList<>();
        sum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            sum.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                list.get(i).add(Integer.parseInt(temp[j]));
            }
        }
        sum.get(0).add(list.get(0).get(0));
        if (n > 1) {
            sum.get(1).add(sum.get(0).get(0) + list.get(1).get(0));
            sum.get(1).add(sum.get(0).get(0) + list.get(1).get(1));
        }
        for (int i = 2; i < n; i++) {
            sum.get(i).add(sum.get(i - 1).get(0) + list.get(i).get(0));
            for (int j = 1; j < i; j++) {
                sum.get(i).add(Math.max(sum.get(i - 1).get(j), sum.get(i - 1).get(j - 1)) + list.get(i).get(j));
            }
            sum.get(i).add(sum.get(i - 1).get(i - 1) + list.get(i).get(i));
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, sum.get(n - 1).get(i));
        }
        System.out.println(max);
    }


}
