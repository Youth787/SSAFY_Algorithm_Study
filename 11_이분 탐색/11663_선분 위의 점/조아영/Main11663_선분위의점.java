import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11663_선분위의점 {

	static int[] dot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //점 개수
		int m = Integer.parseInt(st.nextToken()); //선분 개수 
		dot = new int[n]; 
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			dot[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(dot);
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
		}
		
	}
	
	static void binarySearch(int start, int end) {
		
	}
	
}
