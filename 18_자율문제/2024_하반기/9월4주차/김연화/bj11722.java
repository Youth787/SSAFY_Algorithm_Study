import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int result = 0;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] D = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
			D[i] = 1;  // 자기 자신. 없으면 1이기에 1로 초기화
		}
		
		for(int i=0;i<N;i++) { //기준값
			for(int j=0;j<i;j++) { //이전값들
				if(A[j] > A[i]) {
					D[i] = Math.max(D[i], D[j]+1);
				}
			}
			result = Math.max(result, D[i]);
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}
