package _다시푼거;

import java.io.*;
import java.util.*;

public class _15686_치킨배달 {
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    home.add(new int[]{i, j});
                } else if (arr[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        // 치킨집 조합을 구함
        List<List<int[]>> combinations = new ArrayList<>();
        combination(chicken, new int[M], 0, 0, combinations);

        // 각 치킨집 조합에 대해 최소 거리를 구함
        for (List<int[]> combination : combinations) {
            int sum = 0;
            for (int[] h : home) {
                int dis = Integer.MAX_VALUE;
                for (int[] c : combination) {
                    int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    dis = Math.min(dis, d);
                }
                sum += dis;
            }
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }

    // 조합 구하는 함수
    public static void combination(List<int[]> arr, int[] selected, int start, int count, List<List<int[]>> result) {
        if (count == M) {
            List<int[]> temp = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                temp.add(arr.get(selected[i]));
            }
            result.add(temp);
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            selected[count] = i;
            combination(arr, selected, i + 1, count + 1, result);
        }
    }
}

