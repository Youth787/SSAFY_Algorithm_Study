import java.util.*;
import java.lang.*;
import java.io.*;

//토마토1
class Node {
	int x;
	int y;
	int day;
	Node(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

class Main
{
static int n, m, ans, days;
static int[][] tomato;
static Queue<Node> list;

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		ans = -1;
		days = 0;
		tomato = new int[n][m];
		list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
		st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					list.offer(new Node(i, j, 0));
				}
			}
		}
		//입력끝
		while (!list.isEmpty()) {
			Node cur = list.poll();
			color(cur.x, cur.y, cur.day);
		}
		
		ans = days;
		a: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomato[i][j] == 0) {
					ans = -1;
					break a;
				}
			}
		}
		System.out.println(ans);
	}
	// 토마토 익히기
	static void color(int x, int y, int day) {
		if (x - 1 >= 0 && tomato[x - 1][y] == 0) {
			tomato[x - 1][y] = 1;
			list.offer(new Node(x - 1, y, day + 1));
		}
		if (y - 1 >= 0 && tomato[x][y - 1] == 0) {
			tomato[x][y - 1] = 1;
			list.offer(new Node(x, y - 1, day + 1));
		}
		if (x + 1 < n && tomato[x + 1][y] == 0) {
			tomato[x + 1][y] = 1;
			list.offer(new Node(x + 1, y, day + 1));
		}
		if (y + 1 < m && tomato[x][y + 1] == 0) {
			tomato[x][y + 1] = 1;
			list.offer(new Node(x, y + 1, day + 1));
		}
		
		days = Math.max(days, day);
		return;
	}
}
