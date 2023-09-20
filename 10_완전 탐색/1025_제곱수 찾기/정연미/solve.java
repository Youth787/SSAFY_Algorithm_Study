import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		} // 입력받기 완료

		int result = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for(int mi =-N; mi<N;mi++) {
					for(int mj = -M; mj<M; mj++) {
						if(mi==0 && mj ==0) {
							continue;
						}
						int num =0; 
						int idxi = i;
						int idxj = j;
						while(idxi >=0 && idxi <N && idxj>=0 && idxj <M) {
							num = num * 10  + arr[idxi][idxj];
							if(Math.abs(Math.sqrt(num)-(int)Math.sqrt(num))<1e-10) {
								result = Math.max(result, num);
							}
							idxi += mi;
							idxj += mj;
						}// while end 
					}
				}
			}
		}// for문  end
		
		System.out.println(result);
	}
}
