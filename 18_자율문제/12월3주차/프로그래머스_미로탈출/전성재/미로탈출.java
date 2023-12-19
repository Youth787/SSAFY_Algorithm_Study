import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] le = new int[2];
    
    public int solution(String[] maps) {
        char[][] arr = new char[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        int startX = 0, startY = 0;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                arr[i][j] = maps[i].charAt(j);
                if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int l = bfs(arr, startX, startY, visited, 'L');
        if (l == -1) {
            return -1;
        }
        
        visited = new boolean[maps.length][maps[0].length()];
        int e = bfs(arr, le[0], le[1], visited, 'E');
        if (e == -1) {
            return -1;
        }
        
        return l + e;
    }
    
    static int bfs(char[][] arr, int x, int y, boolean[][] visited, char target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cnt = temp[2];
            for (int i = 0; i < 4; i++) {
                int dr = temp[0] + dx[i];
                int dc = temp[1] + dy[i];
                
                if (dr >= 0 && dr < arr.length && dc >= 0 && dc < arr[0].length) {
                    if (arr[dr][dc] == target) {
                        le[0] = dr;
                        le[1] = dc;
                        return cnt + 1;
                        
                    } else if (arr[dr][dc] != 'X' && !visited[dr][dc]) {
                        q.add(new int[] {dr, dc, cnt + 1});
                        visited[dr][dc] = true; // 방문 체크
                    }
                }
            }
        }
        return -1;
    }
}
