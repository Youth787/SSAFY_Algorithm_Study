import java.util.*;
import java.io.*;

class Solution {
    static int N,M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static char[][] newMap;
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        newMap = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            newMap[i] = maps[i].toCharArray();
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && newMap[i][j]!='X'){
                    answer.add(bfs(i,j));
                }
            }
        }
        if(answer.isEmpty()) return new int[]{-1};
        
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    static int bfs(int x,int y){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int total = newMap[x][y]-'0';
        visited[x][y]=true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int d=0;d<4;d++){
                int nr = curr[0]+dx[d];
                int nc = curr[1]+dy[d];
                
                if(nr<0 || nc<0 || nr>=N || nc>=M || newMap[nr][nc]=='X' || visited[nr][nc]) continue;
                q.add(new int[]{nr,nc});
                total += newMap[nr][nc]-'0';
                visited[nr][nc]=true;
            }
        }
        return total;
    }
}
