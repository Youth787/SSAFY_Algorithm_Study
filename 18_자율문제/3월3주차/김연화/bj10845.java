import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>(); 
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.equals("pop")) {
				if (q.isEmpty()) System.out.println(-1);
				else System.out.println(q.remove());
			} else if (str.equals("size")) {
				System.out.println(q.size());
			} else if (str.equals("empty")) {
				if (q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			} else if (str.equals("front")) {
				if (q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peek());
			} else if (str.equals("back")) {
				if (q.isEmpty()) System.out.println(-1);
				else System.out.println(peekLast(q)); // 함수만들었졍
			} else {
				String[] s = str.split(" ");
				q.add(Integer.parseInt(s[1]));
			}
		}
	}
	static int peekLast(Queue q) { // arr배열에 큐 넣어주고 마지막 인덱스 가져오기
		int[] arr = new int[q.size()];
		for (int i = 0; i < q.size(); i++) {
			arr[i] = (int) q.poll();
			q.add(arr[i]);
		}
		return arr[q.size() - 1];
	}
}
