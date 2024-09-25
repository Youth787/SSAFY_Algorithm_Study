import java.util.*;

class Solution {
    static boolean[][] map; // 2배 확장된 맵
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1. 맵 크기 2배로 확장 (정확한 테두리 계산을 위해)
        map = new boolean[101][101]; // 2배 크기의 맵 (좌표 50x50 -> 100x100)

        // 2. 직사각형을 맵에 그리기
        drawMap(rectangle);

        // 3. BFS로 최단 경로 찾기
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2); // 좌표 2배로 변환
    }

    private void drawMap(int[][] rectangle) {
        // 직사각형 그리기 (테두리만 표시)
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            // 직사각형의 테두리만 그리기
            for (int i=x1;i<=x2;i++) {
                map[i][y1] = true; // 아래 테두리
                map[i][y2] = true; // 위 테두리
            }
            for (int i=y1;i<=y2;i++) {
                map[x1][i] = true; // 왼쪽 테두리
                map[x2][i] = true; // 오른쪽 테두리
            }
        }

        // 직사각형 내부는 false로 설정 (지나가지 못하도록)
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i=x1+1;i<x2;i++) {
                for (int j=y1+1;j<y2;j++) {
                    map[i][j] = false; // 내부는 지나갈 수 없음
                }
            }
        }
    }

    private int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101]; // 방문 여부 체크
        queue.add(new int[]{startX, startY, 0}); // (x좌표, y좌표, 거리)
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int dist = curr[2];

            // 아이템에 도착하면 종료
            if (currX == endX && currY == endY) {
                return dist/2; // 실제 거리로 반환 (2배 확장한 맵이므로 2로 나눔)
            }

            // 상하좌우 탐색
            for (int i=0;i<4;i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if (nx>=0 && ny>=0 && nx<=100 && ny<=100 && map[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist+1});
                }
            }
        }
        return -1; // 도달할 수 없을 경우 (예외적으로 발생할 수 있음)
    }
}
