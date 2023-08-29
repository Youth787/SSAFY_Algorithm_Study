import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간초과 -> 소수 거르는 이중for문 범위설정 수정해서 해결 
//틀렸습니다 뜸 -> 1을 소수에서 제외 안 해줘서 생긴 문제였음 이것도 해결 
public class Main1929_소수구하기_수정 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
//		Scanner sc = new Scanner(System.in);
//		int m = sc.nextInt();
//		int n = sc.nextInt();
		
		int[] prime = new int[n+1];
		prime[0]=1;
		prime[1]=1;//소수에서 제외해줘야 함 
		for (int i=2; i*i<=n; i++) { //범위설정 주의(1) 
			if (prime[i]==0) {
				for (int j=i*i; j<=n; j=j+i) { //범위설정 주의(2)
					prime[j]=1;
				}
			}
		}
		
		for (int i=m; i<=n; i++) {
			if (prime[i]==0) System.out.println(i);
		}
		
//		StringBuilder sb = new StringBuilder();
//		for (int i=m; i<=n; i++) {
//			if (prime[i]==0) sb.append(i).append("\n");
//		}
//		System.out.print(sb);
	
	}
	
}
