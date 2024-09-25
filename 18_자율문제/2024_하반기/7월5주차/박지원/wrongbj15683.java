//백준 감시 다틀린 코드

import java.io.*;
import java.util.*;

public class Main{
    private static int n, m;
    private static int[][] map;
    private static boolean[][] checked;
    private static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        checked = new boolean[n][m];
        ArrayList<Node> five = new ArrayList<>();
        ArrayList<Node> four = new ArrayList<>();
        ArrayList<Node> three = new ArrayList<>();
        ArrayList<Node> two = new ArrayList<>();
        ArrayList<Node> one = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) checked[i][j] = true; // 씨씨티비와 벽은 true처리
                if (map[i][j] == 5) five.add(new Node(i, j));
                else if (map[i][j] == 4) four.add(new Node(i, j));
                else if (map[i][j] == 3) three.add(new Node(i, j));
                else if (map[i][j] == 2) two.add(new Node(i, j));
                else if (map[i][j] == 1) one.add(new Node(i, j));
            }
        }
        for (Node n: five) {
            five(n.x, n.y);
        }
        for (Node n: four) {
            four(n.x, n.y);
        }
        for (Node n: three) {
            three(n.x, n.y);
        }
        for (Node n: two) {
            two(n.x, n.y);
        }
        for (Node n: one) {
            one(n.x, n.y);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(checked[i][j]);
            }
            System.out.println();
        }
        System.out.println(countFalse(checked));


    }
    private static void five(int x, int y) {
        upside(x, y);
        leftside(x, y);
        rightside(x, y);
        downside(x, y);
    }
    private static int upside(int x, int y, boolean[][] visited) {
        int count = 0;
        for (int i = x - 1; i >= 0; i--) {
            if(map[i][y] == 6) break;
            if (visited[i][y]) continue;
            visited[i][y] = true;
            count++;
        }
        return count;
    }
    private static int downside(int x, int y, boolean[][] visited) {
        int count = 0;
        for (int i = x + 1; i < n; i++) {
            if(map[i][y] == 6) break;
            if (visited[i][y]) continue;
            visited[i][y] = true;
            count++;
        }
        return count;
    }
    private static int leftside(int x, int y, boolean[][] visited) {
        int count = 0;
        for (int i = y - 1; i >= 0; i--) {
            if(map[x][i] == 6) break;
            if (visited[x][i]) continue;
            visited[x][i] = true;
            count++;
        }
        return count;
    }
    private static int rightside(int x, int y, boolean[][] visited) {
        int count = 0;
        for (int i = y + 1; i < m; i++) {
            if(map[x][i] == 6) break;
            if (visited[x][i]) continue;
            visited[x][i] = true;
            count++;
        }
        return count;
    }
    private static void upside(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if(map[i][y] == 6) break;
            checked[i][y] = true;
        }
    }
    private static void downside(int x, int y) {
        for (int i = x + 1; i < n; i++) {
            if(map[i][y] == 6) break;
            checked[i][y] = true;
        }
    }
    private static void leftside(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if(map[x][i] == 6) break;
            checked[x][i] = true;
        }
    }
    private static void rightside(int x, int y) {
        for (int i = y + 1; i < m; i++) {
            if(map[x][i] == 6) break;
            checked[x][i] = true;
        }
    }
    private static void four(int x, int y) {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int up = upside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int right = rightside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int down = downside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int left = leftside(x, y, visited);
        int min = Math.min(up, Math.min(right, Math.min(down, left)));

        if (min == up) {
            rightside(x, y);
            downside(x, y);
            leftside(x, y);
        } else if(min == down) {
            rightside(x, y);
            leftside(x, y);
            upside(x, y);
        } else if (min == left) {
            rightside(x, y);
            downside(x, y);
            upside(x, y);
        } else {
            downside(x, y);
            leftside(x, y);
            upside(x, y);
        }
    }

    private static void three(int x, int y) {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int up = upside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int right = rightside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int down = downside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int left = leftside(x, y, visited);

        if (right > left) rightside(x, y);
        else leftside(x, y);

        if (up > down) upside(x, y);
        else downside(x, y);

    }

    private static void two(int x, int y) {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int up = upside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int right = rightside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int down = downside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int left = leftside(x, y, visited);

        if (up + down < right + left) {
            rightside(x, y);
            leftside(x, y);
        } else {
            upside(x, y);
            downside(x, y);
        }
    }
    private static void one(int x, int y) {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int up = upside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int right = rightside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int down = downside(x, y, visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = checked[i][j];
            }
        }
        int left = leftside(x, y, visited);

        int max = Math.max(up, Math.max(down, Math.max(left, right)));
        System.out.println(x + " " + y);
        if (max == up) {
            System.out.println("u");
            upside(x, y);
        } else if(max == right) {
            System.out.println("r");
            rightside(x, y);
        } else if (max == left) {
            System.out.println("l");
            leftside(x, y);
        } else {
            System.out.println("d");
            downside(x, y);
        }
    }
    private static int countFalse(boolean[][] b) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!b[i][j]) count++;
            }
        }
        return count;
    }

}

// 5, 4, 3, 2, 1순으로 true를 채워주자
// 5는 그냥 4방향 벽만나기전까지 true처리
// 4는 위오아, 오아왼, 위왼아, 왼위오 4가지 방법중에 가장 많이 true처리할 수 있는대로 정하고,
// 3도 마찬가지로 위오, 오아, 아왼, 왼위 4가지 방법 중 가장 많이 ture 처리할 수 있는대로.
// 2는 양옆, 위아래 2가지 방법 중 가장 많이 true처리 될 수 있게,
// 1은 위, 왼, 아, 오 4가지 방법 중 가장 ㅁ낳이 true처리 될 수 있게.
// 그러고 false 인 갯수를 세주자.
