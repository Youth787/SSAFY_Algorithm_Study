import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		int[] nNum = new int[K+1];
		int[] mNum = new int[K+1];
		
		int nMax = 0;
		int mMax = 0;

		nNum[0] = N;
		mNum[0] = M;
		
		for(int i = 1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(dir == 1) {
				nNum[i] = num;
			} else {
				mNum[i] = num;
			}
		}
		
		Arrays.sort(nNum);
		Arrays.sort(mNum);

		for(int i = 1; i<nNum.length; i++) {
			int len = nNum[i] - nNum[i-1];
			nMax = Math.max(nMax, len);
		}
		for(int i = 1; i<mNum.length; i++) {
			int len = mNum[i] - mNum[i-1];
			mMax = Math.max(mMax, len);
		}
		System.out.println(nMax*mMax);
	}
}
