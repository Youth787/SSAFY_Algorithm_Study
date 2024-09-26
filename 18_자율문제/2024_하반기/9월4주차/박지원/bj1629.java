//백준 곱셈 자바
//수학문제, 지수를 잘 활용해보기

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int c = Integer.parseInt(temp[2]);
        System.out.println(pow(a, b, c));
    }
    private static long pow (int a, int b, int mod) {
        if (b == 0) return 1;
        long n = pow(a, b / 2, mod);
        if (b % 2 == 0) return n * n % mod;
        else return (n * n % mod) * a % mod;
    }
}
