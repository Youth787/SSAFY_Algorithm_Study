
import java.util.Scanner;

//평범한 배낭

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//물건 수
		int k = sc.nextInt();//최대 무게

		int [][] info = new int [n][2];

		for (int i=0; i<n; i++) {
			info[i][0]=sc.nextInt(); //무게w
			info[i][1]=sc.nextInt(); //가치v
		}
		
		int [][] dp = new int[n+1][k+1];//최대 무게만큼을 dp값으로 잡음
		for (int i=1; i<=n; i++) {
			//i는 물건 수만큼(i물건을 순서대로 쭉 담아보자
			for(int j=1; j<=k;j++) {
				if(info[i][0]>j) //i번째 무게 더 못담아
					dp[i][j] = dp[i-1][j]; //i물건까지 담은 것의 가치는 그 전 물건(i-1번째)까지 담았을 때와 같아...더 안담았으니까
				else
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-info[i][0]]+info[i][1]);
				//더 넣을 수 있는 경우에는 비교를 해 : 
				//dp[i-1][j]=그 전 물건(i-1번째)까지 담았을 때의 값과, 
				//dp[i-1][j-info[i][0]]+info[i][1]= [i-1][무게-i번째 물건 무게]일때 구했던 값+i번째 물건의 무게 값
			}
		}
		System.out.println(dp[n][k]);
	}
}

//https://st-lab.tistory.com/141
//최대 무게 =dp= 7일 때
//우선 이전 i에서의 값을 가져옴(i=1일때는 주어진 범위 밖이라서 0)
//i=1일때
//1번째 물건은 무게 6, 가치 13 = (1) 무게가 7인 물건 하나 or (2) 무게가 6인 물건 + 무게가 1인 물건의 조합
//무게가 1(가치=존재없는 것)+무게가 6인 물건(가치=13)의 합과 

