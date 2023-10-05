import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken()); //영토크기 행
		int m = Integer.parseInt(st.nextToken()); //영토크기 열

		int[][] village = new int[n+1][m+1];
		int[][] vsum = new int[n+1][m+1];
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine()," "); 
			for (int j=1; j<=m; j++) {
				village[i][j] = Integer.parseInt(st.nextToken()); //마을사람수
				vsum[i][j] = village[i][j];
//				for (int k=i; k<=n; k++) {
//					for (int l=j; l<=m; l++) {
//						vsum[k][l]+=village[i][j];
//					}
//				}
			}
//			System.out.println(Arrays.toString(vsum[i]));
		}

		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				vsum[i][j] += vsum[i][j-1];
			}
		}

		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				vsum[i][j] += vsum[i-1][j];
			}
			//System.out.println(Arrays.toString(vsum[i]));
		}

		int cnt = Integer.parseInt(br.readLine()); //질문수 
		for (int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine()," "); 
			int stR = Integer.parseInt(st.nextToken()); 
			int stC = Integer.parseInt(st.nextToken()); 
			int edR = Integer.parseInt(st.nextToken()); 
			int edC = Integer.parseInt(st.nextToken()); 
			int sum = vsum[edR][edC] - vsum[stR-1][edC]
					- vsum[edR][stC-1] + vsum[stR-1][stC-1];
//			for (int j=stR; j<=edR; j++) { //시간초과 
//				for (int k=stC; k<=edC; k++) {
//				sum = sum + village[j][k];
//				}
//			}
			System.out.println(sum);
		}

	}

}
