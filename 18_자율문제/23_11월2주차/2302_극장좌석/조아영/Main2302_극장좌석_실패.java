import java.util.Arrays;
import java.util.Scanner;

public class Main2302_극장좌석_실패 {
	
	static int n,m,cnt,ans;
	static int[] seat;
	static boolean[] visited; 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//좌석개수
		m = sc.nextInt();//고정석개수
		seat = new int[n+1];  //좌석 만들어둬 
		visited = new boolean[n+1];   
		for (int i=0; i<m; i++) {
			int vip = sc.nextInt();
			visited[vip] = true; //일단 븨앞들 고정석 체크 
		}
		dfs(1,0); //1번좌석부터 체크 
		System.out.println(ans);
	}
	
	//왜 안되는지 모르겠음 ㅜㅜ 
	static void dfs(int x, int cnt) { //x : 현재 손님의 원래 좌석 //cnt : 자리 몇개 뽑았니 
		
		if (cnt==n-m) { //븨앞빼고 나머지 다 뽑았으면 
			ans++; //정답+1
			return; //리턴
		}
		
		//x는 x-1,x,x+1 중 한 곳에 앉을 수 있어 
		if (x>=1 && x<=n && visited[x]) { //임자 있는 자리면 다음 좌석 확인 
			dfs(x+1,cnt); 
		}
		if (x>=1 && x<=n && !visited[x]) {
			visited[x]=true; 
			dfs(x+1,cnt+1);
			visited[x]=false;
		}
		if (x-1>=1 && x-1<=n && !visited[x-1]) {
			visited[x-1]=true; //방문쳌
			dfs(x,cnt+1);
			visited[x-1]=false;
		}			
		if (x+1>=1 && x+1<=n && !visited[x+1]) { 
			visited[x+1]=true; //방문쳌
			dfs(x+2,cnt+1);
			visited[x+1]=false;
		} 
		
	}
}
