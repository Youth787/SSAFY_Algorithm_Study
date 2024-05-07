package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class position{
    int x;
    int y;
    int cnt;
    int keys;
    public position(int x, int y, int cnt, int keys){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.keys = keys;
    }
}
public class 달이차오른다가자 {
    static char[][] arr;
    static int N, M;
    static List<Character> list = new ArrayList<>(); // 열쇠를 담는다.
    static int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visit;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }// 입력완료

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '0') {
                    BFS(i, j);
                    break;
                }
            }
        }

        System.out.println(answer);

    }


    public static void BFS(int i, int j) {
        Queue<position> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][64]; // 64는 2^6, 열쇠가 a-f까지 있으므로
        q.add(new position(i, j, 0, 0)); // 초기 열쇠 상태는 0 (없음)
        visited[i][j][0] = true;

        while (!q.isEmpty()) {
            position current = q.poll();
            int r = current.x;
            int c = current.y;
            int cnt = current.cnt;
            int keys = current.keys;

            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc][keys]) {
                    char cell = arr[nr][nc];
                    if (cell == '#') continue; // 벽은 무시
                    else if (cell >= 'a' && cell <= 'f') { // 열쇠를 찾음
                        int newKeys = keys | (1 << (cell - 'a')); // 열쇠 추가
                        if (!visited[nr][nc][newKeys]) {
                            visited[nr][nc][newKeys] = true;
                            q.add(new position(nr, nc, cnt + 1, newKeys));
                        }
                    } else if (cell >= 'A' && cell <= 'F') { // 문을 만남
                        if ((keys & (1 << (cell - 'A'))) != 0) { // 열쇠가 있으면
                            visited[nr][nc][keys] = true;
                            q.add(new position(nr, nc, cnt + 1, keys));
                        }
                    } else if (cell == '.' || cell == '0') { // 이동 가능
                        visited[nr][nc][keys] = true;
                        q.add(new position(nr, nc, cnt + 1, keys));
                    } else if (cell == '1') { // 출구
                        answer = cnt + 1;
                        return;
                    }
                }
            }
        }
        answer = -1; // 출구를 찾을 수 없음
    }

}
