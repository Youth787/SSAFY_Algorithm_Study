import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int money[] = new int[n + 1];
    
		for (int i = 1; i <= n; i++) {
			money[i] = Integer.parseInt(bf.readLine());
		}
		int car[] = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			car[i] = Integer.parseInt(bf.readLine());
		}

		int arr[] = new int[m + 1];
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		Queue<Integer> temp = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		int result = 0;

		for (int i = 0; i < 2 * m; i++) {
			int num = Integer.parseInt(bf.readLine());
			if (num > 0) {
				if (queue.isEmpty()) {
					temp.add(num);
				} else {
					arr[num] = queue.poll();
				}
			} else {
				num = Math.abs(num);
				result += car[num] * money[arr[num]];

				if (!temp.isEmpty()) {
					arr[temp.poll()] = arr[num];
				} else {
					queue.add(arr[num]);
				}
			}
		}
		System.out.println(result);
	}
}
