//프로그래머스 카드 짝 맞추기 레벨3 자바 
//BFS + 순열 + 시뮬레이션
//https://loosie.tistory.com/170

import java.util.*;

class Solution {
    private static class Point {
        int x, y, move;
        public Point(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static List<String> orders;
    public int solution(int[][] board, int r, int c) {
        int cardNum = 0;
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(board[i][j] != 0) {
                    cardNum ++;
                }
            }	
        }
        cardNum /=2;

        int[] card = new int[cardNum];
        for(int i = 0; i < cardNum; i++) {
            card[i] = i + 1;
        }
        //카드 조합 순서 경우의 수 구하기(123, 132, 231 ...)
        orders = new ArrayList<>();
        permutation("", 0, card);
        
        int min = Integer.MAX_VALUE;
        for (String comb: orders) {
            String[] order = comb.split("");
            int total_move = 0;
            int[] pos = new int[2];
            pos[0] = r;
            pos[1] = c;
            
            int[][] map = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    map[i][j] = board[i][j];
                }
            }
            
            for (String target_card: order) {
                int card_num = Integer.parseInt(target_card);
                
                //첫 카드 찾기
                total_move += cardSearch(pos, card_num, map);
                map[pos[0]][pos[1]] = 0;
                
                total_move++;
                
                //두번째 카드 찾기
                total_move += cardSearch(pos, card_num, map);
                map[pos[0]][pos[1]] = 0;
                
                total_move++;
            }
            min = Math.min(min, total_move);
        }
        return min;
    }
    private static void permutation(String comb, int depth, int[] card) {
        if (card.length == depth) {
            orders.add(comb);
            return;
        }
        for (int i = 0; i < card.length; i++) {
            int num = card[i];
            if (!comb.contains("" + num)) {
                permutation(comb + num, depth + 1, card);
            }
        }

    }
    private static int cardSearch(int[] pos, int target_card, int[][] map) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        int x = pos[0];
        int y = pos[1];
        
        visited[x][y] = true;
        q.add(new Point(x, y, 0));
        while (!q.isEmpty()) {
            Point next = q.poll();
            if (map[next.x][next.y] == target_card) {
                pos[0] = next.x;
                pos[1] = next.y;
                return next.move;
            }
            
            //상하좌우1칸 이동
            for (int i = 0; i < 4; i++) {
                int mx = next.x + dx[i];
                int my = next.y + dy[i];
                if (mx < 0 || my < 0 || mx >= 4 || my >= 4 || visited[mx][my]) continue;
                visited[mx][my] = true;
                q.add(new Point(mx, my, next.move + 1));
                
            }
            
            //ctrl+방향키 이동
            for (int i = 0; i < 4; i++) {
                Point res = checkRoute(next.x, next.y, i, map);
                if (res.x == x && res.y == y) continue;
                if (visited[res.x][res.y]) continue;
                visited[res.x][res.y] = true;
                q.add(new Point(res.x, res.y, next.move + 1));
            }
        }
        return 0;
    }
    //컨트롤 이동 시 해당 경로에 카드있나요? 없으면 끝까지 이동하기
    private static Point checkRoute(int x, int y, int direction, int[][] map) {
        x += dx[direction];
        y += dy[direction];
        while (x >= 0 && x < 4 && y >= 0 && y < 4) {
            if (map[x][y] != 0) return new Point(x, y, 0);
            x += dx[direction];
            y += dy[direction];
        }
        //카드 없으면 끝
        return new Point(x - dx[direction], y - dy[direction], 0);
    }
}
