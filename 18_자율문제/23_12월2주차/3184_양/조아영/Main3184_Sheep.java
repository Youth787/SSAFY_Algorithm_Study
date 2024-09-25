import java.io.*;
import java.util.*;

public class Main3184_Sheep {
	static int r, c;
	static char[][] arr;
	static boolean[][] visited; 
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		visited = new boolean[r][c];
		for (int i=0; i<r; i++) {
			String tmp = br.readLine();
			for (int j=0; j<c; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		} //입력 완료 
		
		// .빈 필드 # 울타리 o 양 v 늑대 //한 영역 안에서 양은 늑대보다 많으면 이김
		//살아남은 양과 늑대의 수는? 
		
		int totalsheep=0;
		int totalwolf=0; 
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (!visited[i][j] && arr[i][j]!='#') { //해당 영역 아직 안 갔고 갈 수 있으면
					sheep = 0;
					wolf = 0; 
					bfs(i,j); //거기서부터 bfs (너비우선탐색) 
					if (sheep>wolf) totalsheep+=sheep; //양이 더 많으면 양이 이김 
					else totalwolf+=wolf;
				}
			}
		}
		System.out.printf("%d %d",totalsheep,totalwolf);
	}

	static int sheep; //현재 영역의 양 수
	static int wolf; //현재 영역의 늑대 수 
	static void bfs(int i, int j) {
		if (arr[i][j]=='o') sheep++; //양이면 양 추가
		if (arr[i][j]=='v') wolf++; //늑대면 늑대 추가 
		visited[i][j]=true; //방문체크 
		
		for (int k=0; k<4; k++) {
			if (i+dr[k]<0 || i+dr[k]>=r || j+dc[k]<0 || j+dc[k]>=c) continue;
			if (arr[i+dr[k]][j+dc[k]]=='#') continue;
			if (visited[i+dr[k]][j+dc[k]]) continue;
			bfs(i+dr[k],j+dc[k]);
		}
	}
}
