import java.util.*;

class Solution {
    static boolean[] visit;
   static int vertex, edge, n;
    static int[][] computers;
    
    public int solution(int n, int[][] computers) {
        Solution.n = n;
        Solution.computers = computers;
        
        int answer = 0;
        visit = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visit[i]) continue;
            vertex =0; // 정점
            edge =0 ; //간선 
            DFS(i);
            if(edge == (vertex-1)*2) answer++;
        }
        return answer;
    }
    
    public static void DFS(int idx){
        vertex++;
        for(int i=0; i<n; i++) {
            if(idx!=i && computers[idx][i]==1) edge++;
        }
        visit[idx] = true;
        for(int i=0; i<n; i++) {
            if(!visit[i] &&computers[idx][i]==1) DFS(i);
        }
    }
}