import java.util.*;
import java.io.*;

class Solution {
    static boolean[][] visited;
    static int x,y;
    public int solution(String dirs) {
        int N = dirs.length();
        visited = new boolean[21][21];
        
        int answer = 0;
        x=10; y=10;
        
        for(char dir: dirs.toCharArray()){
            int nx=x, ny=y;
            if(dir=='U') nx -=2;
            else if(dir=='D') nx +=2;
            else if(dir=='L') ny -=2;
            else if(dir=='R') ny +=2;
            
            if(nx<0 || nx>20 || ny<0 || ny>20) continue;
            
            int mx = (x + nx) / 2;
            int my = (y + ny) / 2;
            // 선분(중간지점) 방문 여부 체크
            if(!visited[mx][my]) {
                visited[mx][my] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}
