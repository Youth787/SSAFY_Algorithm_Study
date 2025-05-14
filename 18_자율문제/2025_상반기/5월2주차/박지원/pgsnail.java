//프로그래머스 삼각달팽이 자바
//삼각형을 맨왼쪽으로 밀고, 없는부분은 걍 0으로 냅두면 되는 문제
//아이디어 생각이 어려웠따...

import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] map = new int[n][n];
        
        int x = -1;
        int y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                map[x][y] = num++;
            }
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) break;
                answer[k++] = map[i][j];
            }
        }
        return answer;
    }
}
