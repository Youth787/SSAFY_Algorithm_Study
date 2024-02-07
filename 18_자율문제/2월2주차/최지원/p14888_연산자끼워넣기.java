import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N ; //수 개구
    static int[] number;
    static int[] operator = new int[4]; //연산자 개수
    static int MAX = Integer.MIN_VALUE;	// 최댓값
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    } //main

    public static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {

                operator[i]--;
                switch (i) {
                    case 0: dfs(num + number[idx], idx + 1);   break;
                    case 1:	dfs(num - number[idx], idx + 1);   break;
                    case 2:	dfs(num * number[idx], idx + 1);   break;
                    case 3: dfs(num / number[idx], idx + 1);   break;
                }
                operator[i]++;
            }
        }
    } //dfs
} //class
