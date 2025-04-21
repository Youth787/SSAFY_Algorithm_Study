import java.util.*;
import java.io.*;

public class _18808_스티커붙이기 {
    static int N, M, K;
    static boolean[][] laptop;
    static List<boolean[][]> stickers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        laptop = new boolean[N][M];

        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            boolean[][] sticker = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = st.nextToken().equals("1");
                }
            }

            // 스티커 붙이기 시도
            attachSticker(sticker);
        }

        // 결과 출력
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (laptop[i][j]) count++;
            }
        }
        System.out.println(count);
    }

    static void attachSticker(boolean[][] sticker) {
        for (int rot = 0; rot < 4; rot++) {
            int r = sticker.length;
            int c = sticker[0].length;

            for (int i = 0; i <= N - r; i++) {
                for (int j = 0; j <= M - c; j++) {
                    if (canAttach(i, j, sticker)) {
                        place(i, j, sticker);
                        return;
                    }
                }
            }

            // 회전
            sticker = rotate(sticker);
        }
    }

    static boolean canAttach(int x, int y, boolean[][] sticker) {
        int r = sticker.length;
        int c = sticker[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] && laptop[x + i][y + j]) return false;
            }
        }
        return true;
    }

    static void place(int x, int y, boolean[][] sticker) {
        int r = sticker.length;
        int c = sticker[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j]) laptop[x + i][y + j] = true;
            }
        }
    }

    static boolean[][] rotate(boolean[][] sticker) {
        int r = sticker.length;
        int c = sticker[0].length;
        boolean[][] newSticker = new boolean[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newSticker[j][r - i - 1] = sticker[i][j];
            }
        }
        return newSticker;
    }
}
