import java.util.*;

//프로그래머스 배달 다익스트라
//3시간은 걸린듯.. 그래도 어느정도 복습은 다 됐다.
// 다음엔 안보고도 뭐가문젠지 알수있게만들기

class Road implements Comparable<Road> {
    int city;
    int dist;
    
    public Road(int city, int dist) {
        this.city = city;
        this.dist = dist;
    }
    
    public int compareTo(Road r) {
      return this.dist - r.dist;  
    }
    
}

class Solution {
    static int n, k;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        n = N;
        k = K;
        ArrayList<Road> list[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < road.length; i++) {
            int to = road[i][0];
            int from = road[i][1];
            int d = road[i][2];
            list[to - 1].add(new Road(from - 1, d));
            list[from - 1].add(new Road(to - 1, d));
        }
        
        int[] distance = new int[n];
        for (int i = 1; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Road> q = new PriorityQueue<>();
        q.add(new Road(0, 0));
        while (!q.isEmpty()) {
            Road cur = q.poll();
            if (cur.dist > distance[cur.city]) continue;
            for (int i = 0; i < list[cur.city].size(); i++) {
                    Road next = list[cur.city].get(i);
                    if (distance[next.city] > cur.dist + next.dist) {
                        distance[next.city] = cur.dist + next.dist;
                        q.add(new Road(next.city, distance[next.city]));
                    }
                
            }
            
        }
        for (int i: distance) {
            if (i <= k) answer++;
        }        
        
        return answer;
    }
}
