import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {
    static int N;
    static int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Character[][] arr = new Character[N][N];
        Character[][] arr_RG = new Character[N][N];
        boolean[][] visit = new boolean[N][N];
        boolean[][] visit_RG = new boolean[N][N];
        int cnt =0;
        int cnt_RG=0;

        for(int i=0; i<N; i++){
            String input = br.readLine();
            // 적록색약 아닌 사람 입력
            for(int j=0; j<N; j++) arr[i][j] = input.charAt(j);
            // 적록색약인 사람의 경우 g도 r로 입력받는다.
            for(int j=0; j<N; j++) {
                Character in = input.charAt(j);
                if(in.equals('G')) arr_RG[i][j] = 'R';
                else arr_RG[i][j] = in;
            }
        }// 입력

        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                if(visit[i][j]) continue;
                Character curr = arr[i][j];
                Check(curr, i,j, visit, arr);
                cnt++;

                if(visit_RG[i][j]) continue;
                Character curr_RG = arr_RG[i][j];
                Check(curr_RG, i,j, visit_RG, arr_RG);
                cnt_RG++;
            }
        }
        System.out.println(cnt+" "+cnt_RG);
    }
    public static void Check(Character curr, int x, int y, boolean[][] visit, Character[][] arr){
        for(int k=0; k<4; k++){
            int r = x+dir[k][0];
            int c = y+dir[k][1];
            if(r>=0 && r<N && c>=0 && c<N && !visit[r][c] && arr[r][c].equals(curr)){
                visit[r][c] = true;
                Check(curr, r,c, visit, arr);
            }
        }
    }

}
