import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// M개 이상의 치킨 집 중에서 M개의 치킨집을 고르는 경우의 수 => 조합
// 집이라면 그 집에서 치킨집 마다의 거리를 구해서 그중 최솟값이 해당 집의 치킨거리가 된다.
// 그렇게 모든 집의 치킨거리를 구해서 합을 구하면 해당 조합에서의 치킨거리합이나온다.
// 그때, 조합에서 치킨거리가 가장 작은 경우를 출력한다.

// 치킨집 좌표는 클래스로 구현하고 okay 
// 조합은 그 치킨집 좌표를 리스트에 담아서 okay
// 행에 대한 false true로 구현할 수 있지 않을까. ncr

public class 치킨배달 {
	static int N, M, chicken_count, distance;
	static int[][] map;
	static List<chicken> chicken_home; // 좌표에 있는 모든 치킨집에 대한 좌표
	static List<chicken> chicken_select; // 조합을 통해 선택한 치킨집 좌표 모음
	static int sum =0, result =987654321;
	
	static class chicken {
		int x;
		int y;

		public chicken(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} // 치킨집 좌표 객체로 만들겠다

	// 전체 치킨집 중 M개의 치킨집 조합을 구하는 메서드
	public static void ncr(int idx, int sidx) {
		// 기저 조건
		// 여기에 조합이 담긴 M개의 좌표가 나올것.
		if (sidx == M) {
			// M개만큼 집좌표와의 거리를 구하고 그 중 최소값을 구한다.
			// 그 최솟값들의 합을 구한다.
			// 그 최솟값들의 합의 최소를 구한다. 조합중에
			
			// 리스트라서 한번 담긴 값들이 밀려서 누적되기 때문에
			// sidx 이후에 담긴 값들은 지워야한다.
			
			
			for(int i=0; i<chicken_select.size(); i++) {
				System.out.println(chicken_select.get(i).x+" "+chicken_select.get(i).y);
				}
				System.out.println();
				// 문제를 찾음.. 
				// 리스트라서 값이 누적된다. 
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						distance = 987654321;
						for (int k = 0; k < M; k++) {
							int xdiff = Math.abs(chicken_select.get(k).x - i); // 치킨집과 집의 x좌표 차이의 절댓값 
							int ydiff = Math.abs(chicken_select.get(k).y - j); // 치킨집과 집의 y좌표 차이의 절댓값
							distance = Math.min(xdiff+ydiff, distance);
							
						}
						// 최솟값을 집마다 더해준다. 
						sum += distance;
					}
				}
			} // for end 
			// 해당 조합에서 모든 좌표를 돌았을때 치킨 거리가 나왔다. 
			// 해당 치킨 거리가 다른 조합들이랑 비교했을때 작으면 최솟값을 갱신한다. 
			result = Math.min(sum, result);
			return;
		}

		if (idx == chicken_count) {
			return;
		} // 기저 조건 종료

		// 재귀파트
		
		chicken_select.add(sidx, chicken_home.get(idx)); // sidx인덱스에 idx인덱스에 해당하는 치킨집의 좌표를 담는다.
		
		ncr(idx + 1, sidx + 1); // 뽑은거
		ncr(idx + 1, sidx); // 안뽑은거
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		} // 입력받기 완료

		chicken[] chicken = new chicken[M];
		chicken_home = new ArrayList<>();
		chicken_select = new ArrayList<>();
		chicken_count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {// 치킨집이면
					chicken_home.add(new chicken(i, j)); // 치킨집 리스트에 치킨집의 좌표를 담아준다.
					chicken_count++; // 치킨집의 개수를 세준다.
				}
			}
		} // 담아주기 종료.
		
//		for(int i=0; i<chicken_home.size(); i++) {
//		System.out.println(chicken_home.get(i).x+" "+chicken_home.get(i).y);
//		} // 확인결과 치킨집에 대한 좌표 제대로 담음. 치킨집 개수도 제대로 담음. 
		
		ncr(0, 0);
		System.out.println(result);

	}// main end
}
