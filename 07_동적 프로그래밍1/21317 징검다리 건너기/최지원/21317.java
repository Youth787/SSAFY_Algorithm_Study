//package p21317_징검다리건너기;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
 
 
public class Main {
    static int n, k;
    static int ans = Integer.MAX_VALUE;
    static int [][] arr;
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
 
        arr = new int[n+1][2];

        for(int i=1; i<=n-1; i++) {
            String[] str = br.readLine().split(" ");
            arr[i][0]= Integer.parseInt(str[0]);//작은 점프(바로 다음 돌로 이동)
            arr[i][1] = Integer.parseInt(str[1]);//큰 점프(1개 돌 건너 뜀)
        }
        
        k = Integer.parseInt(br.readLine());//매우 큰 점프(2개 돌 건너뜀)
 
        DFS(0,1,false);
        System.out.println(ans);
    }
 
    //인자로 지금까지 쓴 에너지 합, 현재 위치, 매우 큰 점프 사용했는지
    private static void DFS(int sum, int now, boolean use){
        if( now == n ){
            ans = Math.min(ans,sum);
            return;
        }
 
        if( now > n ){
            return;
        }
 
        DFS(sum + arr[now][0], now + 1, use); // 한 칸 넘어갈 때
        DFS(sum + arr[now][1], now + 2, use); // 두 칸 넘어갈 때
 
        if(!use){ //매우 큰 점프 사용?
            DFS(sum+k, now+3, true);
        }
    }
}
