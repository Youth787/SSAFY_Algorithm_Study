package _11월1주차문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 맥주마시면서걸어가기_9205 {
    static boolean[] visit;

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            Point[] point = new Point[N + 2];
            visit = new boolean[N + 2];

            for (int i = 0; i < N + 2; i++) {
                String[] input = br.readLine().split(" ");
                point[i] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            BFS(point);
        } // test case end
    }// main end

    public static void BFS(Point[] point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point[0]);
        visit[0] = true;
        int size = point.length -1;
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            if(Math.abs(point[size].x-x)+Math.abs(point[size].y-y)<=1000){
                System.out.println("happy");
                return;
            }

            for(int i=1; i<size; i++){
                if(!visit[i]){
                    if(Math.abs(point[i].x-x)+Math.abs(point[i].y-y)<=1000){
                        visit[i] = true;
                        queue.offer(point[i]);
                    }
                }
            }
        }
        System.out.println("sad");
        return;
    }// method end

}
