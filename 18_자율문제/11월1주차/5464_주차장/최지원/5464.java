//52번줄 인덱스 예외엥
package p5464_주차장;
// https://www.acmicpc.net/problem/5464
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//문제: 주차 공간별 요금과 차량들의 무게와 출입 순서가 주어질 때, 오늘 하룻동안 주차장이 벌어들일 총 수입을 계산
// 대기장소는 큐(queue)
//만일 빈 주차 공간이 하나만 있거나 또는 빈 주차 공간이 없다가 한 대의 차량이 주차장을 떠나면 곧바로 그 장소에 주차를 하게 한다. 
//만일 빈 주차 공간이 여러 곳이 있으면, 그 중 번호가 가장 작은 주차 공간에 주차하도록 한다. 
//만일 주차장에 여러 대의 차량이 도착하면, 일단 도착한 순서대로 입구의 대기장소에서 줄을 서서 기다려야 한다. 
//주차료=(차랑의 무게)*(주차 공간마다 따로 책정된 단위 무게당 요금)

public class Main {
	static int n, m;//주차공간 수 n, 차량 수 m
	static boolean [] visitedN, visitedM;//
	static int [] Rs, Wk, parking ;//주차 공간 s의 단위 무게당 요금, 차량 k의 무게 저장하는 배열, 차가 주차된 위치
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//주차공간 수 n
		m = Integer.parseInt(st.nextToken());//차량 수 m
		
		Rs = new int [n];
		for (int i = 0; i < n; i++) Rs[i] = Integer.parseInt(br.readLine());
		Wk = new int [m+1];//차 번호는 1번부터니까
		for (int i = 1; i <= m; i++) Wk[i] = Integer.parseInt(br.readLine());
		
		int parking[] = new int[m + 1];//주차 위치
		PriorityQueue<Integer> queue = new PriorityQueue<>();//주차장 큐
		Queue<Integer> wait = new LinkedList<>();//대기 큐

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}//자리를 다 넣어놓고, 뺐다가 다시 넣는 방식으로 하는거

		int ans = 0;

		//2*M 개의 줄에서 m개의 차량은 정확하게 한번씩 주차장에 출입함.
		for (int i = 0; i < 2 * m; i++) {
			int car = Integer.parseInt(br.readLine());//차번호 입력받고
			if (car > 0 && !queue.isEmpty()) parking[car] = queue.poll();////남은 주차공간 값 하나 빼내고, 그 차가 어디 주차했는지 저장함
			else if (car > 0 && queue.isEmpty()) wait.add(car);////대기줄에 차를 넣는다
			else {
				//음수면 돈 계산. 차가 주차된 공간이 어디인지
				car = Math.abs(car);
				ans += Wk[car] * Rs[parking[car]];

				if (!wait.isEmpty()) {
					//만약 대기하는 차가 있으면: 대기줄 큐에서 차 한대 꺼내서 그 자리에 넣는다
					parking[wait.poll()] = parking[car];
				} else {
					//대기줄에 차가 없다면 그 공간 다시 비워둔다(주차공간 번호를 다시 queue에 넣겠다)
					queue.add(parking[car]);
				}
			}
		}
		System.out.println(ans);
		
		
	}//main
}//class
