import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        List<int[][]> emptySpaces = findShapes(game_board, 0); // 게임 보드의 빈 공간 찾기
        List<int[][]> puzzlePieces = findShapes(table, 1); // 테이블의 퍼즐 조각 찾기
        
        boolean[] used = new boolean[puzzlePieces.size()]; // 퍼즐 조각 사용 여부 체크
        int answer = 0;
        
        for (int[][] emptySpace : emptySpaces) {
            for (int i=0;i<puzzlePieces.size(); i++) {
                if (!used[i]) { // 사용되지 않은 퍼즐 조각인 경우
                    int[][] piece = puzzlePieces.get(i);
                    if (canFit(emptySpace, piece)) { // 빈 공간에 퍼즐 조각이 맞는지 확인
                        used[i] = true;
                        answer += countBlocks(piece); // 채워진 퍼즐 조각 수 추가
                        break;
                    }
                }
            }
        }
        
        return answer;
    }

    // 특정 값으로 이루어진 모양을 찾는 함수
    private List<int[][]> findShapes(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<int[][]> shapes = new ArrayList<>();
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (board[i][j] == target && !visited[i][j]) {
                    List<int[]> shape = new ArrayList<>();
                    dfs(board, visited, i, j, shape, target);
                    shapes.add(normalize(shape));
                }
            }
        }
        
        return shapes;
    }

    // DFS를 통해 연결된 모양 찾기
    private void dfs(int[][] board, boolean[][] visited, int x, int y, List<int[]> shape, int target) {
        int n = board.length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        visited[x][y] = true;
        shape.add(new int[]{x, y});
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && board[nx][ny]==target) {
                dfs(board, visited, nx, ny, shape, target);
            }
        }
    }

    // 모양을 좌상단 기준으로 정렬
    private int[][] normalize(List<int[]> shape) {
        Collections.sort(shape, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int minX = shape.get(0)[0];
        int minY = shape.get(0)[1];
        
        int[][] normalized = new int[shape.size()][2];
        for (int i=0;i<shape.size();i++) {
            normalized[i][0] = shape.get(i)[0] - minX;
            normalized[i][1] = shape.get(i)[1] - minY;
        }
        
        return normalized;
    }

    // 퍼즐 조각이 빈 공간에 맞는지 확인
    private boolean canFit(int[][] emptySpace, int[][] piece) {
        for (int r=0;r<4;r++) { // 90도씩 회전하며 확인
            piece = rotate(piece);
            if (match(emptySpace, piece)) {
                return true;
            }
        }
        return false;
    }

    // 90도 회전
    private int[][] rotate(int[][] piece) {
        int n = piece.length;
        int[][] rotated = new int[n][2];
        
        for (int i=0;i<n;i++) {
            rotated[i][0] = piece[i][1];
            rotated[i][1] = -piece[i][0];
        }
        
        return normalize(rotated);
    }

    // 빈 공간과 퍼즐 조각이 일치하는지 확인
    private boolean match(int[][] emptySpace, int[][] piece) {
        if (emptySpace.length != piece.length) return false;
        
        for (int i=0;i<emptySpace.length;i++) {
            if (emptySpace[i][0] != piece[i][0] || emptySpace[i][1] != piece[i][1]) {
                return false;
            }
        }
        
        return true;
    }

    // 퍼즐 조각의 블록 수 계산
    private int countBlocks(int[][] piece) {
        return piece.length;
    }
}
