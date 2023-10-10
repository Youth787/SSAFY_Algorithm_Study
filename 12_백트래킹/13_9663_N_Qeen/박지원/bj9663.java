import java.util.Scanner;

//체스판은 2차원배열인데 풀이는 1차원배열로 쌉가능
//왜냐하면 이 퀸은 한 줄당 한개씩만 들어가야 하기 때문이지
//그렇다면 재귀함수에서 depth번 행에 i번 열의 값을 넣는다고 생각하면 편하다.
//dfs함수에 어떤 인자를 들고가는지, 어떻게 백트래킹해줄지 고민을 많이 해봐야한다고 생각했음
public class bj9663 {

	static int n, ans;
	static int[] arr;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ans = 0; // 총 정답 변수
		arr = new int[n]; // 재귀함수 돌릴 배열!
		
		dfs(0);
	
		System.out.println(ans);
	
	
	}
	static void dfs(int depth) { 
		if (depth == n) {
			ans++;
			return;
		}
		for (int i = 0; i < n; i++) { // depth번째 행에 i번 열의 값을 넣는다!!!!(불린함수 생각하면 이해가 수월)
			arr[depth] = i;
			if (possible(depth))
				dfs(depth + 1);
		}
		
	}
	
	static boolean possible(int col) { // 행은 할필요없음 dfs안에 for문에서 애초에 행을 체크해주기 때문.
		for (int i = 0; i < col; i++) { 
			if (arr[i] == arr[col]) { // 열에 일치하는게 있는지 확인!
				return false;
			} else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) { // 대각선에 있는지 확인!
				return false;
			}
			
		}
		return true;
	}

}

//참조블로그
//https://infodon.tistory.com/61
