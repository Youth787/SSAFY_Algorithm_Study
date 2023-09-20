import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15686_치킨배달 {
	
	static class POS { //Position. 행,열 좌표 
		int r;
		int c;
		
		public POS(int r, int c) {
			this.r = r;
			this.c = c; 
		}
		
//		public String toString() { //확인용 
//			return "("+this.r+","+this.c+")";
//		}
		
	}
	
	static int n, m; 
	static List<POS> home; //집 좌표들 모을거야 
	static List<POS> chicken; //치킨집 좌표들 
	static POS[] select = new POS[13]; //치킨집은 최대 13개 
	static int minSum;  //집-치킨집 거리 최솟값들의 합 구할 때 사용 
	static int ans = 10000; // 우리가 구하려는 건 minSum의 최솟값 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //도시 사이즈 
		m = Integer.parseInt(st.nextToken()); //치킨집 m개까지 남길 수 있어  
		
		int[][] arr = new int[n][n];//일단 도시 배열 입력받음 
		home = new ArrayList<>(); 
		chicken = new ArrayList<>(); 
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j]==1) home.add(new POS(i,j)); //집이면 집 리스트에 좌표 추가 
				if (arr[i][j]==2) chicken.add(new POS(i,j)); //치킨집이면 치킨집에 추가 
			}
		}
		
		for (int m1 = 1; m1<=m; m1++) { //치킨집은 1개부터 m개까지 남길 수 있어 
			combination(0,0,m1); // 치킨집 개수(m1) 골랐으면  m1개만큼 뽑는 조합 돌려 (ans도 저 안에서 구할거야) 
		}
		System.out.println(ans); //다 구했으면 출력~ 
		
	}//main
	
	//idx: 치킨집 리스트의 시작 인덱스, sidx: 내가 선택한 치킨집(select) 배열의 idx 
	static void combination(int idx, int sidx, int m1) { //조합. 수업코드 참고 
		
		if (sidx == m1) { //기저파트. 치킨집 m1개만큼 골랐으면 치킨거리합 구하고 return 할거야 
			
			//조합 잘 찾았는지 확인용 
//			for (int i=0; i<m1; i++) {
//				System.out.print(select[i].toString()+" ");
//			}
//			System.out.println();
			
			//잘 찾았으면 이제 치킨거리(합) 구해 
			minSum = 0; //합 0으로 초기화 시켜놓고 
			for (int j=0; j<home.size(); j++) {
				minDistance(home.get(j),m1); //집 좌표 넣어서 각 집과 치킨집 거리 최솟값 구해서 이걸로 minSum에 더해줄거임 
			}
			if (minSum<ans) ans=minSum; //다 더했는데 기존에 구해둔 ans보다 작으면 이걸로 교체~
			
			return;//다끝났으면 리턴 
		}

		for (int i=idx; i<=chicken.size()-m1+sidx; i++) { //그냥 수업코드임 
			select[sidx] = chicken.get(i);
			combination(i+1, sidx+1, m1);
		}
		
	}
	
	static void minDistance(POS home, int m1) { //집에서 치킨집까지 최소거리 구해서 minSum에 더하는 메소드 
		
		int minDist = 100; 
		for (int i=0; i<m1; i++) {
			int tmp = Math.abs(home.r-select[i].r) + Math.abs(home.c-select[i].c); 
			minDist = Math.min(minDist, tmp);
		}
			minSum = minSum+minDist;

	}
	
}
