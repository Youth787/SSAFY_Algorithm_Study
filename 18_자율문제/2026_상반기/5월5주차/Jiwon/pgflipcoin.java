//다시풀기

import java.util.*;

class Solution {
    public static int answer, n, m;
    public int[][] b, t;
    
    public int solution(int[][] beginning, int[][] target) {
        answer = Integer.MAX_VALUE;
        n = beginning.length;
        m = beginning[0].length;
        b = new int[n][m];
        t = new int[n][m];
        for (int i = 0; i < n; i++) {
            b[i] = beginning[i].clone();
            t[i] = target[i].clone();
        }
        dfs(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public void flip_row(int r){
        for (int i = 0; i < m; i++) {
            b[r][i] = (b[r][i] + 1) % 2;
        }
    }
    
    public int compare_col (int c) {
        int check = 0;
        for (int i = 0; i < n; i++){
            if (t[i][c] == b[i][c]){
                check++; 
            } 
        }
        
        if (check == n) return 0; //전부 일치
        else if (check == 0) return 1; //전부 불일치
        else return -1;
    }
    
    public void dfs (int r, int cnt) {
        //모든 행의 경우의 수를 확인했다면
        if (r == n){
            boolean flag = true;
            for (int i = 0; i < m; i++) {
                int result = compare_col(i);
                if (result == -1){
                    flag = false;
                    break;
                }
                cnt += result; //전부 반대일 경우 +1
            }
            
            if (flag) {
                answer = Math.min(answer, cnt);   
            }
            return;
        }
        
        flip_row(r); //행 뒤집기
        dfs(r + 1, cnt + 1); //행을 뒤집는 경우
        flip_row(r); //다시 원상태로
        
        dfs(r + 1, cnt); //행을 뒤집지 않는 경우
    }
}
