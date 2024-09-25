//어려웜...
package p9205_맥주마시면서걸어가기;
// https://www.acmicpc.net/problem/9205
//문제: 맥주 20개를 담은 한 박스를 들고 출발해, 50m에 한번씩 마셔야 한다.
//편의점, 상근이 집, 락페 좌표 주어졌을 때

//출력: "happy"/ 중간에 맥주가 바닥나서 더 이동할 수 없으면 "sad".

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
class Point {//좌표 클래스 생성
    int r;
    int c;
 
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
 
public class Main { 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());//t(50이하)
 
        ArrayList<Point> a; // 중요한 좌표(집, 편의점, 락페)
        ArrayList<ArrayList<Integer>> graph;
        
        StringBuilder sb = new StringBuilder();
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());//편의점 수 n(0이상 100이하)
 
            a = new ArrayList<>();
            
            // 집, 편의점, 페스티벌에 위치를 저장함.
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                a.add(new Point(r, c));
            }//입력
 
            graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }
            
            // 맨해튼 거리 1000m 이하를 만족하는 두 정점을 찾음.
            // 그리고 양방향 그래프로 서로 이어 줌.
            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (dist(a.get(i), a.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }
            
            // BFS를 이용하여 집에서 페스티벌까지 갈 수 있는지 탐색.
            if (BFS(graph, n)) sb.append("happy").append('\n');
            else sb.append("sad").append('\n');

            t--;
        }
        
        System.out.println(sb);
    }//main
    
    //송도는 직사각형 모양으로 생긴 도시. 두 좌표 사이의 거리는 (x 좌표 차) + (y 좌표의 차이)
    public static int dist(Point p1, Point p2) {
        return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
    }
    
    //너비 우선 탐색
    public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
 
        boolean[] visited = new boolean[n + 2];
        visited[0] = true;
 
        while (!q.isEmpty()) {
            int now = q.poll();
 
            if (now == n + 1) {
                return true;
            }
 
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        } 
        return false;
    }//BFS
 
}//class
