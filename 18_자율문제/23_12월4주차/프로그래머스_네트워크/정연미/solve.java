import java.util.*;

class Solution {
    static boolean[] visit;
    static int n, answer;
    static int[][] computers;
    
    public int solution(int n, int[][] computers) {
        Solution.n = n;
        Solution.computers = computers;
        
        answer = 0;
        visit = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visit[i]) continue;
            DFS(i);
            answer++;
        }
        return answer;
    }
    
    public static void DFS(int idx){
        visit[idx] = true;
        for(int i=0; i<n; i++) {
            if(!visit[i] &&computers[idx][i]==1) {
                DFS(i);
            }
        }
    }
}