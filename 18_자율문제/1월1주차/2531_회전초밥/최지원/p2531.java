/* package p2531_회전초밥;
 *
 * 손님이 먹을 수 있는 초밥 가짓수의 최대값 구하는 문제
 * 행사 1: 벨트에서 k개의 접시 연속 먹으면 할인된 정액 가격으로 제공
 * 행사 2: 행사 1 참여 시 쿠폰에 적힌 초밥 종류 무료 제공
 * [입력] 첫 줄: 벨트에 놓인 접시 수 n, 초밥 가짓수 d, 행사 1 연속 접시 수 k, 행사 2 쿠폰  번호 c / 
 * 		 두 번째 줄~(n개 줄): 벨트 한 위치부터 회전 방향에 따른 초밥 종류 1개씩
 * 벨트 위에는 같은 종류 초밥이 둘 이상 있을 수 있음
 *
 * 투포인터(시작점 끝점) 풀이, 포인터 이동하며 해당되는 값(먹은 초밥 종류, 특정 종류 초밥 먹은 개수)을 늘리고 줄이는 과정
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*

 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//벨트에 놓인 접시 수 n
		int d = Integer.parseInt(st.nextToken());//초밥 가짓수 d
		int k = Integer.parseInt(st.nextToken());//행사 1 연속 접시 수 k
		int c = Integer.parseInt(st.nextToken());//행사 2 쿠폰  번호 c
		
		int[] belt = new int [n];//초밥 벨트
		for (int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}//초밥 종류 입력
		
		//그러고보니 초밥 가짓수 d는 어디에?
		int[] visited = new int [d+1];//먹은 초밥 확인
		
		//ans 초기값 설정, right 포인터 초기값으로 이동
		int cnt = 0;
		int left = 0;//투 포인터 왼쪽
		int right = 0;//투 포인터 오른쪽
		for (int i = 0; i < k; i++) {
			int now = belt[right];//지금 초밥
			visited[now]++;//해당 초밥 종류 먹었다고 체크
			if (visited[now] == 1) {
				//아직 안 먹은 초밥 종류
				cnt++;
			}
			right++;
		}
		int ans = cnt;//(입력받은대로) 0~ k-1번째 초밥까지 먹었을 때의 값으로 초기화
		
		while (left != n) {
			visited[belt[left]]--;//시작점 초밥(의 종류) 먹은 개수 제거
			if (visited[belt[left]] == 0) {
				cnt--;//만약 0이 되었다면 먹은 종류 1개가 사라지니까 cnt도 1 감소
			}
			left++;//포인터 이동
			
			visited[belt[right]]++;//끝점 초밥(의 종류) 먹은 개수 추가
			if (visited[belt[right]] == 1) {
				cnt++;//위의 과정으로 0에서 1이 되었다면 먹은 종류 1개가 생기니까 cnt도 1 증가
			}
			right++;//포인터 이동
			
			if (right == n) {
				right = 0;
			}//범위 벗어나면 right 포인터 0으로 이동
			
			if (visited[c] == 0) {
				ans = Math.max(ans, cnt+1);//쿠폰 사용 가능한거면 cnt+1한 값
			} else {
				ans = Math.max(ans, cnt);//쿠폰 종류 이미 먹었다면 cnt 그대로 비교
			}
		}
		
		
		System.out.println(ans);
	}//main
}//class
