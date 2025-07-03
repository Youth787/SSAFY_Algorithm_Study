//백준 FlymetotheAl 자바
//수학, 규칙찾기 

import java.util.*;
import java.io.*;

public class Main {
    private static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int dist = y - x;
            int max = (int) Math.sqrt(dist);
            if (max == Math.sqrt(dist)) sb.append(max * 2 - 1);
            else if (dist <= max * max + max) sb.append(max * 2);
            else sb.append(max * 2 + 1);

            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

}
