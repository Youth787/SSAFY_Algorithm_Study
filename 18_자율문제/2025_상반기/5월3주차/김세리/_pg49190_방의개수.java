import java.util.*;

class Solution {
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    public int solution(int[] arrows) {
        // 시작점(원점)
        int x=0,y=0;
        // 방문한 점 저장
        Set<String> visitedPoints = new HashSet<>();
        // 방문한 선 저장
        Set<String> visitedEdges = new HashSet<>();
        int roomCnt=0;
        // 초기점 방문 추가
        visitedPoints.add(x+","+y);
        
        for(int dir : arrows){
            // 대각선 이동 시 교차점 처리를 위해 같은 방향으로 두번씩 이동
            // 어차피 공간의 크기가 아니라 개수를 세는 것이라서 답에는 영향없음
            for(int step=0;step<2;step++){
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                
                String currentPoint = x+","+y;
                String nextPoint = nx+","+ny;
                String edge = currentPoint+"->"+nextPoint;
                String reverseEdge = nextPoint+"->"+currentPoint;
                // 방문한 점이고 방문한 선분은 아닐 때 새로운 공간이 생김
                if(visitedPoints.contains(nextPoint) && !visitedEdges.contains(edge)){
                    roomCnt++;
                }
                visitedPoints.add(nextPoint);
                visitedEdges.add(edge);
                visitedEdges.add(reverseEdge);
                x=nx;
                y=ny;
            }
        }
        
        return roomCnt;
    }
}
