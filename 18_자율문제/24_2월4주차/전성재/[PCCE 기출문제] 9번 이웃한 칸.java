class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            int newX = h + dx[i];
            int newY = w + dy[i];
            
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                if (board[newX][newY].equals(board[h][w])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
