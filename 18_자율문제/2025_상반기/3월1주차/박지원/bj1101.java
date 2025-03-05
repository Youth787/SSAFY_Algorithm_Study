//백준 카드정리1 자바
//그리디, 브루트포스

import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[][] box;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            boolean flag = false;
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        List<int[]> jocker = new ArrayList<>();
        List<Integer> one = new ArrayList<>();

        for (int[] b : box) {
            boolean already = false;
            int isOne = -1;

            for (int index = 0; index < m; index++) {
                if (b[index] != 0) { // 0이 아닌 값 확인
                    if (!already) {
                        already = true;
                        isOne = index;
                    } else { // 두 개 이상의 0이 아닌 값이 존재할 경우
                        if (isOne != -1) {
                            jocker.add(b); // 조커 리스트에 추가
                        }
                        isOne = -1;
                    }
                }
            }
            if (isOne != -1) {
                one.add(isOne);
            }
        }

        Set<Integer> temp = new HashSet<>(one);

        if (jocker.isEmpty()) {
            if (one.size() - temp.size() > 0) {
                System.out.println(one.size() - temp.size() - 1);
            } else {
                System.out.println(one.size() - temp.size());
            }
        } else {
            System.out.println(jocker.size() - 1 + one.size() - temp.size());
        }
    }


}
