import java.util.Scanner;

public class Main15661_링크스타트 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		boolean[][] check = new boolean[1<<n][n]; //경우의수 부분집합 
		for (int i=0; i<(1<<n); i++) { 
			for (int j=0; j<n; j++) {
				if ((i & (1<<j)) >0) check[i][j]=true;
			}
			//System.out.println(Arrays.toString(check[i]));
		}
		
		int min = 987654321;
		for (int i=1; i<(1<<n)-1; i++) { //부분집합의 맨앞(all false), 맨뒤(all true) 제외 
			int start = 0; 
			int link = 0; 
			for (int j=0; j<n; j++) {
				for (int k=j+1; k<n; k++) {
					if (check[i][j] && check[i][k]) start = start+arr[j][k]+arr[k][j]; //스타트팀에 같이 들어있는 애들 
					else if (!check[i][j] && !check[i][k]) link = link + arr[j][k]+arr[k][j]; //아닌애들은 다른팀 
				}
			}
			min = Math.min(min, Math.abs(start-link)); //최솟값 
		}
		
		System.out.println(min);
		
	}

}
