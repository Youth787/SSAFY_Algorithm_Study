//프로그래머스 혼자서 하는 틱택토 자바
//구현문제같음

import java.util.*;

class Solution {
    private static char[][] map;
    private static int r, c, answer, cntO, cntX;
    public int solution(String[] board) {
        r = board.length;
        c = board[0].length();
        map = new char[r][c];
        cntO = 0;
        cntX = 0;
        for (int i = 0; i < r; i++) {
            String temp = board[i];
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'O') cntO++;
                else if (map[i][j] == 'X') cntX++;
            }
        }
        if (cntO == 0 && cntX == 0) return 1;
        if (cntX > cntO) return 0;
        if (Math.abs(cntO - cntX) >= 2) {
            return 0;
        }
        answer = checkBingo();
        
        return answer;
    }
    private static int checkBingo() {
        //가로, 세로
        boolean flag = false;
        for (int i = 0; i < r; i++) {
            if (map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                if (map[1][i] == 'X') {
                    if (cntX < cntO) return 0;
                    flag = true;
                }
                if (map[1][i] == 'O') {
                    if (flag) return 0;
                    else if (cntX == cntO) return 0;
                }
            }
            if (map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                if (map[i][1] == 'X') {
                    if (cntX < cntO) return 0;
                    flag = true;
                }
                if (map[i][1] == 'O') {
                    if (flag) return 0;
                    else if (cntX == cntO) return 0;
                }
            }
        }
        //대각선
        if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
            if (map[1][1] == 'O' && cntX == cntO) return 0;
            if (map[1][1] == 'X' && cntX < cntO) return 0;
        }
        if (map[2][0] == map[1][1] && map[1][1] == map[0][2]) {
            if (map[1][1] == 'O' && cntX == cntO) return 0;
            if (map[1][1] == 'X' && cntX < cntO) return 0;
        }
        return 1;
    }
}

//o.x갯수 확인
// 만약 둘 차이가 2 이상 나거나, o가 0개 x가 1개면 0반환. / 0, 0개면 1 반환
// 아니라면 빙고 확인 (가로, 세로, 대각선)
// 빙고 없으면 통과~
