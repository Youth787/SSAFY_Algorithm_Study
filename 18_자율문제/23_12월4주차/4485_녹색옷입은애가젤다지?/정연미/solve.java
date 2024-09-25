import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지_4485 {
    static int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] dist;
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
       int testcase =0;
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            testcase++;
            N = Integer.parseInt(br.readLine());
            if(N==0) break;

            arr = new int[N][N];
            dist = new int[N][N];
            for(int i=0; i<N; i++) Arrays.fill(dist[i],Integer.MAX_VALUE);

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            BFS();
            sb.append("Problem "+testcase+": "+dist[N-1][N-1]+"\n");
        }
        System.out.println(sb);
    }
    public static void BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,arr[0][0]});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int cost = curr[2];

            for(int k=0; k<4; k++){
                int r = i+dir[k][0];
                int c = j+dir[k][1];
                if(r>=0 && r<N && c>=0 && c<N){
                    if(dist[r][c]> cost+arr[r][c]){
                        dist[r][c] = cost+arr[r][c];
                        q.offer(new int[]{r,c,cost+arr[r][c]});
                    }
                }
            }
        }
    }
}

