//너무 어려워서 해설을 참고하고 해석함 담주에 다시푼다.

class Solution {
    // 0. 사방탐색 배열, 방문배열, 초기 발판 상태 배열 -> 5개가 최대니까 바로 선언해줬습니다. + 행과 열 
    int [][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    boolean [][] vis = new boolean  [5][5];
    int     [][] block = new int    [5][5];
    int r,c;


    public int solution(int[][] board, int[] aloc, int[] bloc) {
        r = board.length; c = board[0].length;
        // 1. 초기 발판 상태 입력 받기
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                block[i][j] = board[i][j];
            }
        }

        return minMax(aloc[0], aloc[1], bloc[0], bloc[1]);

    }
    // 2. 문제용 재귀함수
    public int minMax (int curY, int curX, int opY, int opX) {
        // 반환값
        int ret = 0;
        // (1) 만약 현재 밟고 있는 발판이 사라졌으면 게임 끝이니까 바로 반환
        if(vis[curY][curX]) return 0; 
        // (2) 사방탐색
        for(int i = 0; i < 4; i++){
            int ny = curY + dir[i][0];
            int nx = curX + dir[i][1];
            // 범위를 넘어가거나, 이미 방문했거나 벽인 경우 continue
            if(OOB(ny,nx) || vis[ny][nx] || block[ny][nx] == 0) continue; 
            // 현재 밟고 있는 발판을 허공으로 바꾸고, 재귀
            vis[curY][curX] = true; 
            // 현재 turn에서 가능한 경우의 수 중 하나로 가보는 것 
            int pos = minMax(opY,opX,ny,nx) + 1; 
            // 해당 분기 탐색 마치면 현 발판은 원래 상태로 고르기
            vis[curY][curX] = false; 

            // ret은 이제까지 모든 분기의 결과값 중 최적의 해
            // val은 현재의 해 입니다.

            // 현재까지 모든 분기가 패배였는데, 현 분기가 승리인 경우, 승리 분기 선택
            if(ret%2 == 0 && pos%2 == 1) ret = pos;
            // 현재까지 모든 분기가 패배였는데, 현 분기도 패배인 경우, 가장 turn 수 긴 거 선택
            else if(ret%2 == 0 && pos%2 == 0) ret = Math.max(ret,pos);
            // 현재까지 모든 분기가 승리였는데, 현 분기도 승리인 경우, 가장 turn 수 짧은 것 선택
            else if(ret%2 == 1 && pos%2 == 1) ret = Math.min(ret,pos); 
        }
        return ret; 
    }

    // Out of Bound 잡이
    public boolean OOB (int nowY, int nowX){
        return (nowY < 0 || nowX < 0 || nowY >=r || nowX >= c);
    }
}
