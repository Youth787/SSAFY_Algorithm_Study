import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 배열 {
	static int[] heap;
	static StringBuilder sb = new StringBuilder();
	static int N, idx, sidx;
	// N 은 입력받을 정수의 개수
	// idx는 힙에서 삭제와 삽입을 반복할때 변화할 마지막 노드의 위치
	// sidx는 삭제와 삽입시 임의로 정해 놓을 노드 인덱스 값

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		heap = new int[N + 1];
		idx = 0;

		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				if (idx == 0) sb.append(0 + "\n");
				else sb.append(removeheap() + "\n");
			} else
				insertheap(a);
		} // 입력받기 완료
		bw.write(sb.toString());
		bw.flush();
	}// main end

	// 힙 삭제 메서드
	public static int removeheap() {
		int result = heap[1]; // 출력할 것은 루트 노드의 값.

		// 이 밑은 최대힙에 맞게 정렬하는 과정.
		heap[1] = heap[idx--]; // 마지막 노드의 값을 루트 노드에 담는다.
		sidx = 1; // 루트 노드부터 비교해 나갈 것이다. 자식노드로 
		int left = sidx *2;
		int right = sidx *2+1;
		while (true) {
			if (right<= idx && heap[left]<heap[right] && heap[sidx] < heap[right]) {
				swap(sidx, right);
				sidx = right;
			} else if(left<=idx && heap[sidx]<heap[left]) {
				swap(sidx,left);
				sidx = left;
			}
			else {
				break;
			}
		} // while end
		return result;
	}// method end

	// 힙 삽입 메서드
	public static void insertheap(int a) {
		heap[++idx] = a;
		sidx = idx;
		while (true) {
			if (sidx > 1 && heap[sidx] > heap[sidx / 2]) {
				swap(sidx, sidx / 2);
				sidx = sidx / 2;
			} else {
				break;
			}
		} // while end
	}// method end

	// swap 메서드
	public static void swap(int a, int b) {
		int tmp = 0;
		tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	} // method end
}