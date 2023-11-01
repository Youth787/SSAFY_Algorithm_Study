
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//문제: 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력
//입력: 첫째 줄=컴퓨터 수(100이하 양의 정수), 둘째 줄=컴퓨터 쌍의 수, 다음부터 연결된 번호 쌍
//그래프 : 정점Vertex, 간선Edge, 
public class Main {
	
	static int v, e, cnt;
	static int [][] adjArr;//인접행렬
	static boolean [] visited;//방문처리
	static Queue <Integer> queue;//BFS에서 사용할 Queue를 LinkedList로 만든다
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());//컴퓨터(정점) 수
		e = Integer.parseInt(br.readLine());//컴퓨터 쌍(간선) 수
		adjArr = new int [v+1][v+1];//인접행렬 방식의 그래프 표현(APS응용_day6)
		for (int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());//시작 정점
			int b = Integer.parseInt(st.nextToken());//끝 정점
			adjArr[a][b] = adjArr[b][a] = 1;//바이러스 감염은 무향같다
		
		}
		visited = new boolean[v+1];//정점 수만큼
		queue = new LinkedList<>();
		
		cnt = 0;
		
		BFS();
		
		System.out.println(cnt);
		
	}//main
	
	//너비 우선 탐색. 인자로 탐색 시작 정점의 인덱스 start
	public static void BFS() {
		queue.add(1); //시작점 (1번컴)을 큐에 삽입
		visited[1] = true;//점 방문표시
		while (!queue.isEmpty()) {//큐가 비어있지 않은 경우
			int t = queue.poll();//하나 꺼내
			for (int i=1; i<=v; i++) {//정점의 정보들을 돌면서 연결 된 친구 찾는다			
				if ( adjArr[t][i] == 1 && !visited[i]) {//adjArr의 값이 1이라는 건 그 점과 연결되어 있다, 아직 방문 안한 정점
					queue.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
	}

}//class
