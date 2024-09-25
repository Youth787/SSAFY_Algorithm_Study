import java.util.*;

class Solution {
    // 최대 탐험 던전 수
    private int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        int N = dungeons.length;
        boolean[] visited = new boolean[N];
        generateDun(dungeons, k, 0, visited);
        
        return answer;
    }
    
    private void generateDun(int[][] dungeons, int k, int cnt, boolean[] visited){
            
        if(cnt>answer) answer=cnt;
        
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && dungeons[i][0]<=k){
                visited[i] = true;
                generateDun(dungeons, k-dungeons[i][1], cnt+1, visited);
                visited[i] = false;
            }
        }
    }
}
