import java.io.*;
import java.util.LinkedList;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int r, c, tSheep, tWolf;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }
      //  입력완
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#' && !visited[i][j]) { // 벽도아니고 방문도안했으면 dfs
                    tWolf = 0; //임시 늑대와 양의 수를 지정
                    tSheep = 0;
                    dfs(i, j);
                    if (tWolf >= tSheep) // 늑대가 더 많거나 같다면 늑대승 아니면 양승
                        wolf += tWolf;
                    else
                        sheep += tSheep;
                }
            }
        }

        System.out.println(sheep + " " + wolf);

    }
    static void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= r || j >= c || visited[i][j] || map[i][j] == '#') return;
        visited[i][j] = true; // 방문처리
        if (map[i][j] == 'v') tWolf++;
        else if (map[i][j] == 'o') tSheep++;

        dfs(i - 1, j); // 상
        dfs(i, j - 1); // 좌
        dfs(i, j + 1); // 우
        dfs(i + 1, j); // 하

    }

}
