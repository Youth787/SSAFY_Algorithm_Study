import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {
    static char[][] map;
    static int answer;
    static boolean[][] visited;
    static int[] cnt, total;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        visited = new boolean[12][6];
        cnt = new int[6];
        answer = 0;

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (!visited[i][j] && map[i][j] != '.') {
                    bfs(i, j);
                }
            }
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }
        System.out.println(answer);

    }
    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        int sum = 0;
        total = new int[6];
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int moveR = cur.x + dr[i];
                int moveC = cur.y + dc[i];
                if (moveC >= 0 && moveC < 6 && moveR - cnt[moveC] < 12 && moveR - cnt[moveC] >= 0 && !visited[moveR - cnt[moveC]][moveC] && map[x][y] == map[moveR - cnt[moveC]][moveC] ) {
                    sum++;
                    total[moveC]++;
                    visited[moveR - cnt[moveC]][moveC] = true;
                    q.add(new Node(moveR - cnt[moveC], moveC));
                }
            }
        }
        if (sum >= 4) {
            for (int i = 0; i < 6; i++) {
                cnt[i] += total[i];
                System.out.print(cnt[i] + " ");
            }
            System.out.println();
            answer++;
        } 

    }

}
//맨 아랫줄부터 dfs를 도는데, 일차원배열 cnt[i] > i번째줄에 visited한 갯수를 뺀숫자에서 돌아야함..
//.....P
//....GG
//....GG
//....GG
//....GG
//....GG
//....GG
//....GG
//.Y..GG
//.YG.GG
//RRYGPP
//RRYGGP
//이게 해결이안되는코드 ㅜㅜ
