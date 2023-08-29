import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2960_에라토스테네스의체 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//에라토스테네스의 체는 n보다 작거나 같은 소수를 모두 찾는 알고리즘 
		
		int[] arr = new int[n+1]; //카운팅용 배열 
		for (int i=2; i<=n; i++) { //2부터 n까지 모든 정수를 적기로 함 
			arr[i]++; //즉 인덱스가 2인 칸부터 n인 칸까지 모두 +1함 
		}
		
		//이제 이 수들 중 가장 작은 수를 찾는다. 이 수는 소수(P: prime number)다 
		//P를 지우고, 아직 지우지 않은 P의 배수들도 크기 순서대로 지운다 
		//아직 모든 수를 지우지 않았다면 지워지지 않은 수 중 가장 작은 수(소수)를 다시 찾아 반복 
		//K번째로 지워진 수를 출력하기 
		
		int cnt=0; //cnt==k 되면 종료 후 출력할 것 
		outer: for (int i=2; i<=n; i++) {
			if (arr[i]==1) { //만약 i번째 수가 아직 안 지워졌으면 걔는 소수임 
				arr[i]--; //걔 지우고 
				cnt++; //지운 개수 +1 
				if (cnt==k) {
					System.out.print(i);
					break outer; 
				}
				for (int j=2; j<=n; j++) { //그리고 소수의 배수들도 싹 지워야 함 
					if (j%i==0 && arr[j]==1) { //j가 i로 나누어떨어지면(=j가 i의 배수면) 
						arr[j]--; //얘도 지우고 
						cnt++; //지운 개수 +1 
						if (cnt==k) {
							System.out.print(j);
							break outer; 
						}
					}
				}
			}
		} //outer 포문 종료

		
	}

}
