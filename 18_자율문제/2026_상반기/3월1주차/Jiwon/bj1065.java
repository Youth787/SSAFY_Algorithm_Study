import java.util.*;
import java.io.*;

public class bj1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 99) {
            System.out.println(n);
            return;
        }
        int answer = 99;
        int first, second, third;
        for (int i = 100; i <= Math.min(n, 999); i++) {
            first = i % 10;
            second = (i / 10) % 10;
            third = (i / 100) % 10;
            if ((third - second) == (second - first)) answer++;
        }

        System.out.println(answer);


    }


}

