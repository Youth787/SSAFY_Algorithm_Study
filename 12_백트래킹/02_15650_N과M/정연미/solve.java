import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합 
// 중복을 허용하지 않는 조합 

public class n과m1 {
	static int N, M;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		NCR(0, 0);
	}// main end

	static void NCR(int sidx, int idx) { 
		if (sidx == M) {
			for (int a : result)
				System.out.print(a + " ");
			System.out.println();
			return;
		}
		
		if(idx==N) 
			return;

		result[sidx] = idx + 1;
		NCR(sidx + 1, idx + 1);
		NCR(sidx, idx + 1);
	}// method end
}