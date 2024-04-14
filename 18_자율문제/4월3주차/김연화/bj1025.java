import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
	
	public static int N, M;
	public static int[][] map;
	public static String S, T;
	public static int result = -1;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	for(int i=0;i<N;i++) {
    		String s = br.readLine();
    		for(int j=0;j<M;j++) {
    			map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));	
    		}
    	}
    	
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			for(int di =-N; di<N;di++){ //행의 등차값 ( 행의 등차값은 -N ~ +N 까지 ) 
    				for(int dj = -M; dj<M;dj++) { //열의 등차값 ( 열의 등차값은 -M ~ +M 까지 )
    					
    					if(di == 0 && dj == 0) { //둘다 움직이지 않을떄
    						continue;
    					}
    					
    					int nI = i;
    					int nJ = j;
    					int now = 0;
    					while( nI >= 0 && nI < N && nJ >= 0 && nJ < M) {
    						//자리수 10의 자리수 씩 체크하기 위해 로직처리
    						now *= 10;
    						now += map[nI][nJ];
    						
    						//제곱근인지 판별
    						int sqrt_check = (int) Math.sqrt( (double) now);
    						if( sqrt_check * sqrt_check == now) result = Math.max(result, now);
    						
    						nI += di;
    						nJ += dj;
    					}
    					
    				}
    			}
    		}
    	}
    	System.out.println(result);
    	
    	
    }
    
    
}
