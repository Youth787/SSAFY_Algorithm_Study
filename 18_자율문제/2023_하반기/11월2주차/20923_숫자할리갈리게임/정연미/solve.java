package _11월2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 할리갈리2 {
	static Deque<Integer> dequedo,dequesu,dequeansdo,dequeanssu;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		dequedo = new ArrayDeque<>();
		dequesu = new ArrayDeque<>();
		
		dequeansdo = new ArrayDeque<>();
		dequeanssu = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			dequedo.addFirst(a); // 도도
			dequesu.addFirst(b); // 수연
		} // 입력받기 완료
		
		flag = true;
        // true일 경우 도도의 차례 반대는 수연의 차례
        while (M-- > 0) {
        	
            if (dequedo.isEmpty() || dequesu.isEmpty()) 
                break;  // 덱 중 하나가 비어있으면 게임 종료

            if (flag) {
                int a = dequedo.pollFirst();
                dequeansdo.addFirst(a);
                check(a);
                flag = false;
            } else {
                int a = dequesu.pollFirst();
                dequeanssu.addFirst(a);
                check(a);
                flag = true;
            }
        } // while end

        if (dequedo.isEmpty() && !dequesu.isEmpty())
            System.out.println("su");
        else if (dequesu.isEmpty() && !dequedo.isEmpty()) 
            System.out.println("do");
        else 
            System.out.println(dequedo.size() == dequesu.size() ? "dosu" : dequedo.size() > dequesu.size() ? "do" : "su");
    }

    public static void check(int idx) {
        if (!dequeansdo.isEmpty() && !dequeanssu.isEmpty() && idx == 5) {
            // 상대방의 그라운드에 있는 카드 더미를 뒤집어 자신의 덱 아래로 그대로 합침
            while (!dequeanssu.isEmpty()) {
                dequedo.addLast(dequeanssu.pollFirst());
            }
            while (!dequeansdo.isEmpty()) {
                dequedo.addLast(dequeansdo.pollFirst());
            }
        } 
        if (!dequeansdo.isEmpty() && !dequeanssu.isEmpty() && dequeansdo.peekFirst() + dequeanssu.peekFirst() == 5) {
            // 그라운드에 있는 카드 더미를 그대로 가져옴
            while (!dequeansdo.isEmpty()) {
                dequesu.addLast(dequeansdo.pollFirst());
            }
            while (!dequeanssu.isEmpty()) {
                dequesu.addLast(dequeanssu.pollFirst());
            }
        }
    }
}
