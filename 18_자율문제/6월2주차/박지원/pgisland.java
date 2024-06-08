//무인도 여행 자바로 먼저 풀기
//코드가.. 좀.. 바보같은 코드같다.. stream을 잘써야할듯..

import java.util.*;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int n, m;
    static boolean[][] visited;
    static ArrayList<Integer> answer;
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        answer = new ArrayList<>();
        visited = new boolean[n][m];
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = maps[i];
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        int[] ans;
        if (answer.size() <= 0) {
            ans = new int[1];
            ans[0] = -1;
        } else {
            ans = new int[answer.size()];
            for (int i = 0; i < answer.size(); i++) {
                ans[i] = answer.get(i);
            }
          Arrays.sort(ans);  
        } 
        return ans;
    }
    static void bfs(int x, int y) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        count += map[x][y] - '0';
        q.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                if (mx < n && my < m && mx >= 0 && my >= 0 && !visited[mx][my] && map[mx][my] != 'X') {
                    visited[mx][my] = true;
                    count += map[mx][my] - '0';
                    q.add(new Node(mx, my));
                }
            }
        }
        answer.add(count);
    }
}
