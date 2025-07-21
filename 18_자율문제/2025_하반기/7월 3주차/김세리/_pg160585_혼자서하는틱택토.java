class Solution {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;

        // O, X 개수 세기
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'O') oCount++;
                if (c == 'X') xCount++;
            }
        }

        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');

        // 규칙 위반 검사
        if (xCount > oCount) return 0;
        if (oCount - xCount > 1) return 0;
        if (oWin && oCount != xCount + 1) return 0;
        if (xWin && oCount != xCount) return 0;
        if (oWin && xWin) return 0;

        return 1;
    }

    // 승리 조건 판별 함수
    private boolean isWin(String[] board, char player) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player &&
                board[i].charAt(1) == player &&
                board[i].charAt(2) == player) return true;
        }

        // 세로
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == player &&
                board[1].charAt(j) == player &&
                board[2].charAt(j) == player) return true;
        }

        // 대각선
        if (board[0].charAt(0) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(2) == player) return true;

        if (board[0].charAt(2) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(0) == player) return true;

        return false;
    }
}
