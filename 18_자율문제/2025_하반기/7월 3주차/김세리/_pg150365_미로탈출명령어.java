import java.util.*;
import java.io.*;

class Solution {
    static PriorityQueue<String> q=new PriorityQueue<>();
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static String[] letter = {"d","l","r","u"};
    static int[][] map;
    static boolean found = false;
    static String answer;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";
        map = new int[n][m];
        map[x-1][y-1] = -1;
        map[r-1][c-1] = 1;
        move(x-1,y-1,0,"",n,m,k,r-1,c-1);
        if(answer=="") return "impossible";
        return answer;
    }
    static void move(int x,int y,int cnt,String path,int n,int m,int k,int endX, int endY){
        if(found) return;
        
        int dist = Math.abs(x-endX)+Math.abs(y-endY);
        int remain = k-cnt;
        // 남은 거리가 남은 횟수보다 크면 무조건 불가능
        if(dist>remain) return;
        // 남은 거리가 남은 횟수보다 작거나 같을 때도
        // 그거 빼고 나머지가 홀수면 무조건 불가능
        else if((dist-remain)%2 !=0) return;
        if(cnt==k){
            if(map[x][y]==1){
                answer=path;
                found=true;
            }
            return;
        }

        for(int d=0;d<4;d++){
            int nr = x+dx[d];
            int nc = y+dy[d];
            if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
            
            move(nr,nc,cnt+1,path+letter[d],n,m,k,endX,endY);
            
        }

    }
}
