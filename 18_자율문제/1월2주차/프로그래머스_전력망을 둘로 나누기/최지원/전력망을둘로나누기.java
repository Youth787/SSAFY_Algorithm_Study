import java.util.ArrayList;
 /*
  * 송전탑 n개가 트리 형태로 연결됨. 
  * 한 전선을 끊어서 전력망 네트워크를 송전탑 개수가 최대한 비슷하게 2개로 분할
  * 두 전력망이 가진 송전탑 개수 차이의 "최소값"
  */
class Solution {
    static ArrayList<Integer>[] adjList; //각 노드의 인접 리스트 저장
    static int answer; //최소값
 
    public int solution(int n, int[][] wires) {
        adjList = new ArrayList[n + 1]; //송전탑의 번호는 1부터니까
        answer = Integer.MAX_VALUE; //우선 최대로 초기화
 
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>(); //각 노드마다 ArrayList로 연결되는 노드 저장
        }
 
        // 양방향
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            adjList[v1].add(v2);
            adjList[v2].add(v1); //반대로도 
        }

        //간선 없다고 생각하고 양쪽 차이 계산하고 비교, 다시 복원하면서 모든 간선 돌기
        for (int i = 0; i < wires.length; i++) {
            //간선 정보 다시 꺼내서
            int v1 = wires[i][0];
            int v2 = wires[i][1];
 
            //해당 간선을 끊었다고 생각하고 확인
            adjList[v1].remove(Integer.valueOf(v2)); //간선 제거
            adjList[v2].remove(Integer.valueOf(v1)); //양방향

            boolean [] visited = new boolean [n + 1]; //방문처리(DFS에서 사용)
            int cnt = DFS(1, visited); //DFS
 
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
  
            adjList[v1].add(v2);
            adjList[v2].add(v1); //간선 복원
        }
 
        return answer;
    }
 
    static int DFS(int v, boolean[] visited) {
        visited[v] = true; //지금 그 노드 방문했다
        int cnt = 1; //현재 노드를 포함하여 탐색 1번 했다
 
        for (int next : adjList[v]) { //지금 노드에서 간선으로 연결된 노드들 순회
            if (!visited[next]) { //방문 안했다면
                cnt += DFS(next, visited); //계속 dfs 파고 들어가서
        }
 
        return cnt; //현재 노드랑 연결된 노드 수
    }
}
