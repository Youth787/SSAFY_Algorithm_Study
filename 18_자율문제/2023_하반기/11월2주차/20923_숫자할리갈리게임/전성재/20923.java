import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 완전탐색
public class Main {
	static int n; // 도도와 수연이가 가지는 카드의 개수
	static int m; // 게임 진행 횟수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Deque<Integer> dodo = new LinkedList<>(); // 도도의 덱
		Deque<Integer> suyun = new LinkedList<>(); // 수연의 덱
		Deque<Integer> gd = new LinkedList<>(); // 도도의 그라운드
		Deque<Integer> gs = new LinkedList<>(); // 수연의 그라운드

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			dodo.offerFirst(d);
			suyun.offerFirst(s);
			
		}
		System.out.println(getWinner(dodo, suyun, gd, gs, m));
	}

	static String getWinner(Deque<Integer> dodo, Deque<Integer> suyun, Deque<Integer> gd, Deque<Integer> gs, int m) {
		while (m > 0) { // 게임 진행 횟수가 유효할 때 까지
			if (!dodo.isEmpty()) { // 도도 턴
				m--;
				gd.offerFirst(dodo.pollFirst());
				if (dodo.isEmpty()) {
					return "su";
				}
			} else { // 도도의 패가 없을 때 gg
				return "su";
			}
			// 2. 종 칠지 확인
			if (!gd.isEmpty() && !gs.isEmpty() && gd.peek() + gs.peek() == 5) { // 수연이가 종을 치는 경우
				while (!gd.isEmpty()) {
					suyun.offerLast(gd.pollLast());
				}
				while (!gs.isEmpty()) {
					suyun.offerLast(gs.pollLast());
				}
			} else if ((!gd.isEmpty() && gd.peek() == 5) || (!gs.isEmpty() && gs.peek() == 5)) { // 도도가 종을 치는 경우
				while (!gs.isEmpty()) {
					dodo.offerLast(gs.pollLast());
				}
				while (!gd.isEmpty()) {
					dodo.offerLast(gd.pollLast());
				}
			}
			if (m <= 0) {
				break;
			}

			if (!suyun.isEmpty()) { // 3. 수연 턴
				m--;
				gs.offerFirst(suyun.pollFirst());
				if (suyun.isEmpty()) {
					return "do";
				}
			} else { // 수연의 패가 없을 때 gg
				return "do";
			}

			// 4. 종 칠지 확인
			if (!gd.isEmpty() && !gs.isEmpty() && gd.peek() + gs.peek() == 5) { // 수연이가 종을 치는 경우
				while (!gd.isEmpty()) {
					suyun.offerLast(gd.pollLast()); // 첫번 째로 상대방 그라운드 더하기
				}
				while (!gs.isEmpty()) {
					suyun.offerLast(gs.pollLast()); // 두번 째로 자신의 그라운드 더하기
				}
			} else if ((!gd.isEmpty() && gd.peek() == 5) || (!gs.isEmpty() && gs.peek() == 5)) { // 도도가 종을 치는 경우
				while (!gs.isEmpty()) {
					dodo.offerLast(gs.pollLast());
				}
				while (!gd.isEmpty()) {
					dodo.offerLast(gd.pollLast());
				}
			}
			if (m <= 0) {
				break;
			}

		}

		if (dodo.size() > suyun.size()) {
			return "do";
		} else if (dodo.size() == suyun.size()) {
			return "dosu";
		} else {
			return "su";
		}
	}
}
