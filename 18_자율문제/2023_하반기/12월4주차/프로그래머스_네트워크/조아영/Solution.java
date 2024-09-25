class Solution {
    static int num;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        num = 0;
        
        /* 모든 컴퓨터를 살펴보며 네트워크에 연결되어있는 컴퓨터는 true처리하며 개수 세기*/
        for(int i=0; i<n;i++){
            if(!visited[i]){
                dfs(n,computers, visited, i);
                num++;
            }
            
        }
        answer = num;
        return answer;
    }
    public void dfs(int n, int[][] computers, boolean[] visited, int i){
        visited[i]=true; 
            
        // 연결되어있다면 타고 들어가기
        for(int j=0;j<n;j++){
            if(computers[i][j]==1 && !visited[j] && j!=i){
                dfs(n,computers,visited,j);
                
            }
        }
        
    }
}
