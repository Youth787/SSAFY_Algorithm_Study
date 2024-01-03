import java.io.*;
import java.util.*;

public class Main {
	public static List<int[]>[] list;
	public static int[][] cost;
	public static boolean[] flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		cost = new int[n+1][2];
		flag = new boolean[n+1];
		
		int max = Integer.MAX_VALUE;
		for(int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
			cost[i][0] = max;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new int[] {b,c});
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		dijk(s,e);
		
		sb.append(cost[e][0]).append('\n');
		int cnt = 0;
		Stack<Integer> stack = new Stack<>();
		while(e!=0) {
			cnt++;
			stack.add(e);
			e = cost[e][1];
		}
		sb.append(cnt).append('\n');
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
		
	}
	
	public static void dijk(int s, int e) {
		Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));
		pq.add(new int[] {s,0});
		cost[s][0]=0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int from = now[0];
			
			if(flag[from])
				continue;
			flag[from] = true;
			
			if(from==e)
				break;
			
			for(int[] next : list[from]) {
				int to = next[0];
				int w = next[1];
				if(!flag[to] && cost[to][0]>cost[from][0]+w) {
					cost[to][0] = cost[from][0]+w;
					cost[to][1] = from;
					pq.add(new int[] {to,cost[to][0]});
				}
			}
			
		}
		
	}

}
