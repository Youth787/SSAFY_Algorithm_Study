import java.util.*;

class Point{
    int x;
    int y;
    int dist;
    public Point(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist= dist;
    }
}

class Solution {
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;
    static String[] maps;
    static Point start, labber, end;

    public int solution(String[] maps) {
        int ans = 0;
        Solution.maps = maps; // maps 배열 초기화

        visit = new boolean[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if((maps[i].charAt(j))=='S')
                    start = new Point(i,j,0);
                else if(maps[i].charAt(j)=='L')
                    labber = new Point(i,j,0);
                else if(maps[i].charAt(j)=='E')
                    end = new Point(i,j,0);
            }
        }

        ans = BFS(start.x, start.y, labber.x,labber.y);
        if( ans != -1 ) {
            visit = new boolean[maps.length][maps[0].length()];
            int sec = BFS(labber.x, labber.y, end.x, end.y);
            if(sec == -1 ) return -1;
            else return ans+=sec;
        }
        return -1;
    }
    
    public int BFS(int i, int j, int ex, int ey){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i,j,0));
        visit[i][j] = true;

        while(!queue.isEmpty()){
            Point current = queue.poll();
            if(current.x==ex && current.y == ey) return current.dist;
            
            for(int k=0; k<4; k++){
                int r = current.x+dir[k][0];
                int c = current.y+dir[k][1];
                if(r<0|| r>=maps.length || c<0 || c>= maps[0].length() || visit[r][c]) continue;
                if(maps[r].charAt(c)!='X'){
                    queue.add(new Point(r,c,current.dist+1));
                    visit[r][c] = true;
                }
            }
        }// while end
        return -1;
    }// BFS method end
}