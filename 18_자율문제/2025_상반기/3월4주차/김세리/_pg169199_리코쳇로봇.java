import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static int n,m,startX,startY,endX,endY,ans;
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char tmp = board[i].charAt(j);
                map[i][j] = tmp;
                if(tmp=='R') {
                    startX = i;
                    startY = j;
                } else if(tmp=='G'){
                    endX = i;
                    endY = j;
                }
            }
        }
        
        return bfs(startX,startY);
    }
    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new int[] {x,y,0});
        visited[x][y]=true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int count = curr[2];
            
            if(cx==endX && cy==endY){
                return count;
            }
            for(int d=0;d<4;d++){
                int nx = cx;
                int ny = cy;
                
                while(true){
                    int tx = nx+dx[d];
                    int ty = ny+dy[d];
                    if(tx<0 || tx>=n || ty<0 || ty>=m || map[tx][ty]=='D') break;
                    
                    nx = tx;
                    ny = ty;
                }
                
                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.add(new int[] {nx,ny,count+1});
                }
            }
        }
        return -1;
    }
}
