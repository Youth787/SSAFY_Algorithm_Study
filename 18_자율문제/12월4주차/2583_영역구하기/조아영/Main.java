import java.io.*;
import java.util.*;

public class Main {
    static int M, N, cnt = 0;
    static int[][] map;
    static List<Integer> l = new LinkedList<>();
    static int[] dR = {1, -1, 0, 0};
    static int[] dC = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   //row
        N = Integer.parseInt(st.nextToken());   //col
        int K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        while(K-->0){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = y1; i<y2; i++)
                for(int j = x1; j<x2; j++)
                    map[i][j] = 1;
        }

        bfs();

        Collections.sort(l);

        System.out.println(cnt);
        for(int i : l)
            System.out.print(i+" ");
    }

    static void bfs(){
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 0) {
                    l.add(bfs(i, j));
                    cnt++;
                }
            }
        }
    }

    static int bfs(int row, int col){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col));
        map[row][col] = 1;
        int sum = 1;

        while(!q.isEmpty()){
            Node a = q.poll();

            for(int i = 0; i<4; i++){
                int dr = a.row + dR[i];
                int dc = a.col + dC[i];

                if(dr<0||dc<0||dr>=M||dc>=N)
                    continue;
                if(map[dr][dc] == 1)
                    continue;

                sum++;
                q.offer(new Node(dr, dc));
                map[dr][dc] = 1;
            }
        }

        return sum;
    }
}
class Node{
    int row, col;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
