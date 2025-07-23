class Solution {
    int answer = 0;
    public int solution(int n) {
        int[] queens = new int[n];
        backtrack(0, n, queens);
        return answer;
    }

    private void backtrack(int row, int n, int[] queens) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, queens)) {
                queens[row] = col; // row 행에 col 열에 퀸 배치
                backtrack(row + 1, n, queens);
                // 퀸 위치 복원은 안 해도 됨 (덮어쓰기)
            }
        }
    }

    private boolean isValid(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }
}
