import java.util.*;
import java.io.*;

class Solution {
    static char[][] map;
    static int n,m,startX,startY,leverX,leverY,endX,endY;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char tmp = maps[i].charAt(j);
                map[i][j] = tmp;
                if(tmp=='S'){
                    startX=i; startY=j;
                }
                if(tmp=='L'){
                    leverX=i; leverY=j;
                }
                if(tmp=='E'){
                    endX=i; endY=j;
                }
            }
        }
        int first = bfs(startX, startY, leverX, leverY);
        int second = bfs(leverX, leverY, endX, endY);
        int ans=0;
        if(first==-1 || second==-1) ans=-1;
        else ans = first+second;
        return ans;
    }
    static int bfs(int x, int y, int desX,int desY){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new int[]{x,y,0});
        visited[x][y]=true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cnt = curr[2];

            if(cx==desX && cy==desY){
                return cnt;
            }
            for(int d=0;d<4;d++){
                int nx = cx+dx[d];
                int ny = cy+dy[d];
                if(nx<0 || ny<0 || nx>=n || ny>=m || map[nx][ny]=='X' || visited[nx][ny]) continue;
                
                visited[nx][ny]=true;
                q.add(new int[] {nx,ny,cnt+1});
            }
        }
        
        return -1;
    }
}
