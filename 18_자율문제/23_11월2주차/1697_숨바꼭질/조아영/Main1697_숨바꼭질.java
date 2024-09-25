import java.util.*;

public class Main1697_숨바꼭질 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //수빈이 위치(시작점)
		int k = sc.nextInt(); //동생 위치(목적지)
		if (n==k) {
			System.out.println(0); //시작점=목적지인 경우 
			return;
		}
		
		boolean[] visited = new boolean[100001]; //방문쳌 배열 
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n); //시작점 큐에 넣음 
		int count = 0; //몇초만에 갈 수 있는지 체크 
		
		while (true) { //BFS가 count를 구하기 쉽다  
			count++;
			int size = q.size(); 
			for (int i=0; i<size; i++) {
				int x = q.poll(); //큐에 있는 거 꺼내 
				visited[x] = true; //방문쳌 
				
				if (x-1==k || x+1==k || x*2==k) { //목적지 도착하면 
					System.out.println(count); //걸린 시간 출력하고 리턴 
					return;
				}
				
				//현재 위치 x에서 갈 수 있는 곳은 x-1, x+1, x*2 
				
				if (x-1>=0 && !visited[x-1]) {
					visited[x-1]=true;
					q.add(x-1);
				}
				if (x+1<=100000 && !visited[x+1]) {
					visited[x+1]=true;
					q.add(x+1);
				}
				if (x*2<=100000 && !visited[x*2]) {
					visited[x*2]=true;
					q.add(x*2);
				}
			}
			
		}
		
	}


}
