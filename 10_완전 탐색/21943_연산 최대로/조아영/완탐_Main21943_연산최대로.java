import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://codingrapper.tistory.com/201 
public class 완탐_Main21943_연산최대로 {
	
	static int n, p, q; 
	static int[] nums, ops;
	static boolean[] visited;
	static List<Integer> list = new ArrayList<>();
	static int max; 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		nums = new int[n]; //숫자 배열
		ops = new int[n]; //+, * 배열 
		visited = new boolean[n]; //방문쳌 
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt(); //양의 정수들 
		}
		p = sc.nextInt(); //더하기 기호 개수
		q = sc.nextInt(); //곱하기 기호 개수
		
		//가능한 연산의 결과 중 최댓값을 출력해야 해 
		max = Integer.MIN_VALUE;
		dfs(0, 0, 0); 
		System.out.println(max);
	
	}
	
	static void dfs(int x, int a, int b) { //x는 인덱스 
		if (a<=p && b<=q) {
			if (x==n) { 
				max = Math.max(max, calc());
				return;
			}
			
			for (int i=0; i<n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					list.add(nums[i]);
					
					if (x==0) { //시작하자마자 연산자부터 담으면 안 되니까 x+1 해서 재귀 ㄱㄱ 
						dfs(x+1, a, b); 
					}
					else {
						ops[x] = 1; //1이면 덧셈 실행 
						dfs(x+1, a+1, b);
						ops[x] = 2; //2면 곱셈 실행 
						dfs(x+1, a, b+1); 
						ops[x] = 0; //ops 초기화 
					}
					list.remove(x);
					visited[i] = false; 	
				}
			}
			
		}
	}
	
	static int calc() {
		List<Integer> templist = new ArrayList<>();
		int temp = list.get(0);
		
		for (int i=1; i<n; i++) {
			if (ops[i]==1) temp += list.get(i);
			if (ops[i]==2) {
				templist.add(temp);
				temp = list.get(i);
			}	
		}
		templist.add(temp);
		temp = 1; 
		for (int i=0; i<templist.size(); i++) {
			temp *= templist.get(i);
		}
		return temp;
		
	}
	
}
