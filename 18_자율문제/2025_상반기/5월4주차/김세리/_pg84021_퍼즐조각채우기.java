import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> emptyPieces = findShapes(game_board, 0);
        List<List<int[]>> puzzles = findShapes(table, 1);
        boolean[] used = new boolean[puzzles.size()];
        int answer = 0;

        for (List<int[]> emptyPiece : emptyPieces) {
            for (int i = 0; i < puzzles.size(); i++) {
                if (!used[i]) {
                    List<int[]> puzzle = puzzles.get(i);
                    if (canFit(emptyPiece, puzzle)) {
                        used[i] = true;
                        answer += countBlocks(puzzle);
                        break;
                    }
                }
            }
        }
        return answer;
    }

    static List<List<int[]>> findShapes(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == target) {
                    List<int[]> shape = new ArrayList<>();
                    dfs(visited, i, j, target, board, shape);
                    shapes.add(normalize(shape));
                }
            }
        }
        return shapes;
    }

    static void dfs(boolean[][] visited, int x, int y, int target, int[][] board, List<int[]> shape) {
        int n = visited.length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        visited[x][y] = true;
        shape.add(new int[]{x, y});
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && board[nx][ny] == target) {
                dfs(visited, nx, ny, target, board, shape);
            }
        }
    }

    static List<int[]> normalize(List<int[]> shape) {
        // (0,0) 기준으로 이동 & 정렬
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] p : shape) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        List<int[]> res = new ArrayList<>();
        for (int[] p : shape) {
            res.add(new int[]{p[0] - minX, p[1] - minY});
        }
        res.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return res;
    }

    static boolean canFit(List<int[]> emptyPiece, List<int[]> puzzle) {
        for (int r = 0; r < 4; r++) {
            puzzle = rotate(puzzle);
            if (match(emptyPiece, puzzle)) {
                return true;
            }
        }
        return false;
    }

    static List<int[]> rotate(List<int[]> puzzle) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : puzzle) {
            rotated.add(new int[]{p[1], -p[0]});
        }
        return normalize(rotated);
    }

    static boolean match(List<int[]> emptyPiece, List<int[]> puzzle) {
        if (emptyPiece.size() != puzzle.size()) return false;
        for (int i = 0; i < emptyPiece.size(); i++) {
            if (emptyPiece.get(i)[0] != puzzle.get(i)[0] || emptyPiece.get(i)[1] != puzzle.get(i)[1]) {
                return false;
            }
        }
        return true;
    }

    static int countBlocks(List<int[]> puzzle) {
        return puzzle.size();
    }
}
