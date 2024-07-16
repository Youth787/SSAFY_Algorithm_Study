import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[][] map;
    static int ans;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static class Node {
        int y; int x;

        Node (int y, int x){
            this.y = y; this.x = x;
        }
    }
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; ++t) {
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N+1][M+1];
            visited = new boolean[N+1][M+1];

            for(int i=0; i<N; ++i) {
                String line = br.readLine();

                for(int j=0; j<M; ++j) {
                    if(line.charAt(j) == '#') {
                        map[i][j] = 1; // 양
                    } else {
                        map[i][j] = 0;
                    }
                }
            }

            for(int i=0; i<N; ++i) {
                for(int j=0; j<M; ++j) {
                    if(map[i][j] == 0) continue;
                    if(visited[i][j]) continue;
                    bfs(i, j);
                    ans++;
                }
            }

            bw.write(ans + "\n");

        }

        bw.flush();

    }

    static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();

        visited[y][x] = true;
        q.add(new Node(y, x));

        while(!q.isEmpty()) {
            int cy = q.peek().y, cx = q.peek().x;
            q.remove();

            for(int i=0; i<4; ++i) {
                int ny = cy+dy[i], nx = cx+dx[i];

                if(ny > N || ny < 0 || nx > M || nx < 0) continue;
                if(map[ny][nx] == 0) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.add(new Node(ny, nx));
            }

        }
    }
}
