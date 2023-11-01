import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11123 {
	
	static int h, w, count;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	h = Integer.parseInt(st.nextToken());
        	w = Integer.parseInt(st.nextToken());
        	map = new char[h][w];
        	count = 0;
        	visited = new boolean[h][w];
        	for (int i = 0; i < h; i++) {
        		String str = br.readLine();
        		for (int j = 0; j < w; j++) {
        			map[i][j] = str.charAt(j);
        		}	
        	}
        	// 입력 끝
        	// 0,0부터 h-1, w-1까지 배열 돌면서 bfs돌거야
        	for (int i = 0; i < h; i++) {
        		for (int j = 0; j < w; j++) {
        			if (!visited[i][j] && map[i][j] == '#') { // 방문하지않았는데 양이라고?! 바로 bfs들어가
        				bfs(i, j);
        				count++; // bfs끝났다는 의미는 한 무리의 양을 처리했단 뜻이니 count올려주기
        			}
        		}
        	}
        	System.out.println(count);
        }
        
    }
    //bfs할때 어떤걸 인자로 들고갈지 더 고민해봐야 좋을거같음
    static void bfs(int x, int y) { //여기서는 x,y좌표만 가지고가기
    	Queue<int[]> q = new LinkedList<>(); // q를 정수형 배열로 선언을 하고 들어온 인자를 넣어준다.
    	q.offer(new int[] {x, y});
    	visited[x][y] = true; // 방문처리
    	while (!q.isEmpty()) { // q가 빌때까지 돌릴거야
    		int[] now = q.poll(); // 현재위치를 now로 받고
    		for (int i = 0; i < 4; i++) { // 상 우 하 좌 순으로 쭉쭊쭉 돌면서 q에 다음 갈곳들을 쫙쫙 넣어줄거야
    			int movex = now[0] + dx[i];
    			int movey = now[1] + dy[i];
    			if (movey >= 0 && movex >= 0 && movex < h && movey < w && !visited[movex][movey] && map[movex][movey] == '#') {
    				q.offer(new int[] {movex, movey});
    				visited[movex][movey] = true; // 방문처리
    			}
    		}
    	}
    }
    
}

//https://bacchus-lover.tistory.com/m/286
