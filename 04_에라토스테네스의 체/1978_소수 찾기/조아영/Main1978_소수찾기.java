import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1978_소수찾기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //주어지는 숫자 개수 
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken()); //일단 주어진 숫자들 입력받음 
		}
		Arrays.sort(arr); //숫자들 중 최댓값 찾으려고 정렬함  
		int max = arr[n-1];
		
		int[] p = new int[max+1]; //주어진 수 중 최댓값까지 소수 찾을 것 
		for (int i=2; i<=max; i++) {
			p[i]++; //일단 2부터 arr[n-1]까지의 모든 칸에 1 넣어줌 
		}
		for (int i=2; i<=max; i++) {//소수찾기 
			if (p[i]==1) { //만약에 i가 남아있으면(소수면) 걔는 놔두고 
				for (int j=i+1; j<=max; j++) { //i보다 큰 수 j 중에  
					if (p[j]==1 && j%i==0) {//아직 남아있고 i로 나누어떨어지는 수들 
						p[j]--; //다 지움 
					}
				}
			}
		} //소수찾기 끝 
		
		int cnt=0; //처음에 주어진 숫자들 중 소수의 개수  
		for (int i=0; i<n; i++) {  
			if (p[arr[i]]==1) cnt++; 
		}
		System.out.println(cnt);
		
	}
	
}
