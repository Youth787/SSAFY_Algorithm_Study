import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());



            sb.append(tangent(x1, y1, r1, x2, y2, r2)).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static int tangent(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distPow = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // 원 중심의 거리

        // 중심 같으면서 반지름 같을경우 전부겹침
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }

        //두 원의 반지름 합보다 중점간 거리가 더 멀면 안겹침
        else if (distPow > Math.pow(r1 + r2, 2)) return 0;

        //원 안에 원이 있으나 내접하지 않을 때
        else if (distPow < Math.pow(r2 - r1, 2)) return 0;

        // 내접할 때
        else if (distPow == Math.pow(r2 - r1, 2)) return 1;

        // 외접할 때
        else if (distPow == Math.pow(r1 + r2, 2)) return 1;

        // 전부 아니면 2개가 겹침
        else return 2;
    }

}
