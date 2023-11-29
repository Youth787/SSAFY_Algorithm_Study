package _11월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 기차가어둠을헤치고은하수를 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 기차 개수
        int b = Integer.parseInt(st.nextToken()); // 명령 개수

        int[][] train = new int[a][20];
        Set<String> trainSet = new HashSet<>();

        for (int i = 0; i < b; i++) {
            String[] input = br.readLine().split(" ");
            int row = Integer.parseInt(input[1]) - 1;

            if (input[0].equals("1")) {
                train[row][Integer.parseInt(input[2]) - 1] = 1;
            } else if (input[0].equals("2")) {
                train[row][Integer.parseInt(input[2]) - 1] = 0;
            } else if (input[0].equals("3")) {
                for (int j = 19; j > 0; j--)
                    train[row][j] = train[row][j - 1]; // 각 칸을 한 칸씩 오른쪽으로 이동
                train[row][0] = 0; // 첫 번째 칸에는 0을 넣어줌
            } else { // input[0]이 "4"인 경우
                for (int j = 0; j < 19; j++)
                    train[row][j] = train[row][j + 1];
                train[row][19] = 0; // 마지막 칸에는 0을 넣어줌
            }
        }

        for (int i = 0; i < a; i++) {
            StringBuilder sb = new StringBuilder();
            for (int num : train[i])
                sb.append(num);
            trainSet.add(sb.toString());
        }

        System.out.println(trainSet.size());
    } // main end
}
