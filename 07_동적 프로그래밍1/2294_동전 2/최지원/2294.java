//죄송함다 이문제도 어려웠숴요...공부해갈게요오ㅠㅠㅠㅠㅠㅠ

/* 
 [문제] 
동전 종류 수와 최소 목표 가치(입력 첫줄), 각 동전의 가치(입력 두번째 줄부터)가 주어질때.
n가지 종류의 동전을 사용해서, 그 가치의 합이 k원이 되도록 하는 동전의 최소 개수.
 [조건]  
 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우로 취급.
동전의 가치는 100,000보다 작거나 같은 자연수. 동전의 가치 중복 가능.
 */ 
  
 /* 
 풀이들 공통점 
 1) dp[i] 의 의미 = i의 가치를 만들어내기 위한 동전의 개수 

  
 2) 1차원 배열 dp의 크기 = k+1 (딱 정확히 k원을 만들어야 하기 때문)
  
 3) dp 안의 값을 int최대값으로 초기화해주고, for문을 거치며 i원을 만드는데 필요한 동전 수를 계속 갱신함

 4) 점화식 
for(i from 1번째 동전 to n번째 동전){
   for(int j=arr[i];j<=k;j++){
                dp[j]=Math.min(dp[j],dp[j-arr[i]]+1);
 for(i from 그 도시에서 조건에 주어진 비용으로 늘릴 수 있는 고객 수 to 목표인원+100) 
 { dp[i] = dp[i] & 그 도시 비용+dp[i-조건 비용으로 늘릴 수있는 고객 수] 중 최소값 } 
  
 5) 도시의 정보들을 입력받아서 미리 저장해두기보다, 점화식을 감싸는 for문에서 각 도시를 돌며 
 for(int i=0; i<도시 수; i++) 
 그때그때 변수에 저장해서 경우를 구함 
  
 */


//풀이들 공통적으로 dp[]의 사이즈는 목표가치+1로 설정.

// 풀이 1(  https://velog.io/@sungjin0757/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-2294%EB%B2%88-%EB%8F%99%EC%A0%842-JAVA )
//도출된 점화식 : dp[n] = dp[n], dp[n-동전의 가치]+1을 비교해서 더 작은 값

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,k; //n개의 동전, 최소 목표 가치k
    static int[] arr; 

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[n+1];

        for(int i=1;i<=n;i++)
        {
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        int[] dp=new int[k+1]; //여기서 dp[i]는 i의 가치를 만들어내기 위한 동전의 개수를 의미

        for(int i=1;i<=k;i++){
            dp[i]=Integer.MAX_VALUE-1;
        }

        //도출한 점화식에 따라 입력받은 동전의 가치를 활용해서 최소값 갱신해서 dp[j]에 저장
        for(int i=1;i<=n;i++){
            for(int j=arr[i];j<=k;j++){
                dp[j]=Math.min(dp[j],dp[j-arr[i]]+1);
            }
        }

        if(dp[k]==Integer.MAX_VALUE-1)
            System.out.println(-1); //k의 가치를 입력받은 동전으로 만들 수 없다면 -1 출력
        else
            System.out.println(dp[k]); //그게 아니면 가치 값이 k가 될때의 최소동전 개수(=dp[k]) 출력
    }

}


//-------------------------------
// 풀이 2( https://squareyun.tistory.com/28 )
import java.util.Arrays;
import java.util.Scanner;
//점화식: dp[j] = dp[j]와 dp[j-동전i의 가치]+1 중 더 작은 값
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100001); //최악의 경우 동전의 가치가 최대 100,000원이므로 dp배열 내의 값을 모두 100001로 초기화
        dp[0] = 0; //1원의 동전으로 1원을 만들 수 있는 경우의 수=0원을 만들 수 있는 경우의 수+1
        //점화식의 구조를 따르기 위해 dp[0]은 0으로 초기화
      
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        System.out.println(dp[k] == 100001 ? -1 : dp[k]); //조건이 true면(그 금액 만들기 불가능 = -1출력)
        sc.close();
    }
}
