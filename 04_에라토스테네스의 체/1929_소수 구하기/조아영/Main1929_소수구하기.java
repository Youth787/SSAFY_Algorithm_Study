import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간초과 
public class Main1929_소수구하기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
//		Scanner sc = new Scanner(System.in);
//		int m = sc.nextInt();
//		int n = sc.nextInt();
		
		int[] prime = new int[n+1];
		
//		for (int i=2; i<=n; i++) {
		for (int i=2; i*i<=n; i++) {
			if (prime[i]==0) {
				for (int j=i+1; j<=n; j++) {
					if (prime[j]==0 && j%i==0) prime[j]--;
				}
			}
			if (i>=m) System.out.printf("%d/n",i);
		}
		
//		StringBuilder sb = new StringBuilder();
//		for (int i=m; i<=n; i++) {
//			if (prime[i]==0) sb.append(i).append("\n");
//		}
//		System.out.print(sb);
	
	}
	
}
