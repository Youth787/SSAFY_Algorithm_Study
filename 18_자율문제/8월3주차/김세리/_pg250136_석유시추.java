import java.util.*;

class Pair{
    private final int x;
    private final int y;
    
    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
    // x좌표, y좌표 반환
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}

class Solution {
    
    private static final int NOTHING=0;
    private int[] dx = {-1,0,1,0};
    private int[] dy = {0,1,0,-1};
    
    public int solution(int[][] land) {
        int answer = NOTHING;
        int rowLen = land.length;
        int colLen = land[0].length;
        int[][] area = new int[rowLen][colLen];
        int areaNumber=1;
        // 각 덩어리 고유 번호번호, 덩어리의 석유량 저장
        Map<Integer,Integer> oilMap = new HashMap<>();
        
        // 석유 덩어리 식별 및 각 덩어리의 석유량 기록
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(land[i][j]==NOTHING || area[i][j]!=NOTHING){
                    continue;
                }
                // 아직 방문하지 않은 석유있는 셀 발견시 bfs로 해당 덩어리의 석유량 계산하여 저장
                int oilAccount = bfs(land, area, i, j, areaNumber);
                oilMap.putIfAbsent(areaNumber++, oilAccount);
            }
        }
        // 이미 방문한 덩어리 체크
        boolean[] visited = new boolean[areaNumber];
        
        // 각 열에 대해 가능한 최대 석유량 계산
        for(int c=0;c<colLen;c++){
            int oilSum =0;
            for(int r=0;r<rowLen;r++){
                if(area[r][c]==0){
                    continue;
                }
                if(visited[area[r][c]]){
                    continue;
                }
                visited[area[r][c]]=true;
                oilSum += oilMap.get(area[r][c]);
            }
            answer = Math.max(answer,oilSum);
            // 방문여부 초기화
            Arrays.fill(visited, false);
        }
        return answer;
    }
    
    private int bfs(int[][] land, int[][] area, int row, int col, int areaNumber){
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(row, col));
        area[row][col] = areaNumber;
        int value = land[row][col];
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.getX();
            int y = p.getY();
            
            for(int dir=0;dir<4;dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(nx<0 || ny<0 || nx>=area.length || ny>=area[0].length){
                    continue;
                }
                if(land[nx][ny]==NOTHING || area[nx][ny]!=NOTHING){
                    continue;
                }
                area[nx][ny] = areaNumber;
                // value = 덩어리의 석유량
                value += land[nx][ny];
                q.offer(new Pair(nx,ny));
            }
        }
        return value;
    }
}
