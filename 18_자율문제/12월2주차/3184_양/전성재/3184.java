import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static boolean[][] visited;
    static int r,c,totalW,totalS, wolf, sheep;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        totalS = 0;
        totalW = 0;

        arr = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++){
            String input = br.readLine();
            for(int j = 0; j< c; j++){
                arr[i][j] = input.charAt(j);
            }
        }

        for(int i = 0; i< r; i++){
            for(int j = 0; j< c; j++){
                wolf = 0;
                sheep = 0;
                if(!visited[i][j]) {
                    if(arr[i][j] == 'v' || arr[i][j] == '.' || arr[i][j] == 'o') {
                        solve(i, j);
                    }
                }
                if(sheep > wolf){
                    wolf = 0;
                }else{
                    sheep = 0;
                }
                totalW += wolf;
                totalS += sheep;
            }
        }
        sb.append(totalS).append(" ").append(totalW);
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static void solve(int x, int y){
        visited[x][y] = true;

        if(arr[x][y] == 'o'){
            sheep += 1;
        }else if(arr[x][y] == 'v'){
            wolf += 1;
        }

        for(int i = 0; i< 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextX < r && nextY < c){
                if(!visited[nextX][nextY]){
                    if(arr[nextX][nextY] == '.' || arr[nextX][nextY] == 'v' || arr[nextX][nextY] == 'o'){
                        solve(nextX, nextY);
                    }
                }
            }
        }
    }
}
