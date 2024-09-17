// 다시풀기 

import java.util.*;

class Solution {
    
    // 방향: 상, 하, 좌, 우
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    // BFS로 두 지점 간의 최단 거리 계산
    private int bfs(int[][] board, int sr, int sc, int er, int ec) {
        boolean[][] visit = new boolean[4][4];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr, sc, 0});
        visit[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            if (r == er && c == ec) {
                return dist;
            }

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 1칸 이동
                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.offer(new int[] {nr, nc, dist + 1});
                }

                // Ctrl+방향 이동
                while (nr + dr[i] >= 0 && nr + dr[i] < 4 && nc + dc[i] >= 0 && nc + dc[i] < 4 && board[nr][nc] == 0) {
                    nr += dr[i];
                    nc += dc[i];
                }

                if (!visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.offer(new int[] {nr, nc, dist + 1});
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    // 카드 위치 찾기
    private Map<Integer, List<int[]>> cardPos(int[][] board) {
        Map<Integer, List<int[]>> pos = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] > 0) {
                    pos.computeIfAbsent(board[i][j], k -> new ArrayList<>()).add(new int[] {i, j});
                }
            }
        }
        return pos;
    }

    public int solution(int[][] board, int r, int c) {
        Map<Integer, List<int[]>> pos = cardPos(board);
        List<Integer> cards = new ArrayList<>(pos.keySet());
        int minMoves = Integer.MAX_VALUE;

        // 카드 순서 탐색
        for (List<Integer> order : perms(cards)) {
            int total = 0;
            int[] cur = {r, c};
            int[][] temp = new int[4][4];
            for (int i = 0; i < 4; i++) {
                temp[i] = board[i].clone();
            }

            // 각 카드 쌍을 순서대로 제거
            for (int card : order) {
                List<int[]> p = pos.get(card);
                int[] p1 = p.get(0), p2 = p.get(1);
                
                // 두 경로 중 짧은 것 선택
                int m1 = bfs(temp, cur[0], cur[1], p1[0], p1[1]) + bfs(temp, p1[0], p1[1], p2[0], p2[1]) + 2;
                int m2 = bfs(temp, cur[0], cur[1], p2[0], p2[1]) + bfs(temp, p2[0], p2[1], p1[0], p1[1]) + 2;
                
                if (m1 < m2) {
                    total += m1;
                    cur = p2;
                } else {
                    total += m2;
                    cur = p1;
                }

                // 카드 제거
                temp[p1[0]][p1[1]] = 0;
                temp[p2[0]][p2[1]] = 0;
            }

            minMoves = Math.min(minMoves, total);
        }

        return minMoves;
    }

    // 카드 순서의 모든 순열 생성
    private List<List<Integer>> perms(List<Integer> cards) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), cards);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, List<Integer> cards) {
        if (temp.size() == cards.size()) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < cards.size(); i++) {
                if (temp.contains(cards.get(i))) continue;
                temp.add(cards.get(i));
                backtrack(res, temp, cards);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
