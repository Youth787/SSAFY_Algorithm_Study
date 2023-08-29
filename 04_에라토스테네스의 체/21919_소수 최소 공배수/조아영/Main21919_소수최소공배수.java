import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main21919_소수최소공배수 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int max = 0; 
		for (int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
//		Arrays.parallelSort(arr);
//		int max = arr[n-1];
		
		//소수찾을 배열 (일단 prime이라는 배열에 다 +1씩 해줌) 
		int[] prime = new int[max+1];
		for (int i=2; i<=max; i++) {
			prime[i]++;
		}
		
		//소수만 남기기 (소수면 1 그대로 두고 소수 아닌 애들 0으로 바꿈) 
		for (int i=2; i*i<=max; i++) { //i<=max 아니고 i*i<=max임에 유의 
			if (prime[i]==1) {
				for (int j=i+1; j<=max; j++) {
					if (prime[j]==1 && j%i==0) prime[j]--; 
				}
			}
		}
		
		//입력받은 수 중 소수 찾기 (소수 찾을 때마다 아까 만든 prime 배열에 +1씩 해줌) (이렇게 하면 중복 제외 가능)  
		for (int i=0; i<n; i++) {
			if (prime[arr[i]]>=1) prime[arr[i]]++; 
		}
		//처음엔 HashSet 으로 중복 제거하려다 HashSet 요소 어떻게 꺼내는지 몰라서... 
		
		long ans = 1; //답 큰 숫자 나올 거 같아서 long으로 써줌 
		for (int i=0; i<n; i++) {  
			if (prime[arr[i]]>=2) { //한번 찾았으면 2, 중복 있으면 3 이상일 것 
				//소수들의 최소공배수는 소수들 곱해주면 됨 
				ans = ans*(long)arr[i];
				prime[arr[i]]=1; 
			}
		}
		
		//소수 없으면 ans 그대로 1일 것 ... 그럼 -1 출력 
		System.out.println((ans==1 ? -1 : ans));

	}

}
