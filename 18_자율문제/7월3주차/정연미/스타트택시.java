package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스타트택시 {
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

            int taxitoCustomer = BFS(startx, starty, closestCustomer[0], closestCustomer[1]);
            if (taxitoCustomer == -1 || taxitoCustomer > fe) {
                System.out.println(-1);
                System.exit(0);
            }
                startx = closestCustomer[0];
                starty = closestCustomer[1];
                fe -= taxitoCustomer;


            int customertoReach = BFS(startx, starty, closestCustomer[2], closestCustomer[3]);
            if (customertoReach == -1 || customertoReach > fe) {
                System.out.println(-1);
                System.exit(0);
            }
                startx = closestCustomer[2];
                starty = closestCustomer[3];
                fe += customertoReach;

                info_customer.remove(closestCustomer);
        }
        System.out.println(fe);
    }

    public static int[] findClosestCustomer(int sx, int sy, List<int[]> customers){
        int min = Integer.MAX_VALUE;
        int[] customer = null;
        for(int i=0; i<customers.size(); i++){
            int dist = BFS(sx,sy,customers.get(i)[0],customers.get(i)[1]);
            if(dist<min){
                min = dist;
                customer = customers.get(i);
            }else if(dist==min){
                if(customer[0]==customers.get(i)[0]) {
                    min = customer[1] < customers.get(i)[1]? min : dist;
                    customer = customer[1] < customers.get(i)[1]? customer : customers.get(i);
                } else {
                    min = customer[0] < customers.get(i)[0]? min : dist;
                    customer = customer[0] < customers.get(i)[0]? customer : customers.get(i);
                }
            }
        }

        return customer;
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
