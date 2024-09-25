import java.util.*;
import java.io.*;
public class Main {
    static char[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        star = new char[n][n * 2 - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(star[i], ' ');
        }
        stars(0, n - 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void stars(int x, int y, int n) {
        if (n == 3) {
            star[x][y] = '*';
            star[x + 1][y - 1] = star[x + 1][y + 1] = '*';
            star[x + 2][y - 2] = star[x + 2][y - 1] = star[x + 2][y] = star[x + 2][y + 1] = star[x + 2][y + 2] = '*';
            return;
        } else {
            int cut = n / 2;
            stars(x, y, cut); // 젤 위 삼각형
            stars(x + cut, y - cut, cut);  // 아래 왼쪽 삼각형
            stars(x + cut, y + cut, cut); // 아래 오른쪽 삼각형
        }

    }
}

//https://velog.io/@jii0_0/%EB%B0%B1%EC%A4%80-2448.-%EB%B3%84-%EC%B0%8D%EA%B8%B0-11-Java

