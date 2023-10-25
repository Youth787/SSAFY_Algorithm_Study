import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제 : 일차원 좌표에 점 N개와 선분 M개가 있으면 각 선분 위에 입력으로 주어진 점이 몇 개 있는지
//입력: 첫줄에 n, m (1 ≤ N, M ≤ 100,000) / 둘째 줄에는 점의 좌표 / 이후부터는 선분의 시작점과 끝점
//모든 좌표는 1,000,000,000보다 작거나 같은 자연수니까 long하자
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//점
		int m = Integer.parseInt(st.nextToken());//선분
		
		long [] point = new long [n]; 
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			point[i] = Long.parseLong(st.nextToken());
		}//점
		
		long [][] line = new long [m][2]; 
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			line[i][0] = Long.parseLong(st.nextToken());
			line[i][1] = Long.parseLong(st.nextToken());
		}//선분		
		
	}//main
}//class
