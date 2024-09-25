import java.io.*;
import java.io.InputStreamReader;

public class Main {
    static int n, r, c;
    static StringBuilder sb;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        map = new char[4 * n - 1][4 * n - 3];
        for (int i = 0; i < 4 * n - 1; i++) {
            for (int j = 0; j < 4 * n - 3; j++) {
                map[i][j] = ' ';
            }
        }

        if (n == 1) sb.append('*');
        else {
            solve(0 , n);
            for (int i = 0; i < 4 * n - 1; i++) {
                for (int j = 0; j < 4 * n - 3; j++) {
                    sb.append(map[i][j]);
                    if (i == 1) break;
                }
                if (i != 4 * n - 2) sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }
    static void solve(int p, int N){
        if (N == 1)
            map[p][p] =
        map[p+1][p] =
        map[p+2][p] = '*'; // 노란색
        else {
            int row = 4*N-1, col = row-2;
            for (int i = p; i < p+col; i++)
                map[p][i] =
            map[p+row-1][i] = '*'; // 연두색

            for (int i = p+2; i < p+row-1; i++)
                map[i][p] =
            map[i][p+col-1] = '*'; // 하늘색

            map[p+1][p] =
            map[p+2][p+col-2] = '*'; // 분홍색

            solve(p+2, N-1);
        }
    }

}

//https://kyr-db.tistory.com/175
