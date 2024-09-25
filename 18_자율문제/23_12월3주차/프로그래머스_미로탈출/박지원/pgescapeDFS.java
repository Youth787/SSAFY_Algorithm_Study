//틀린코드!!
//DFS문제는 BFS로 풀 수 있지만, BFS문제는 DFS로 안풀릴 수 있따..
class Solution {
    static char[][] map;
    static boolean[][] visited;
    static boolean isL, isE;
    static int answer, sum, r, c, Lr, Lc, w, h;
    public int solution(String[] maps) {
        answer = 987654321;
        sum = 987654321;
        r = 0;
        c = 0;
        Lr = 0;
        Lc = 0;
        w = maps.length;
        h = maps[0].length();
        
        map = new char[w][h];
        visited = new boolean[w][h];
        isL = false;
        isE = false;
        
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    r = i;
                    c = j;
                }
            }
        }
        //입력 끝
        findL(r, c, 0);
        if (!isL) answer = -1;
        else {
            visited = new boolean[w][h];
            dfs(Lr, Lc, sum);
            if (!isE) answer = -1;
        }
        
        
        return answer;
    }
    static void findL(int x, int y, int cnt) {
        if (x < 0 || y < 0 || x >= w || y >= h || visited[x][y] || map[x][y] == 'X') return;
        if (map[x][y] == 'L') {
            isL = true;
            Lr = x;
            Lc = y;
            sum = Math.min(sum, cnt);
            return;
        }
        visited[x][y] = true;
        findL(x, y + 1, cnt + 1); // 하
        findL(x, y - 1, cnt + 1); // 상
        findL(x + 1, y, cnt + 1); // 우
        findL(x - 1, y, cnt + 1); // 좌
        
    }
    static void dfs(int x, int y, int cnt) {
        if (x < 0 || y < 0 || x >= w || y >= h || visited[x][y] || map[x][y] == 'X') return;
        if (map[x][y] == 'E') {
            isE = true;
            answer = Math.min(answer, cnt);
            return;
        }
        visited[x][y] = true;
        dfs(x, y + 1, cnt + 1); // 하
        dfs(x, y - 1, cnt + 1); // 상
        dfs(x + 1, y, cnt + 1); // 우
        dfs(x - 1, y, cnt + 1); // 좌
    }
}
