import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static char[][] map;
  static String ans;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    map = new char[size[0]][size[1]];
    int[] start = new int[2];
    for (int i = 0; i < size[0]; i++) {
      String s = br.readLine();
      for (int j = 0; j < size[1]; j++) {
        if (s.charAt(j) == 'I') {
          start[0] = i;
          start[1] = j;
        }
        map[i][j] = s.charAt(j);
      }
    }

    boolean[][] visited = new boolean[size[0]][size[1]];
    dfs(start[0], start[1], visited);
    if (count > 0) {
      System.out.println(ans);
    } else {
      System.out.println("TT");
    }
  }

  public static void dfs(int i, int j, boolean[][] visited) {
    visited[i][j] = true;
    if (map[i][j] == 'P') {
      count = count + 1;
      ans = String.valueOf(count);
    }

    // 동서남북
    if (i + 1 < map.length) {
      if (map[i + 1][j] != 'X' && !visited[i + 1][j]) {
        dfs(i + 1, j, visited);
      }
    }

    if (i - 1 > -1) {
      if (map[i - 1][j] != 'X' && !visited[i - 1][j]) {
        dfs(i - 1, j, visited);
      }
    }

    if (j + 1 < map[0].length) {
      if (map[i][j + 1] != 'X' && !visited[i][j + 1]) {
        dfs(i, j + 1, visited);
      }
    }

    if (j - 1 > -1) {
      if (map[i][j - 1] != 'X' && !visited[i][j - 1]) {
        dfs(i, j - 1, visited);
      }
    }

  }

}
