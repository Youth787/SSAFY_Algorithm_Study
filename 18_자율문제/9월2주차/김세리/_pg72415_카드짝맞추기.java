import java.util.*;

class Solution {
    private final int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    private final int[] dy = {0, 0, -1, 1}; // 상하좌우 이동을 위한 배열
    private int[][] board;
    private final Map<Integer, List<int[]>> cardMap = new HashMap<>();

    // 카드 짝 맞추기
    public int solution(int[][] board, int r, int c) {
        this.board = board;

        // 1. 모든 카드 위치 찾기
        for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++) {
                if (board[i][j] > 0) {
                    int cardNum = board[i][j];
                    cardMap.computeIfAbsent(cardNum, k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        // 2. 모든 카드 번호 순서를 구하기 (순열)
        List<Integer> cardNumbers = new ArrayList<>(cardMap.keySet());

        // 3. 카드 순서에 따른 최소 이동 횟수를 구하기
        return findMinimumSteps(cardNumbers, r, c);
    }

    // 순서에 맞는 최소 경로 찾기
    private int findMinimumSteps(List<Integer> cardNumbers, int sr, int sc) {
        int minSteps = Integer.MAX_VALUE;

        // 카드 순서의 모든 경우의 수를 구하기 (순열)
        List<List<Integer>> permutations = generatePermutations(cardNumbers);

        // 모든 순열에 대해 최단 이동 횟수 계산
        for (List<Integer> perm : permutations) {
            int[][] tempBoard = new int[4][4];
            for (int i=0;i<4;i++) {
                tempBoard[i] = board[i].clone();
            }

            int totalSteps = 0;
            int[] start = {sr, sc};

            // 주어진 카드 순서대로 짝 맞추기
            for (int cardNum : perm) {
                List<int[]> cardLocations = cardMap.get(cardNum);

                // 첫 번째 카드와 두 번째 카드 중 어떤 순서로 뒤집을지 모두 고려
                int steps1 = bfs(start, cardLocations.get(0), tempBoard) + 1;
                steps1 += bfs(cardLocations.get(0), cardLocations.get(1), tempBoard) + 1;

                int steps2 = bfs(start, cardLocations.get(1), tempBoard) + 1;
                steps2 += bfs(cardLocations.get(1), cardLocations.get(0), tempBoard) + 1;

                // 다음 이동을 정확히 맞추기 위해 각 순서를 따로 고려
                totalSteps += Math.min(steps1, steps2);

                // 두 카드 모두 없앰
                tempBoard[cardLocations.get(0)[0]][cardLocations.get(0)[1]] = 0;
                tempBoard[cardLocations.get(1)[0]][cardLocations.get(1)[1]] = 0;

                // 다음 출발 지점을 정확히 관리 (카드 순서에 따라)
                start = (steps1 < steps2) ? cardLocations.get(1) : cardLocations.get(0);
            }

            minSteps = Math.min(minSteps, totalSteps);
        }

        return minSteps;
    }

    // BFS로 최단 경로 찾기
    private int bfs(int[] start, int[] target, int[][] tempBoard) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            // 타겟 위치에 도달하면 그때의 이동 횟수를 반환
            if (x==target[0] && y==target[1]) {
                return steps;
            }

            // 상하좌우 이동
            for (int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, steps + 1});
                }

                // Ctrl + 방향키로 가장 가까운 카드나 벽으로 이동
                int[] nextPos = moveCtrl(tempBoard, x, y, i);
                if (!visited[nextPos[0]][nextPos[1]]) {
                    visited[nextPos[0]][nextPos[1]] = true;
                    queue.add(new int[]{nextPos[0], nextPos[1], steps + 1});
                }
            }
        }

        return -1;  // 경로가 없을 경우 (이론상 발생하지 않음)
    }

    // 유효한 좌표인지 확인
    private boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<4 && y<4;
    }

    // Ctrl + 방향키로 가장 가까운 카드나 벽으로 이동
    private int[] moveCtrl(int[][] tempBoard, int x, int y, int dir) {
        while (isValid(x+dx[dir], y+dy[dir])) {
            x += dx[dir];
            y += dy[dir];
            if (tempBoard[x][y] != 0) {
                break;  // 카드가 있으면 멈춤
            }
        }
        return new int[]{x, y};
    }

    // 카드 순서의 모든 경우의 수(순열)를 구하기
    private List<List<Integer>> generatePermutations(List<Integer> cardNumbers) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList<>(), cardNumbers, new boolean[cardNumbers.size()]);
        return result;
    }

    private void permute(List<List<Integer>> result, List<Integer> current, List<Integer> cardNumbers, boolean[] visited) {
        if (current.size() == cardNumbers.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i=0;i<cardNumbers.size();i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(cardNumbers.get(i));
                permute(result, current, cardNumbers, visited);
                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}
