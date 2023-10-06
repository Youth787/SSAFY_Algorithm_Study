import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://codingrapper.tistory.com/201 
//https://record-developer.tistory.com/164
public class 완탐_Main21943_연산최대로 {
	
	static int n, p, q; 
	static int[] nums, ops;
	static boolean[] visited;
	static List<Integer> list = new ArrayList<>();
	static int max; 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //입력받을 숫자 개수 
		nums = new int[n]; //숫자 배열
		ops = new int[n]; //연산기호(+, *) 배열 
		visited = new boolean[n]; //방문쳌 
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt(); //양의 정수들 
		}
		p = sc.nextInt(); //더하기 기호 개수
		q = sc.nextInt(); //곱하기 기호 개수
		
		//가능한 연산의 결과 중 최댓값을 출력해야 해 
		max = Integer.MIN_VALUE; //최솟값으로 초기화하고 
		dfs(0, 0, 0); //깊이우선탐색 돌립니다 
		System.out.println(max);
	
	}
	
	static void dfs(int x, int a, int b) { //x는 인덱스, a와 b는 각각 연산자 +와 *의 개수  
		if (a<=p && b<=q) { //연산자 개수 사용 조건 충족하고 
			if (x==n) { //숫자 n개 다 썼으면 
				max = Math.max(max, calc()); //계산한 값과 기존의 최댓값을 비교해서 갱신하고 리턴 
				return;
			}
			
			for (int i=0; i<n; i++) {
				if (!visited[i]) { //숫자 중복사용 방지를 위해 방문체크 되어있지 않은 숫자만 탐색할 거예요 
					visited[i] = true; //사용한 숫자 체크하고 
					list.add(nums[i]); //리스트에 넣어줍니다 
					
					if (x==0) { //시작하자마자 연산자부터 담으면 안 되니까 x+1 해서 재귀 ㄱㄱ 
						dfs(x+1, a, b); 
					}
					else { //이렇게 하면 덧셈 곱셈 경우의 수 다 해볼 수 있다 
						ops[x] = 1; //1이면 덧셈 실행 
						dfs(x+1, a+1, b); 
						ops[x] = 2; //2면 곱셈 실행 
						dfs(x+1, a, b+1); 
						ops[x] = 0; //다 끝나고 나면 ops 초기화 
					}
					list.remove(x); //탐색 다녀왔으면 숫자 빼고 방문쳌 지워줘 
					visited[i] = false; 	
				}
			}
			
		}
	}
	
	static int calc() { //dfs로 가져온 숫자와 연산자들을 이용해 계산을 해볼 것 
		List<Integer> templist = new ArrayList<>();
		int temp = list.get(0); 우선 담아둔 숫자들 중 첫번째 거 뽑아 

		//문제에서 +와 *의 우선순위 같다는 점을 고려해야 함 
		//+를 먼저 계산하고, 계산한 모든 값을 곱해주는 방식으로 최댓값 서치 
		//예를 들어 식이 (1+2+3)*(7+5)*8 이렇게 세워진다면 * 를 기준으로 그 사이에 더해진 값들끼리 곱하게 됨 
		for (int i=1; i<n; i++) { 
			if (ops[i]==1) temp += list.get(i); //ops가 1이면 덧셈임. temp에 더해  
			if (ops[i]==2) { 
				templist.add(temp); //곱하기인 애들은 일단 리스트에 넣고 
				temp = list.get(i);
			}	
		}
		templist.add(temp); //덧셈 끝난 값은 지금 넣어 
		temp = 1; 
		for (int i=0; i<templist.size(); i++) {
			temp *= templist.get(i); //templist에 들어가 있는 애들 싹 곱해 
		}
		return temp; //결과값 리턴해 
		
	}
	
}
