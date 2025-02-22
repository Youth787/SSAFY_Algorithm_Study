import java.util.*;
import java.io.*;

class Solution {
    static boolean[][] map = new boolean[101][101];
    static boolean[][] newMap = new boolean[101][101];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        drawMap(rectangle);
        
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2);
    }
    static void drawMap(int[][] rectangle){
        for(int[] curr : rectangle){
            int a=curr[0]*2, b=curr[1]*2, c=curr[2]*2, d=curr[3]*2;
            for(int x=a;x<=c;x++){
                map[x][b] = true;
                map[x][d] = true;
            }
            for(int y=b;y<=d;y++){
                map[a][y] = true;
                map[c][y] = true;
            }
        }
        
        for(int[] curr : rectangle){
            int a=curr[0]*2, b=curr[1]*2, c=curr[2]*2, d=curr[3]*2;
            for(int x=a+1;x<c;x++){
                for(int y=b+1;y<d;y++){
                    map[x][y]=false;
                }
            }
        }
    }
    
    static int bfs(int startX, int startY, int targetX, int targetY){
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startX,startY,0});
        visited[startX][startY]=true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currD = curr[2];
            
            if(currX==targetX && currY==targetY){
                return currD/2;
            }
            for(int d=0;d<4;d++){
                int dr = currX+dx[d];
                int dc = currY+dy[d];
                if(dr>=0 && dr<=100 && dc>=0 && dc<=100 && map[dr][dc] && !visited[dr][dc]){
                    visited[dr][dc]=true;
                    q.add(new int[]{dr,dc,currD+1});
                }
            }
        }
        return -1;
    }
}
