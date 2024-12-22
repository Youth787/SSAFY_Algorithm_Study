import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean visited[] = new boolean[100001];
		int parent[] = new int[100001];
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0));
		visited[N] = true;
		
		while (!q.isEmpty()) {
			Node temp = q.poll();
			
			if (temp.x == K) {
				System.out.println(temp.time);
				
				Stack<Integer> stack = new Stack<>();
				int a = temp.x;
				while (a != N) {
					stack.add(a);
					a = parent[a];
				}
				stack.add(a);
				
				while (!stack.isEmpty()) {
					System.out.print(stack.pop() + " ");
				}
				
				break;
			}
			
			if (temp.x + 1 < 100001 && !visited[temp.x + 1]) {
				q.offer(new Node(temp.x + 1, temp.time + 1));
				visited[temp.x + 1] = true;
				parent[temp.x + 1] = temp.x;
			}
			
			if (temp.x - 1 >= 0  && !visited[temp.x - 1]) {
				q.offer(new Node(temp.x - 1, temp.time + 1));
				visited[temp.x - 1] = true;
				parent[temp.x - 1] = temp.x;
			}
			
			if (temp.x * 2 < 100001 && !visited[temp.x * 2]) {
				q.offer(new Node(temp.x * 2, temp.time + 1));
				visited[temp.x * 2] = true;
				parent[temp.x * 2] = temp.x;
			}

		}
	}

}

class Node {
	int x;
	int time;
	
	Node (int x, int time) {
		this.x = x;
		this.time = time;
	}
}
