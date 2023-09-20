import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main21278_두마리치킨 {
	
	static int n; 
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		//컴공 출신은 치킨집을 하게 되어있다. 현실을 부정하지 말고 받아들이면 마음이 편하다. 
		//결국 호석이도 2050년에는 치킨집을 하고 있다. 치킨집 이름은 "호석이 두마리 치킨"이다.
		
		//코드 참고 : https://subin-programming.tistory.com/297
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //건물개수
		int m = Integer.parseInt(st.nextToken()); //도로개수
		
		map = new int[n+1][n+1];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (i==j) continue;
				map[i][j]=(int) 1e9;
			}
		}
		
		// 간선 정보 입력 받기
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //건물 A
			int b = Integer.parseInt(st.nextToken()); //건물 B 	
			map[a][b]=map[b][a]=1;
		}
		
		//플로이드 와샬 알고리즘 
		for(int k=1;k<=n;k++) 
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);

		//최소시간 합
		int ans = Integer.MAX_VALUE; 
		int chicken1 = 0;
		int chicken2 = 0; 
		for (int i=1; i<=n; i++) {
			for (int j=i+1; j<=n; j++) { //치킨집 두개 골라 
				//여기서 다른 건물까지 거리의 최단시간 합계 구해
				int t = minTimeSum(i,j);
				if (ans>t) {
					ans = t;
					chicken1 = i; 
					chicken2 = j; 
				}
			}
		}
		
		System.out.println(chicken1 + " " + chicken2 + " " + ans*2); //왕복 거리이므로 *2 
	
	}
	
	/*
	 * 모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단 시간의 총합을 구하는 문제이기 때문에
	 * 두 치킨집 중 더 가까운 치킨집까지의 거리를 구해 return 한다. 
	 */
	static int minTimeSum(int x, int y) {
		
		int result = 0; 
		for (int i=1; i<=n; i++) {
			result+=Math.min(map[x][i],map[y][i]);
		}
		return result;
	}

}
