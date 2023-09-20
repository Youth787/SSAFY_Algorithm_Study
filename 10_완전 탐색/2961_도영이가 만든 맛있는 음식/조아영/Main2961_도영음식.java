import java.util.Scanner;

public class Main2961_도영음식 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //재료 개수
		int[] s = new int[n]; //신맛 (곱) 
		int[] b = new int[n]; //쓴맛 (합) 
		
		for (int i=0; i<n; i++) {
			s[i] = sc.nextInt();
			b[i] = sc.nextInt(); //일단 입력받음 
		}
		
		boolean[][] igd = new boolean[1<<n][n]; //재료 사용 경우의 수 전부 부분집합으로 
		for (int i=0; i<(1<<n); i++) {
			for (int j=0; j<n; j++) {
				if ((i & (1<<j))>0) {
					igd[i][j]=true; //비트마스킹 
				}
			}
			//System.out.println(Arrays.toString(igd[i]));
		}
		
		int min = 1000000000; 
		for (int i=0; i<1<<n; i++) { 
			int ss = 1;
			int bs = 0; 
			for (int j=0; j<n; j++) {
				if (igd[i][j]) { //해당 재료를 사용했으면 
					ss = ss * s[j]; //곱이랑 
					bs = bs + b[j]; //합 구해서 차이의 최솟값 찾을 것 
				}
			}
			//재료는 1개 이상 사용해야 함 (합이 0 초과인 걸로 판별) 
			if (bs>0) min = Math.min(min, Math.abs(ss-bs)); 
		}
		
		System.out.println(min);
		
	}

}
