import java.util.*;
import java.io.*;

public class Main {
    static int dr [] = {0, 0, -1, 1};
    static int dc [] = {-1, 1, 0, 0};
    static boolean visited[][];
    static int map[][];
    static int size[][];
    static int N, nr, nc;

    static class Point implements Comparable<Point> {
        int r;
        int c;
        int size;

        public Point(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }

        @Override
        public int compareTo(Point o) {
            return size - o.size;
        }
    }//point, 비교 기준

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 1;

        String temp = "";
        while( !(temp = br.readLine()).isEmpty()  ) {
            N = Integer.parseInt(temp);
            if(N == 0) {
                break;
            }

            map = new int [N][N];
            visited = new boolean [N][N];
            size = new int [N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());    
                    size[i][j] = Integer.MAX_VALUE / 4;
                }
            }

            BFS(0, 0, map[0][0]);
            sb.append("Problem " + count + ": " + size[N-1][N-1]).append('\n');
            count++;
        }

        System.out.println(sb);

    }//main

    private static void BFS(int r, int c, int rp) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        visited[r][c] = true;
        queue.offer(new Point(r, c, rp));

        while( !queue.isEmpty() ) {
    
            Point point = queue.poll();

            for(int i=0; i<4; i++) {
                nr = point.r + dr[i];
                nc = point.c + dc[i];

                if( chk() && !visited[nr][nc] && size[nr][nc] > (map[nr][nc] + point.size) ) {
                    size[nr][nc] = map[nr][nc] + point.size;
                    visited[nr][nc] = true;
                    queue.offer( new Point( nr, nc, size[nr][nc] ));
                }
            }//사방탐색
        }
    }//BFS

    static boolean chk() {
        return (nr >= 0 && nc >= 0 && nr < N && nc < N);
    }//chk

}//class
