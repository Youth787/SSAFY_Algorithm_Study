import java.io.*;
import java.util.*;

//백준 링크와 스타트 구현!!!
//start만 구해서 map 전체에서 빼주면 된다고 생각했는데, 문제에는 전체 인원이 다 축구에 참여한다는 말이 없었따..!! 그냥 한팀에 한명씩만 꼭 들어가면 됐었던 문제
public class Main {
    static int n, start, link, ans, total;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        visited[0] = true;
        ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
                total += map[i][j];
            }
        }
        solve(0);
        System.out.println(ans);

    }
    static void solve(int i) {
        start = 0;
        link = 0;
        List<Integer> startIdx = new ArrayList<>();
        List<Integer> linkIdx = new ArrayList<>();
        for (int k = 1; k <= n; k++) {
            if (visited[k]) startIdx.add(k);
            else linkIdx.add(k);
        }
        for (int k = 0; k < startIdx.size() - 1; k++) {
            for (int l = k + 1; l < startIdx.size(); l++) {
                start += map[startIdx.get(k)][startIdx.get(l)];
                start += map[startIdx.get(l)][startIdx.get(k)];
            }
        }
        for (int k = 0; k < linkIdx.size() - 1; k++) {
            for (int l = k + 1; l < linkIdx.size(); l++) {
                link += map[linkIdx.get(k)][linkIdx.get(l)];
                link += map[linkIdx.get(l)][linkIdx.get(k)];
            }
        }

        ans = Math.min(ans, Math.abs(start - link));
        for (int j = i + 1; j < n; j++) {
            if (visited[j]) continue;
            visited[j] = true;
            solve(j);
            visited[j] = false;
        }
    }
}

