package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스타트택시test {
    static int[][] dir = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    static boolean[][] visit;
    static int[][] road;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fe = Integer.parseInt(st.nextToken());
        road = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                road[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int startx = Integer.parseInt(st.nextToken())-1;
        int starty = Integer.parseInt(st.nextToken())-1;

        List<int[]> info_customer = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int startr = Integer.parseInt(st.nextToken())-1;
            int startc = Integer.parseInt(st.nextToken())-1;
            int endr = Integer.parseInt(st.nextToken())-1;
            int endc = Integer.parseInt(st.nextToken())-1;
            info_customer.add(new int[]{startr,startc,endr,endc});
        }

        while(!info_customer.isEmpty()){
            int[] closestCustomer = findClosestCustomer(startx, starty, info_customer);

            if (closestCustomer == null) {
                System.out.println(-1);
                return;
            }

            int distance1 = BFS(startx, starty, closestCustomer[0], closestCustomer[1]);
            if (distance1 == -1 || distance1 > fe) {
                System.out.println(-1);
                System.exit(0);
            }
                startx = closestCustomer[0];
                starty = closestCustomer[1];
                fe -= distance1;


            int distance2 = BFS(startx, starty, closestCustomer[2], closestCustomer[3]);
            if (distance2 == -1 || distance2 > fe) {
                System.out.println(-1);
                System.exit(0);
            }
                startx = closestCustomer[2];
                starty = closestCustomer[3];
                fe += distance2;

                info_customer.remove(closestCustomer);
        }
        System.out.println(fe);
    }
    public static int[] findClosestCustomer(int x, int y, List<int[]> customers){
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int distA = Math.abs(x - a[0]) + Math.abs(y - a[1]);
            int distB = Math.abs(x - b[0]) + Math.abs(y - b[1]);
            if (distA != distB) {
                return distA - distB;
            } else {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        
        for (int[] customer : customers) {
            q.add(customer);
        }

        while (!q.isEmpty()) {
            int[] customer = q.poll();
            int distance = BFS(x, y, customer[0], customer[1]);
            if (distance != -1) {
                return customer;
            }
        }
        return null;
    }

    public static int BFS(int startx, int starty, int endx, int endy){
        visit = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startx, starty,0});
        visit[startx][starty] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0]==endx && curr[1]==endy) return curr[2];

            for(int k=0; k<4; k++){
                int r = curr[0]+dir[k][0];
                int c = curr[1]+dir[k][1];

                if(r>=0 && c>=0 && r<N && c<N && !visit[r][c] && road[r][c]==0){
                    visit[r][c] = true;
                    q.add(new int[]{r,c,curr[2]+1});
                }
            }
        }
        return -1;
    }
}
