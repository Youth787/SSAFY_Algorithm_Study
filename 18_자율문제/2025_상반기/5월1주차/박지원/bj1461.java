//백준 도서관 자바
//그리디

import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] books;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        books = new int[n];
        st = new StringTokenizer(br.readLine());
        int minus = 0;
        for (int i = 0; i < n; i++) {
            books[i] = Integer.parseInt(st.nextToken());
            if (books[i] < 0) minus++;
        }
        Arrays.sort(books);
        long answer = 0;
        for (int i = 0; i < minus; i += m) {
            answer += (long) Math.abs(books[i]) * 2;
        }
        for (int i = books.length - 1; i >= minus; i -= m) {
            answer += (long) books[i] * 2;
        }
        if (Math.abs(books[0]) > books[books.length - 1]) {
            answer -= (long) Math.abs(books[0]);
        } else answer -= (long) books[books.length - 1];

        System.out.println(answer);
    }

}

