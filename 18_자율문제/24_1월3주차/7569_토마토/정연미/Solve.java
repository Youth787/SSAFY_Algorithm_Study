package Algo_스터디.Jan_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class node2{
   int x;
   int y;
   int z;
   public node2(int x, int y, int z){
       this.x = x;
       this.y = y;
       this.z = z;
   }

}
public class 토마토_bfs2 {
   static int[][] dir = new int[][]{{-1,0,0},{1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
   static int[][][] arr;
   static ArrayList<node2> list = new ArrayList<>();
   static int result=0;
   static int M,N,H;
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       M = Integer.parseInt(st.nextToken()); // 열
       N = Integer.parseInt(st.nextToken()); // 행
       H = Integer.parseInt(st.nextToken()); // 높이

       arr = new int[N][M][H];

       for(int k=0; k<H; k++){
           for(int i=0; i<N; i++){
               st = new StringTokenizer(br.readLine());
               for(int j=0; j<M; j++){
                   arr[i][j][k] = Integer.parseInt(st.nextToken());
                   if(arr[i][j][k]==1){
                       list.add(new node2(i,j,k));
                   }
               }
           }
       }// 입력받기 완료

       result = BFS() -1;

       out : for(int k=0; k<H; k++){
           for(int i=0; i<N; i++){
               for(int j=0; j<M; j++){
                   if (arr[i][j][k]==0) {
                       result = -1;
                       break out;
                   }
               }
           }
       }

       System.out.println(result);
   }
   public static int BFS(){
       int x =0, y=0, z=0;
       LinkedList<node2> q = new LinkedList<>();
       for (int i = 0; i < list.size(); i++) {
           q.offer(list.get(i));
       }

       while(!q.isEmpty()){
           node2 curr = q.poll();
           x = curr.x;
           y = curr.y;
           z = curr.z;
           for(int p =0; p<6; p++) {
               int r = x + dir[p][0];
               int c = y + dir[p][1];
               int h = z + dir[p][2];

               if (r >= 0 && r < N && c >= 0 & c < M && h >= 0 && h < H&& arr[r][c][h] == 0) {
                   q.add(new node2(r, c, h));
                   arr[r][c][h] = arr[x][y][z]+1;
               }
           }
       }
       return arr[x][y][z];
   }
}
