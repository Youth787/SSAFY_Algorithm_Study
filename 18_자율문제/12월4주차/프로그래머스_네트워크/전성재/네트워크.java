class Solution {
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        visited = new boolean[n];
        
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, computers);
            }
        }
        
        
        
        return answer;
    }
    
    static void dfs(int node, int[][] computers){
        visited[node] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(!visited[i] && computers[node][i]== 1){
                dfs(i, computers);
            }
        }
    }
    
}
