package p21278_호석이두마리치킨;
/*
 * 1~n 번 건물 &  m개 도로(1시간 거리, 양방향 이동 가능)
 * 2개 건물에 치킨집을 열기(모든 건물에서의 접근성의 합 최소화)
 * [출력] 최적 위치의 건물 번호 2개와 총합최단시간
 * 작은 번호가 더 작을 수록 -> (작은 번호 ==) 큰 번호 더 작을 때 좋음 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 접근 방법: 완전 탐색으로 2개를 선택하고 > 거리 합 비교
 * */
public class Main {
	static int n; //건물 수
	static int m; //도로 수
	static ArrayList<ArrayList<Node>> road = new ArrayList<>();
	static boolean[] visited;
	static boolean[] checked;
	static int[] choice;
	static int ans;
	
	public static class Node {
		int from;
		int to;
		int cnt = 0;
		public Node(int from, int to, int cnt) {
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //건물 수
		m = Integer.parseInt(st.nextToken()); //도로 수
		for (int i = 0; i <= n; i++) {
			road.add(new ArrayList<>());
		}
		visited = new boolean[n+1]; //건물
		choice= new int[2];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			road.get(a).add(new Node(a,b,0));
			road.get(b).add(new Node(b,a,0)); //양방향 이동 가능
		} //도로 정보 입력
		
		dfs(1, 0);
		System.out.println(choice[0]+" "+choice[1]+" "+ans*2);
		
	} //main
	
	static void dfs(int idx, int sIdx) {
		//기저
		if (sIdx == 2) {
			bfs(); //건물 2개 선택했으면 bfs로 시간 판단
			return;
		}
		
		//재귀
		for (int i = idx; i <= n; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			dfs(i+1, sIdx+1);
			visited[i] = false; //백트래킹(현재 건물 선택 취소)
		}
	} //재귀를 통한 dfs (2곳 선택)
	
	static void bfs() {
		checked = new boolean[n+1]; //방문 추적
		Queue <Node> queue = new LinkedList<>(); //현재 탐색 중인 건물 저장
		int tmp = 0;
		for (int i = 0; i <= n; i++) {
			if (visited[i]) {
				queue.offer(new Node(i, 0, 0));
				checked[i] = true;
			}
		}
		
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int from = now.from;
			int cnt = now.cnt; //현재 건물 정보(cnt는 여기까지 오는데 필요한 이동 횟수)
			
			for (Node building : road.get(from)) {
				//현재 건물에서 이동가능한 모든 건물 확인
				if (!checked[building.to]) {
					//아직 방문안한 건물이면 queue에 추가(이동 횟수는 +1), 이 때 방문처리, 
					queue.offer(new Node (building.to, 0, cnt +1));
					checked[building.to] = true;
					tmp += cnt + 1;
				}
			}
		}
		
		if (ans > tmp) {
			ans = tmp;
			choice[0] = 0;
			choice[1] = 0;
			for (int i = 1; i <= n; i++) {
				if (visited[i]) {
					if (choice[0] == 0) {
						choice[0] = i;
					} else {
						choice[1] = i;
					}
				}
			}
		} 
	} //bfs
	
	
} //class
