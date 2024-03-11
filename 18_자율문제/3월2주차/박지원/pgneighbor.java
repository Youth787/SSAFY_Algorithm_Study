//PCCE 기출문제 9번 이웃한 칸
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int x = board.length;
        int y = board[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int mx = h + dx[i];
            int my = w + dy[i];
            if (mx >= 0 && my >= 0 && mx < x && my < y && board[h][w].equals(board[mx][my])) answer++;
        }
        return answer;
    }
}
