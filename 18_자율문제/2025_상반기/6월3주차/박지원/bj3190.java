//백준 뱀 자바
//구현, 큐

import java.io.*;
import java.util.*;

public class Main {
    private static int n, k, l;
    private static int[][] map;
    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static class Spin {
        int time;
        String dir;

        public Spin(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        //빈칸 0 뱀 1 사과 2
        map[1][1] = 1;
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }
        l = Integer.parseInt(br.readLine());

        Queue<Spin> spin = new LinkedList<>();
        for (int i = 1; i <= l; i++) {
            st = new StringTokenizer(br.readLine());
            spin.add(new Spin(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Queue<Node> q = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int nowx = 1;
        int nowy = 1;
        int time = 0;
        int dir = 1;
        q.add(new Node(nowx, nowy));
        while (true) {
            int mx = nowx + dx[dir];
            int my = nowy + dy[dir];
            time++;
            if (mx < 1 || my < 1 || mx > n || my > n) break;
            if (map[mx][my] == 1) break;
            
            if (map[mx][my] == 0) {
                Node node = q.poll();
                map[node.x][node.y] = 0;
            }
            if (!spin.isEmpty()) {
                if (time == spin.peek().time) {
                    Spin s = spin.poll();
                    
                    if (s.dir.equals("L")) {
                        dir = dir - 1< 0 ? 3: dir - 1;
                    } else {
                        dir = dir + 1 > 3 ? 0 : dir + 1;
                    }
                }
            }
            map[mx][my] = 1;
            q.add(new Node(mx, my));
            nowx = mx;
            nowy = my;
        }
        System.out.println(time);


    }

}
