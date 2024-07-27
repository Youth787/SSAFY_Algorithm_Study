//백준 감시 자바
//DFS, 구현

import java.io.*;
import java.util.*;

public class Main{
    private static int n, m, cctvs;
    private static int[][] map;
    private static boolean[][] checked;
    private static class CCTV {
        int x, y, type;
        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    private static ArrayList<CCTV> cctv;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        checked = new boolean[n][m];
        cctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) checked[i][j] = true; // 씨씨티비와 벽은 true처리
                if (map[i][j] != 0 && map[i][j] != 6) cctv.add(new CCTV(i, j, map[i][j])); // cctv넣어주기
            }
        }
        cctvs = cctv.size();
        DFS(0, checked);
        
        System.out.println(answer);


    }
  //DFS함수, cctv 갯수가 count와 같으면 answer갱신 후 리턴. 
    private static void DFS(int count, boolean[][] visited) {
        if (count == cctvs) {
            answer = Math.min(answer, countFalse(visited));
            return;
        }
        //현재 감시하는 CCTV가져오기
        CCTV now = cctv.get(count);
        switch (now.type) {
            case 1: // 4가지 방법
                boolean[][] arr0 = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr0[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, upside(now.x, now.y, arr0));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr0[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, downside(now.x, now.y, arr0));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr0[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, rightside(now.x, now.y, arr0));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr0[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, leftside(now.x, now.y, arr0));
                break;
            case 2: // 2가지 방법
                boolean[][] arr = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, upside(now.x, now.y, downside(now.x, now.y, arr)));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, rightside(now.x, now.y, leftside(now.x, now.y, arr)));
                break;
            case 3: // 4가지 방법
                boolean[][] arr2 = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr2[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, upside(now.x, now.y, leftside(now.x, now.y, arr2)));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr2[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, rightside(now.x, now.y, upside(now.x, now.y, arr2)));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr2[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, rightside(now.x, now.y, downside(now.x, now.y, arr2)));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr2[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, downside(now.x, now.y, leftside(now.x, now.y, arr2)));
                break;
            case 4: //4가지 방법
                boolean[][] arr3 = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr3[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, downside(now.x, now.y, rightside(now.x, now.y, upside(now.x, now.y, arr3))));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr3[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, downside(now.x, now.y, rightside(now.x, now.y, leftside(now.x, now.y, arr3))));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr3[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, downside(now.x, now.y, leftside(now.x, now.y, upside(now.x, now.y, arr3))));
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr3[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, leftside(now.x, now.y, rightside(now.x, now.y, upside(now.x, now.y, arr3))));
                break;
            case 5: // 1가지 방법
                boolean[][] arr4 = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr4[i][j] = visited[i][j];
                    }
                }
                DFS(count + 1, leftside(now.x, now.y, downside(now.x, now.y, rightside(now.x, now.y, upside(now.x, now.y, arr4)))));
                break;
        }
    }

  //위, 아래, 왼쪽, 오른쪽 true 체크해주는 함수들. 체크한 뒤 boolean[][]배열을 리턴.
    private static boolean[][] upside(int x, int y, boolean[][] visited) {
        for (int i = x - 1; i >= 0; i--) {
            if(map[i][y] == 6) break;
            visited[i][y] = true;
        }
        return visited;
    }
    private static boolean[][] downside(int x, int y, boolean[][] visited) {
        for (int i = x + 1; i < n; i++) {
            if(map[i][y] == 6) break;
            visited[i][y] = true;
        }
        return visited;
    }
    private static boolean[][] leftside(int x, int y, boolean[][] visited) {
        for (int i = y - 1; i >= 0; i--) {
            if(map[x][i] == 6) break;
            visited[x][i] = true;
        }
        return visited;
    }
    private static boolean[][] rightside(int x, int y, boolean[][] visited) {
        for (int i = y + 1; i < m; i++) {
            if(map[x][i] == 6) break;
            visited[x][i] = true;
        }
        return visited;
    }

  // false갯수 세주는 함수
    private static int countFalse(boolean[][] b) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!b[i][j]) count++;
            }
        }
        return count;
    }

}
