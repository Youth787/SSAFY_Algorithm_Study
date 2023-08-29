import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1644_소수연속합 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] prime = new int[n+1];
		int[] primenum = new int[n+1];
		int cnt=0; 
		for (int i=2; i<=n; i++) {
			if (prime[i]==0) {//소수
				primenum[cnt++]=i;
				for (int j=i+1; j<=n; j++) {
					if (prime[j]==0 && j%i==0) prime[j]--;
				}
			}
		}
		
		if (primenum[0]==n) {
			System.out.print(1);
		} else if (cnt>0){
		
		int ans = 0; 
		for (int i=0, j=1; i<cnt; i++) {//합 시작점
			int sum = primenum[i]; 
				while (sum<=n) {
					if (sum==n) {
						ans++;
						break;
					} 	
					else if (i+j<cnt) {
						sum = sum + primenum[i+j];
						j++;
					} else {
						break;
					}
				}
			}
		System.out.print(ans);

		} else {
			System.out.println(0);
		}
		
		
		
	}
	
}
