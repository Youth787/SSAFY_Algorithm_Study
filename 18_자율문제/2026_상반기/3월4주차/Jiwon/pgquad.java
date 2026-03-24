import java.util.*;

class Solution {
    static int[] answer;
    static boolean[][] visited;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        visited = new boolean[arr.length][arr.length];
        boolean flag = true;
        a: for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != arr[0][0]) {
                    flag = false;
                    break a;
                }
            }
        }
        if (flag) {
            if (arr[0][0] == 1) answer[1] = 1;
            else answer[0] = 1;
            return answer;
        } 
        dfs(arr, 0, 0, arr.length);
        
        return answer;
    }
    static void dfs (int[][] arr, int x, int y, int len) {
        if (len < 2) {
            if (arr[x][y] == 1) answer[1]++;
            else answer[0]++;
            return;
        }
        check(arr, x, y, len);
        check(arr, x + len/2, y, len);
        check(arr, x, y + len/2, len);
        check(arr, x + len/2, y + len/2, len);
        if (!visited[x][y]) dfs(arr, x, y, len / 2);
        if (!visited[x + len/2][y]) dfs(arr, x + len/2, y, len / 2);
        if (!visited[x][y + len/2]) dfs(arr, x, y + len/2, len/2);
        if (!visited[x + len/2][y + len/2]) dfs(arr, x + len/2, y + len/2, len/2);
    }
    static void check(int[][] arr, int x, int y, int len) {
        boolean flag = true;
        a: for (int i = x; i < x + len / 2; i++) {
            for (int j = y; j < y + len / 2; j++) {
                if (arr[x][y] != arr[i][j]) {
                    flag = false;
                    break a;
                }
            }
        }
        if (flag) {
            visited[x][y] = true;
            if (arr[x][y] == 1) answer[1]++;
            else answer[0]++;
        }
    }
    
}
