import java.io.*;
import java.util.*;
 
public class BOJ_17135_캐슬디펜스 {
   static int N,M,D;
   static int[] picked = new int[3];
   static int[][] map;
   static int MAX = 0;
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(in.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      D = Integer.parseInt(st.nextToken());
      map = new int[N][M];
      for(int i=0;i<N;i++) {
         st = new StringTokenizer(in.readLine());
         for(int j=0;j<M;j++){
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      pick(0,0);
      System.out.println(MAX);
   }
 
   public static void pick(int cnt, int start){
      if(cnt==3){
         MAX = Math.max(MAX,game());
         return;
      }
      for(int i=start;i<M;i++){
         picked[cnt] = i;
         pick(cnt+1, i+1);
      }
   }
 
   public static int game(){
      int count = 0;
      int[][] status = new int[N][M];
 
      for(int line = N;line>0;line--){
         for(int pick:picked){
            for(int d=1;d<=D;d++){
               int cnt = attack(status,d,line,pick);
               if(cnt<0) continue;
               count+=cnt;
               break;
            }
         }
      }
 
      return count;
   }
 
   public static int attack(int[][] status, int d, int line, int pick){
      int nn;
      for(int nm=pick-d;nm<=pick+d;nm++){
         nn = line-(d-Math.abs(nm-pick));
         if(nn<0 || nn >= line || nm <0 || nm >= M) continue;
         if(map[nn][nm]==0) continue;
         if(status[nn][nm] == 0){
            status[nn][nm] = line;
            return 1;
         }else if(status[nn][nm] == line) return 0;
      }
 
      return -1;
   }
 
}
