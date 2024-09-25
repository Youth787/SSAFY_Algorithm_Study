import java.io.*;
import java.util.*;

public class Main {

    public static int height, width;
    public static char[][] garden;
    public static boolean[][] visited;
    public static int[][] move = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static int sheep=0, wolf = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int answerSheep = 0, answerWolf = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        garden = new char[height][width];
        visited = new boolean[height][width];

        for (int x = 0; x < height; x++) {
            garden[x] = br.readLine().toCharArray();
        }

        // 방문하지 않은, 양과 늑대가 발견된다면 탐색 시작
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (!visited[x][y] && (garden[x][y] == 'o' || garden[x][y] == 'v')) {
                    sheep = wolf = 0;
                    dfs(x, y);
                    // 양이 더 많을 경우 양이 이긴다.
                    if(sheep>wolf)
                        answerSheep += sheep;
                    else
                        answerWolf += wolf;
                }
            }
        }

        sb.append(answerSheep).append(" ").append(answerWolf);

        System.out.println(sb);


    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        // 양이나 늑대일 경우 횟수 증가
        if(garden[x][y]=='v')
            wolf++;
        if(garden[x][y]=='o')
            sheep++;

        int next_x, next_y;

        for (int i = 0; i < 4; i++) {
            next_x = x + move[i][0];
            next_y = y + move[i][1];

            // 범위를 벗어나거나, 방문한적이 있거나, 울타리일 경우 탐색하지 않는다.
            if(next_x<0 || next_y<0 || next_x>=height || next_y>=width || visited[next_x][next_y] || garden[next_x][next_y]=='#')
                continue;

            visited[next_x][next_y] = true;
            dfs(next_x, next_y);
        }
    }

}
출처: https://kwoncorin.tistory.com/148 [권코린:티스토리]
