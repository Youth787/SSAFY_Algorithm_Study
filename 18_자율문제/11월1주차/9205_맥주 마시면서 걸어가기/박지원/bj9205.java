import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node { // 좌표를 이용해서 그래프로 풀기
	private int x;
	private int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
public class bj9205 {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
        	int n = Integer.parseInt(br.readLine());
        	String ans = "happy";
        	List<Node> list = new ArrayList<>();
        	for (int i = 0; i < n + 2; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		list.add(new Node(a, b));
        	}
        	//입력 끝
        	//이제 노드를 활용하여 그래프를 연결해야하쥐
        	List<List<Integer>> graph = new ArrayList<>();
        	for (int i = 0; i < n + 2; i++) { // 초기화
        		graph.add(new ArrayList<>());
        	}
        	for (int i = 0; i < n + 2; i++) {
        		for (int j = i + 1; j < n + 2; j++) {
        			if (getDist(list.get(i), list.get(j)) <= 1000) { // 둘의 거리가 1000이하면 갈수있으니 양방향연결
        				graph.get(i).add(j);
        				graph.get(j).add(i);
        			}
        		}
        		
        	}
        	sb.append((BFS(graph, n) ? "happy" : "sad")).append("\n");
        }
        System.out.println(sb);
        
    }
    static int getDist(Node a, Node b) { // 두 점 사이 거리를 나타내는 함수
    	return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }
    static boolean BFS (List<List<Integer>> graph, int n) { // 갈수있는지 없는지 판단함수
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(0); // 집 넣어주고
    	
    	boolean[] visited = new boolean[n + 2];
    	visited[0] = true; // 집 방문처리
    	
    	while (!q.isEmpty()) { // 큐가 빌때까지
    		int now = q.poll(); // 현재 위치를 now로 두고
    		
    		if (now == n + 1)
    			return true;
    		
    		for (int next: graph.get(now)) {
    			if (!visited[next]) {
    				visited[next] = true;
    				q.offer(next);
    			}
    		}
    	}
    	return false;
    }

}

//https://steady-coding.tistory.com/97
