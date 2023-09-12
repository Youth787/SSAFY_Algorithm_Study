//죄쏭해요....혼자 못풀겠어서 공부했슴다

/*
[문제]
호텔을 홍보 할 수 있는 도시 수와 최소 목표 인원(입력 첫줄), 각 도시별로 홍보하는데 드는 비용, 그 때 몇 명의 호텔 고객이 늘어나는지(입력 두번째 줄부터)에 대한 정보가 있을때.
고객을 적어도 C명 늘이기 위해 형택이가 투자해야 하는 돈의 최솟값.
[조건] 
정보에 나타난 돈에 정수배 만큼을 투자할 수 있다.
비용으로 얻을 수 있는 고객의 수는 100보다 작거나 같은 자연수.
*/

/*
풀이들 공통점
1) dp[i] 의 의미 = i명의 고객을 늘리기 위한 최소 비용
(최소 c명의 고객을 늘릴 수 있는 최소 비용은 dp[c~c+100] 범위에서의 최소값)

2) 1차원 배열 dp의 크기 = c+101 (한 도시에서 얻을 수 있는 고객 수가 최대 100이기 때문)

3) dp 안의 값을 int최대값으로 초기화해주고, i명을 얻는데 드는 최소비용들을 dp에 쭉 저장을 한 다음, dp[c]부터의 dp값 중 최소값을 answer값에 저장 (c 이상의 고객을 얻는데 최소비용일 들 수도 있기 때문)

4) 점화식
for(i from 그 도시에서 조건에 주어진 비용으로 늘릴 수 있는 고객 수 to 목표인원+100)
{ dp[i] = dp[i] & 그 도시 비용+dp[i-조건 비용으로 늘릴 수있는 고객 수] 중 최소값 }

5) 도시의 정보들을 입력받아서 미리 저장해두기보다, 점화식을 감싸는 for문에서 각 도시를 돌며
for(int i=0; i<도시 수; i++)
그때그때 변수에 저장해서 경우를 구함

*/


// 1번 풀이( https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-1106-%EC%9E%90%EB%B0%94-java-%ED%98%B8%ED%85%94 )
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
 
    static int c, n; //c=목표치, n=도시 개수
    static int [] dp; //1차원 배열로 dp
    public static void main(String[] args) throws IOException {

        //BufferedReader사용해 읽은 한 줄을 공백으로 구분하여 각각 c, n에 넣음 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" "); 
        c = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
 
        dp= new int [c+101]; 
        //c가 목표 인원인데, '정확히 c명을 모집'(x) '적어도 c명을 모집'(o)
        //한번 홍보할 때 유치할 수 있는 고객 수<=100이기 때문에 
        Arrays.fill(dp,987654321); //최소값을 찾는 과정이기 때문에 dp 배열을 최대값으로 초기화해줌.
        //987654321 하면 거의 Integer.MAX_VALUE 쓰는 것과 같음.
        dp[0]=0;
 
        for(int i=0; i<n; i++){ //n개 도시를 탐색함
            String[] s1 = br.readLine().split(" ");//도시 정보 s1에 저장 [0]에는 비용, [1]에는 그 비용으로 얻을 수 있는 고객 수.
            int cost = Integer.parseInt(s1[0]); //어떤 도시가 주어졌을 때의 홍보 비용
            int people = Integer.parseInt(s1[1]); //그 비용으로 얻는 고객 수
            for(int j=people; j<c+101; j++){ //j는 그 고객 수부터, 목표 인원+101까지 모든 값을 구해보며 작은 값을 찾는 과정
                dp[j]=Math.min(dp[j],cost+dp[j-people]); 
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=c; i<c+101; i++){
            result=Math.min(result,dp[i]);
        }
        System.out.println(result);
    }
}

//------------------------------
// 2번 풀이( https://haeng-on.tistory.com/49 )
import java.io.*;
import java.util.*;
//적어도 'c'명, 비용으로 얻을 수 있는 고객 수는 최대 100명
//적어도 c명 늘리기 위해 필요한 금액의 최소값은 c부터 c+100명을 늘리기 위해 필요한 금액의 최소값 찾기
class Main {
    static int c, n;
    static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        values = new int[c+101];
        Arrays.fill(values, Integer.MAX_VALUE);//values 값을 int 최대값으로 초기화
        n = Integer.parseInt(st.nextToken());//도시 수
        values[0] = 0; 
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()); //st에 또다른 줄 값(비용과 고객수) 받아옴
            int cost = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            for(int j=reward; j<c+101; j++){
                int prev = values[j-reward]; //이전 경우의 값을 갖고,
                if(prev!=Integer.MAX_VALUE) values[j] = Math.min(values[j], cost+prev);
                //만약 이전 값이 초기화된 상태가 아니라면
                //이전값에 이번 비용을 더한 경우와 values[j]를 비교
            }
        }
        int result = Integer.MAX_VALUE; //반환할 결과 값. int 최대값으로 초기화
        for(int i=c; i<c+101;i++){ //다시 돌려보면서
            result = Math.min(result,values[i]); //어떤 값이 최소인지를 result에 저장
        }
        System.out.println(result);
        br.close();
    }
}

//-----------------------------
// 3번 풀이 ( https://jyeonnyang2.tistory.com/m/318 )
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		// 각 도시에서 비용으로 얻을 수 있는 고객수는 100명 이하
		// 적어도 C명을 늘여야하므로 그보다 더 큰 고객을 들였을 때의 비용이 더 작을 수 있음
		int dp[] = new int[c+100]; // i명의 고객을 늘리기 위한 최소 비용
		Arrays.fill(dp, Integer.MAX_VALUE); //int 최대값으로 dp 초기화
		dp[0] = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			
   //c명보다 더 큰 값에서 최소비용이 들 경우를 고려하기 위해, 해당 도시의 (비용으로 늘릴 수 있는) 고객 수부터~각 도시가 확보할 수 있는 최대 100명의 고객까지
			for(int j=customer; j<c+100; j++) {
				// 돈에 정수배 만큼 투자할 수 있으므로
				// cost(현재 비용) + dp[j-customer] 로 j명의 고객을 늘린다.
				if (dp[j-customer] != Integer.MAX_VALUE) // 무한이라면 아직 초기화 그대로 값이므로 고객을 확보할 수 없다
					dp[j] = Math.min(dp[j], cost+dp[j-customer]);
			}
		}
  //여기까지 모든 경우의 최소비용을 구했고
		
  //여기부터 문제에서 원하는 값을 찾음
		int answer = Integer.MAX_VALUE;
		for(int i=c; i<c+100; i++) {// 최소 c명을 확보해야 하므로 dp[c]부터 탐색
			answer = Math.min(answer, dp[i]);
		}
		System.out.println(answer);
		
	}

}

//----------------------
// 풀이 4 ( https://dev-bok.tistory.com/m/9 )

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static MarketingCost[] city;
    static int result = 987654321;
    static int[] array;
    static int N, C;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        city = new MarketingCost[C];
        array = new int[1101];
        Arrays.fill(array, 987654321);
        array[0] = 0;

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            city[i] = new MarketingCost(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            for (MarketingCost m : city) {
                int index = 0;
                if (i - m.person < 0){
                    index = 0;
                }else{
                    index = i - m.person;
                }

                array[i] = Math.min(array[index] + m.cost, array[i]);
            }
        }

        for (int i = N; i <= N; i++) {
            result = Math.min(result, array[i]);
        }

        System.out.println(result);
    }

}

class MarketingCost {
    int cost;
    int person;

    public MarketingCost(int cost, int person) {
        this.cost = cost;
        this.person = person;
    }
}