//ㅃㅇㅃㅇㅃㅇㅃㅇㅃㅇㅃㅇ
import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String row = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = row.charAt(j);
            }
        }//입력

        // 연쇄 반응 계산
        int cnt = 0;
        while (pang(map)) {//터지면
            cnt++;
            map = drop(map);//떨구고 새로운 맵 상태 저장
        }
        System.out.println(cnt);
    }//main

    // 뿌요팡
    private static boolean pang(char[][] map) {
        boolean result = false;
        boolean[][] visited = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == '.' || visited[i][j]) continue;

                int cnt = 1;
                List<int[]> path = new ArrayList<>();
                Queue<int[]> q = new ArrayDeque<>();
                visited[i][j] = true;//방문처리
                q.add(new int[]{i, j});
                path.add(q.peek());//갈수 있는 경로 추가, 탐색
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];
                        if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || visited[nr][nc] || map[nr][nc] != map[i][j]) continue;
                        visited[nr][nc] = true;
                        cnt++;
                        int[] next = new int[]{nr, nc};
                        q.add(next);
                        path.add(next);
                    }
                }
                if (cnt < 4) continue;
                
                for (int[] cur : path) {
                    map[cur[0]][cur[1]] = '.';//터짐
                    result = true;
                }
            }
        }
        
        return result;//터지냐 안터지냐
    }//pang

    //뿌요 떨구기
    public static char[][] drop(char[][] map) {
        char[][] newMap = new char[12][6];
        for (char[] row : newMap) Arrays.fill(row, '.');
        for (int j = 0; j < 6; j++) {
            List<Character> col = new ArrayList<>();
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] == '.') continue;
                col.add(map[i][j]);
            }
            for (int i = 0; i < col.size(); i++) {
                newMap[11 - i][j] = col.get(i);
            }
        }
        return newMap;
    }//drop
}//class
