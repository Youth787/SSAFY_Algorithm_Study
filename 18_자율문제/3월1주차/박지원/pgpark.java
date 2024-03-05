import java.util.*;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
//프로그래머스 공원산책
class Solution {
    static int n, m;
    static char[][] map;
    static Node start;
    public int[] solution(String[] park, String[] routes) {
        n = park.length;
        m = park[0].length();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    start = new Node(i, j);
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            char direction = routes[i].charAt(0);
            int count = routes[i].charAt(2) - '0';
            moving(direction, count);
        }
        int[] answer = {start.x, start.y};
        return answer;
    }
    static void moving(char direction, int count) {
        if (direction == 'E') {
            boolean flag = true;
            for (int i = 1; i <= count; i++) {
                if (start.y + i >= m) {
                    flag = false;
                    break;
                }
                if (map[start.x][start.y + i] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) start.y += count;
        } else if (direction == 'W') {
            boolean flag = true;
            for (int i = 1; i <= count; i++) {
                if (start.y - i < 0) {
                    flag = false;
                    break;
                }
                if (map[start.x][start.y - i] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) start.y -= count;
        } else if (direction == 'N') {
            boolean flag = true;
            for (int i = 1; i <= count; i++) {
                if (start.x -  i < 0) {
                    flag = false;
                    break;
                }
                if (map[start.x - i][start.y] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) start.x -= count;
        } else if (direction == 'S') {
            boolean flag = true;
            for (int i = 1; i <= count; i++) {
                if (start.x + i >= n) {
                    flag = false;
                    break;
                }
                if (map[start.x + i][start.y] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) start.x += count;
        }
    }
}
