import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1379_ { // 강의실 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int result[] = new int[n + 1];

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			queue.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), num });
		}

		PriorityQueue<int[]> room = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		int lecture[] = queue.poll();
		room.add(new int[] { lecture[1], 1 });
		result[lecture[2]] = 1;

		int idx = -1;
		while (!queue.isEmpty()) {
			lecture = queue.poll();
			idx = -1;
			if (room.peek()[0] <= lecture[0]) {
				int temp[] = room.poll();
				idx = temp[1];
			}
			if (idx == -1) {
				idx = room.size() + 1;
			}
			result[lecture[2]]=idx;
			room.add(new int[] { lecture[1], idx });
		}

		bw.write(room.size() + "\n");
		for (int i = 1; i <= n; i++) {
			bw.write(result[i] + "\n");
		}
		bw.flush();
	}
}
