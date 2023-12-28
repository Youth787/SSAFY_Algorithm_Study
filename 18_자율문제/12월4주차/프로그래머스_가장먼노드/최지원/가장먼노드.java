//1번노드에서 가장 멀리 떨어진 노드의 갯수(최단경로 구했을 때 간선의 개수)를 구하는 문제
//BFS(queue), visited 활용 풀이
import java.util.*;

class Solution {
    static List <List<Integer>> adjList = new ArrayList<>();//인접 리스트 방식으로 간선 정보 저장
    static boolean [] visited;//방문처리
    static int [] distance; //최단 거리 저장

    public int solution(int n, int[][] edge) { //1번부터 n개의 노드
        visited = new boolean [n+1];
        distance = new int [n+1];
		
        Arrays.fill(distance, Integer.MAX_VALUE);//최소값이니까 최대로 초기화

        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e : edge) {     
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);//양방향
        }

        BFS(1);//사이즈를 1 크게 만들었으니까(0부터니까)

        Arrays.sort(distance);//정렬
        int cnt = 0;
        for(int i = n; i >= 1; i--) { //가장 멀리 떨어진 노드를 찾기 위해 뒤에서부터 확인했음
            if(distance[i] != Integer.MAX_VALUE) { 
		//인접한 노드가 있는 친구라면 BFS 돌리면서 초기화값이 최단거리 값으로 변화했었을테니까
                cnt = 1;//본인 노드 포함
                for(int j = i-1; j >= 1; j--) { // distance[i]와 같은 값을 찾음
                    if(distance[i] != distance[j]) break;
                    cnt++;//값이 같다면 cnt+1함
                }
                break;
            }
        }
        return cnt;
    }//solution

    static void BFS(int v) {
        Queue <Integer> queue = new LinkedList<>();
        queue.add(v);//시작점 큐에 추가하고
        visited[v] = true;//방문처리
        distance[v] = 0;//1번에서 1번까지 가는 거리는 0

        while(!queue.isEmpty()) {
            int w = queue.poll();//현재노드 꺼내고
            for (Integer e : adjList.get(w)) { //인접하는 노드
                if(!visited[e]) {
                    queue.add(e);//아직 방문 전이면 큐에 추가하고
                    visited[e] = true;//방문처리
                    distance[e] = distance[w] + 1; //현재노드까지의 최단거리에서 + 1 거리 증가함
                }
            }
        }//queue
    }//BFS
}//class
