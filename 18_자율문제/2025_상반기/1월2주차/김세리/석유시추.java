import java.util.*;
import java.io.*;

class Solution {
    boolean[][] chkLand;
    Map<Integer,Integer> map = new HashMap<>();
    int n,m,landNum,cnt;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int solution(int[][] land) {
        n=land.length;
        m=land[0].length;
        landNum=0;
        chkLand = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1 && !chkLand[i][j]){
                    landNum++;
                    cnt=1;
                    searchOil(i,j,land);
                    map.put(landNum,cnt);
                }
            }
        }
        
        int answer = 0;
        
        for(int j=0;j<m;j++){
            int sum=0;
            Set<Integer> visited = new HashSet<>();
            
            for(int i=0;i<n;i++){
                int oilId = land[i][j];
                if(oilId>0 && !visited.contains(oilId)){
                    sum += map.get(oilId);
                    visited.add(oilId);
                }
            }
            answer = Math.max(answer,sum);
        }
        return answer;
    }
    private void searchOil(int x, int y, int[][] land){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        chkLand[x][y]=true;
        land[x][y]=landNum;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int dr = curr[0];
            int dc = curr[1];
            for(int d=0;d<4;d++){
                int nr = dr+dx[d];
                int nc = dc+dy[d];
                if(nr>=0 && nc>=0 && nr<n && nc<m && !chkLand[nr][nc] && land[nr][nc]==1){
                    chkLand[nr][nc]=true;
                    land[nr][nc]=landNum;
                    cnt++;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}
