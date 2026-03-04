import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 99) {
            return n;
        }
        int answer = 99;
        int first, second, third;
        for (int i = 100; i <= n; i++) {
            first = i % 100;
            second = (i / 10) % 10;
            third = (i / 100) % 10;
            if ((third - second) == (second - first)) answer++;
        }

        return answer;


    }


}

