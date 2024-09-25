//프로그래머스 퍼즐 조각 채우기 자바
//BFS, ROTATE, 등등 까다로운 문제.. LV3문제는 나에게 너무 산같다

import java.util.*;


class Solution {
    public static class Point implements Comparable<Point> {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<ArrayList<Point>> empty = new ArrayList<>();
    static ArrayList<ArrayList<Point>> block = new ArrayList<>();
    static boolean[][] visited;
    static int boardSize;
    public int solution(int[][] game_board, int[][] table) {
        boardSize = game_board.length;
        visited = new boolean[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    empty.add(check(game_board, i, j, 0));
                }
            }
        }
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (table[i][j] == 1 && !visited[i][j]) 
                    block.add(check(table, i, j, 1));
            }
        }
        boolean[] visitedBoard = new boolean[empty.size()];
        int answer = 0;
        
        for (int i = 0; i < block.size(); i++) {
            ArrayList<Point> blockCheck = block.get(i);
            for (int j = 0; j < empty.size(); j++) {
                ArrayList<Point> emptyCheck = empty.get(j);
            if (emptyCheck.size() == blockCheck.size() && !visitedBoard[j]) {
                if (isRotate(emptyCheck, blockCheck)) {
                    answer += blockCheck.size();
                    visitedBoard[j] = true;
                    break;
                }
            }
            }
        }
        return answer;
    }
    public static ArrayList<Point> check(int[][] board, int x, int y, int type) {
        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> result = new ArrayList<>();
        
        q.add(new Point(x, y));
        visited[x][y] = true;
        result.add(new Point(0, 0));
        
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < boardSize && ny < boardSize) {
                    if (!visited[nx][ny] && board[nx][ny] == type) {
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        
                        result.add(new Point(nx - x, ny - y));
                    }                
                }
            }
        }
        Collections.sort(result);
        return result;
    }
    public static boolean isRotate(ArrayList<Point> empty, ArrayList<Point> block) {
        for (int i = 0; i < 4; i++) {
            int zeroX = block.get(0).x;
            int zeroY = block.get(0).y;
            
            for (int j = 0; j < block.size(); j++) {
                block.get(j).x -= zeroX;
                block.get(j).y -= zeroY;
            }
            boolean isCollect = true;
            for (int j = 0; j < empty.size(); j++) {
                Point emptyPoint = empty.get(j);
                Point blockPoint = block.get(j);
                
                if (emptyPoint.x != blockPoint.x || emptyPoint.y != blockPoint.y) {
                    isCollect = false;
                    break;
                }
            
            }
            if (isCollect) return true;
            else {
                for (int j = 0; j < block.size(); j++) {
                    int temp = block.get(j).x;
                    block.get(j).x = block.get(j).y;
                    block.get(j).y = -temp;
                }
                Collections.sort(block);
            }
        }
        return false;
    }
}
