import java.util.*;

class Solution {
    int[][] dir = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        BFS(maps,visited);
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer==0){
            answer = -1;
        }
        return answer;
    }
    
    public void BFS(int[][] maps, int[][] visited){
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();    
        queue.add(new int[]{x,y});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            for(int k=0; k<4; k++){
                int nx = cx+dir[k][0];
                int ny = cy+dir[k][1];
                
                if(nx>=0 && nx <maps.length && ny >=0 &&ny<maps[0].length){
                    if(visited[nx][ny]==0 && maps[nx][ny]==1){
                        visited[nx][ny] = visited[cx][cy]+1;
                        queue.add(new int[]{nx,ny});
                    }
                }
            
            } // dir end 
        }// while end 
    }// bfs end 
}
