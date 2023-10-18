// 입력을 미리 받아놓고 확인하는게 아니라 그때그때 입력 받으면서 돈다..학생 for문이 제일 바깥에 있으니까 가능한거지
// https://kwoncorin.tistory.com/77
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer num = new StringTokenizer(br.readLine());

        int student_num = Integer.parseInt(num.nextToken()); // 문제에서 말하는 N(학생 수)
        int max_block_num = Integer.parseInt(num.nextToken()); // 문제에서 말하는 M(한 학생이 최대로 가질 수 있는 블록 개수)
        int height = Integer.parseInt(num.nextToken()); // 문제에서 말하는 H(블록을 쌓아서 만들고 싶은 높이)

        int[][] dp = new int[student_num + 1][height + 1]; // 2차원 dp배열 [학생 수+1][목표 높이+1]로 만듬
      
        for (int x = 1; x <= student_num; x++) { // 학생을 도는 for문(1번째부터 ~ n번째 학생까지)
            StringTokenizer block = new StringTokenizer(br.readLine()); // 학생 도는 for문에서 StringTokenizer를 또 받아서
            dp[x - 1][0] = 1; // 그 학생이 높이 0을 만들 수 있는 경우의 수는 1이다...왤까아
            int block_num = block.countTokens(); //countTokens는 (띄어쓰기를 기준으로) 남은 토큰 수...
            for (int y = 0; y < block_num; y++) { // 학생 x가 가진 블록을 하나씩 확인한다
                int now = Integer.parseInt(block.nextToken()); // 지금 블록 높이를 now에 저장
                for (int z = now; z <= height; z++) { // 지금 블록 높이부터 ~ 목표 높이까지 +1씩 하면서
                    dp[x][z] = (dp[x][z] + dp[x - 1][z - now]) % 10007;
                    // 학생 x가 z 높이의 블록을 쌓는 경우의 수는
                    // 지금까지의(학생 x가 z 높이의 블록을 쌓는) 경우의 수 + 이전 학생이 z-now 높이를 쌓은 경우의 수
                    // 나머지를 dp에 저장
                } // 경우의 수를 미리 다 저장하는 느낌?
            } // 모든 블록을 다 돌았다.

            // k 1부터 목표높이까지 돌면서. 지금 학생까지 고려했을 때의 값들을 다 채워넣는 느낌? 
            for (int k = 1; k <= height; k++) {
                dp[x][k] = (dp[x][k] + dp[x - 1][k]) % 10007;
            }
        } // 학생을 도는 for문

        bw.write(String.valueOf(dp[student_num][height]));
        bw.close();
        br.close();
    }//main
}//class
