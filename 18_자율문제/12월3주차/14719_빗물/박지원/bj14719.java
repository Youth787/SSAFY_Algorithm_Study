import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        int[] floor = new int[w];
        for (int i = 0; i < w; i++) {
            floor[i] = Integer.parseInt(st.nextToken());
        } //입력 완
        boolean[][] block = new boolean[w][h]; // 예제와 가로세로가 바뀜!!
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < floor[i]; j++) {
                block[i][j] = true;
            }
        } //블록 처리 완

        for (int i = 0; i < h; i++) {
            boolean isBlock = false;
            int cnt = 0;
            for (int j = 0; j < w; j++) {
                if (block[j][i]) isBlock = true;
                if (!block[j][i] && isBlock) {
                    cnt++;
                } else if (block[j][i] && isBlock && cnt != 0) {
                    answer += cnt;
                    cnt = 0;
                }
            }
        }

        System.out.println(answer);
    }
}

//1층에서부터 블록이 쌓이면 t, 안쌓였으면 f로 일차원배열을 boolean형태로 만들어서
//처음 t를 만남 -> 다음 t를 만날때까지 cnt++을 해주면서 카운팅을 해나간다
//다음 t를 만났을 때, total에 cnt를 더해주고 다시 cnt = 0으로 초기화.
//만약 다음 t를 못만나면? -> 빗물이 안고임
//
