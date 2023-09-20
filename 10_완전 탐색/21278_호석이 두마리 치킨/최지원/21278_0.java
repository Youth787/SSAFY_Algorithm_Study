//풀이 방식 정리&공부 中...

//1번 : https://ws-pace.tistory.com/54
//2번 https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8-java
//3번 https://c-king.tistory.com/465
//4번 https://coder-in-war.tistory.com/entry/BOJ-JAVA21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8
//5번 https://subin-programming.tistory.com/297
//6번 https://velog.io/@dlsrjsdl6505/%EB%B0%B1%EC%A4%80-21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8-%EC%9E%90%EB%B0%94
//7번  https://passionfruit200.tistory.com/435

//----------------

//1번 : https://ws-pace.tistory.com/54
import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 10000001;
    static int N, M, Min = INF, I, J;
    static int[][] time;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(time[i], INF);
            time[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            time[u][v] = 1;
            time[v][u] = 1;
        }

        floyd();

        // nC2
        boolean[] visited = new boolean[N + 1];
        int[] selected = new int[2];
        Arrays.fill(visited, false);
        comb(1, 0, 2, visited, selected);

        System.out.println(I + " " + J + " " + Min);
    }

    private static void comb(int start, int select, int max, boolean[] visited, int[] selected) {
        if (select == max) {

            int sum = 0;
            for (int i = 1; i < N + 1; i++) {
               if (visited[i]) continue;
                int min = INF;
                for (int k : selected)
                    min = Math.min(time[i][k], min);
                sum += min * 2;
            }

            if (Min > sum) {
                Min = sum;
                I = selected[0];
                J = selected[1];
            }
            return;
        }

        for (int i = start; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[select] = i;
                comb(i + 1, select + 1, max, visited, selected);
                visited[i] = false;
            }
        }
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (time[i][j] > time[i][k] + time[k][j]) {
                        time[i][j] = time[i][k] + time[k][j];
                    }
                }
            }
        }
    }
}

//2번 https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8-java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INF = 100007;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = initMap(n, m);

        floydWarshall(n, map);

        System.out.println(answer(n, map));
    }

    private int[][] initMap(final int n, int m) throws IOException {
        int[][] map = new int[n][n];
        for (int[] row : map)
            Arrays.fill(row, INF);

        while (m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            map[a][b] = map[b][a] = 1;
        }

        return map;
    }

    private void floydWarshall(final int n, int[][] map) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    map[i][j] = map[j][i] = min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    private String answer(final int n, final int[][] map) {
        int min = INF;
        int ansA = 0;
        int ansB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                int sum = 0;
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) continue;

                    sum += min(map[i][k], map[j][k]);
                }

                if (min > sum) {
                    min = sum;
                    ansA = i;
                    ansB = j;
                }

            }
        }

        return String.format("%d %d %d", ansA+1, ansB+1, min*2);
    }
}

//3번 https://c-king.tistory.com/465

package bfs_dfs;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BOJ21278 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static ArrayList<Integer> A[];
    static int select[] = new int[2];
    static int ans = Integer.MAX_VALUE;
    static int build1, build2;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
 
    static void pro() {
        dfs(1, 0);
 
        ans = ans * 2; //왕복
 
        System.out.println(build1 + " " + build2 + " " + ans);
    }
 
    static void dfs(int start, int cnt) {
        if(cnt == 2){
            bfs();
            return;
        }
 
        for (int i = start; i <= N; i++) {
 
            select[cnt] = i;
            dfs(i + 1, cnt + 1);
        }
    }
 
    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(select[0]);
        q.offer(select[1]);
 
        int dist[] = new int[N + 1];
        boolean visit[] = new boolean[N + 1];
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        dist[select[0]] = 0;
        dist[select[1]] = 0;
 
        while (!q.isEmpty()) {
            int x = q.poll();
 
            for (int k : A[x]) {
                if(dist[k] > dist[x] + 1) dist[k] = dist[x] + 1;
                if(visit[k]) continue;
                q.offer(k);
                visit[k] = true;
            }
        }
        int sum = 0;
 
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }
 
        //여기서 같다라고 하지 않은 이유는
        //문제에서 건물 번호가 낮을 수록 좋다고 함.
        //어차피 조합에서 건물 낮은 얘들부터 뽑히니까 그런거임
        if(ans > sum){
            ans = sum;
            build1 = select[0];
            build2 = select[1];
        }
    }
 
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
 
        A = new ArrayList[N + 1];
 
        for (int i = 0; i <= N; i++) A[i] = new ArrayList<>();
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = atoi(st.nextToken());
            int e = atoi(st.nextToken());
 
            A[s].add(e);
            A[e].add(s);
        }
    }
}

//4번 https://coder-in-war.tistory.com/entry/BOJ-JAVA21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8
//4-1
import java.io.*;
import java.util.*;

public class p21278 {
    static int n, m, min = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] dist;
    static int[] place;
    static boolean[] visited;
    static int[] minPlace = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        place = new int[2];
        visited = new boolean[n + 1];
        map = new int[n + 1][n + 1];
        // 각 도시간의 거리를 계산하기 위해 초기화
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++) {
                if (i == j) continue;
                map[i][j] = n;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u][v] = 1;
            map[v][u] = 1;
        }

        // 플로이드 와샬 알고리즘을 통해 최단거리 셋팅
        floyd_warshall();

        solution(1, 0);
        System.out.println(minPlace[0]+" "+minPlace[1]+" "+min);
    }

    static void floyd_warshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    static void solution(int start, int depth) {
        if (depth == 2) {
            int sum = 0;
            // 치킨집이 아닌 건물에서 가장 가까운 치킨집까지의 최단거리들을 더하자.
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    int mmin = Integer.MAX_VALUE;
                    for (int j = 0; j < 2; j++) {
                        mmin = Math.min(map[i][place[j]], mmin);
                    }
                    sum += mmin * 2;
                }
            }
            if (min > sum) {
                for (int j = 0; j < 2; j++) {
                    minPlace[j] = place[j];
                }
                min = sum;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            place[depth] = i;
            solution(i, depth + 1);
            visited[i] = false;
        }
    }
}
//4-2
import java.util.*;
import java.io.*;
public class Main {

    public static int N, M, adj[][], dist[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N+1][N+1];
        dist = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = adj[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) continue;

                if(adj[i][j]!=0) dist[i][j] = adj[i][j];
                else dist[i][j] = 1000000;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                int tmp = solve(i, j);
                if(sum > tmp) {
                    ans1 = i; ans2 = j;
                    sum = tmp;
                }
            }
        }

        System.out.printf("%d %d %d", ans1, ans2, sum*2);
    }

    public static int solve(int i, int j) {
        int distance = 0;
        for (int k = 1; k <= N; k++) {
            distance += Math.min(dist[i][k], dist[j][k]);
        }
        return distance;
    }
}

//5번 https://subin-programming.tistory.com/297

import java.util.*;

public class BaekJoon_21278 {
	static int n,m;
	static final int INF=(int)1e9;
	static int[][] map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		map=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j)
					continue;
				
				map[i][j]=INF;
			}
		}
		
		// 간선 정보 입력 받기
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			map[a][b]=map[b][a]=1;
		}
		
		// 플로이드 와샬 알고리즘
		for(int k=1;k<=n;k++) 
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
	
		int point1=Integer.MAX_VALUE;
		int point2=Integer.MAX_VALUE;
		int min=Integer.MAX_VALUE;
		
		for(int i=1;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				// 2개의 지점을 치킨집으로 선정
				int dis=distance(i,j);
				// 더 작은 값을 찾으면 치킨집 장소와 최솟값 갱신
				if(min>dis) {
					point1=i;
					point2=j;
					min=dis;
				}
			}
		}
		
		// 왕복 거리이기 때문에 min*2 한 값을 출력
		System.out.println(point1+" "+point2+" "+min*2);
	}
	
	/*
	 * 모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단 시간의 총합을 구하는 문제이기 때문에
	 * 두 치킨집 중 더 가까운 치킨집까지의 거리를 구해 return 한다. 
	 */
	static int distance(int x, int y) {
		int result=0;
		for(int i=1;i<=n;i++)
			result+=Math.min(map[x][i],map[y][i]);
		
		return result;
	}
}

//6번 https://velog.io/@dlsrjsdl6505/%EB%B0%B1%EC%A4%80-21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8-%EC%9E%90%EB%B0%94

import java.io.*;
import java.util.*;
public class Main {
    static int[][] floyd;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        floyd = new int[N][N];
        
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                floyd[i][j] = 101; //점의 최대 개수는 100개이므로, 점과 점은 아무리 멀어도 거리 99가 최대임.
                //즉, 거리 101로 해주는 것은 다익스트라의 Integer.MAX_VALUE와 같음.
            }
        }
        //존재하는 길이 없다. 를 101 로 표현.
        //있으면, 거리는 전부 1이니 해당 값 넣기
        
        for(int i = 0 ; i < M ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            floyd[a-1][b-1] = 1;
            floyd[b-1][a-1] = 1;
        }
        //초깃값.

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(i == j) continue;
                for(int k = 0 ; k < N ; k++) {
                    if(i == k || j == k) continue;
                    
                    if(floyd[j][k] > floyd[j][i] + floyd[i][k]) floyd[j][k] = floyd[j][i] + floyd[i][k];
                    
                }
            }
        }
        
        //플로이드 워셜로 각 점에서 각 점까지의 거리의 최솟값 다 채운 후
        //플로이드 워셜 로직 = a->c로 가는 값보다 b를 거쳐 a->b + b->c 값이 더 작다면 작은 값을 택하는 알고리즘.
        
        int min = Integer.MAX_VALUE;
        int n1 = 0;
        int n2 = 0;

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(i == j) continue;
                //두 점을 고른다. (1, 2부터 N-1, N까지)

                int now = sum(i, j);
                //고른 두 점을 기준으로 각각의 점의 거리의 최솟값을 더해나간다.
                //1, 2를 골랐으면
                //sum(1, 2) = 그 둘(1, 2)에서 3까지의 거리의 최솟값 + ... + 그 둘(1, 2)에서 N 까지의 거리의 최솟값

                if(min > now) {
                    n1 = i+1;
                    n2 = j+1;
                    min = now;
                }
                //해당 값이 최솟값이 된다면 두 점을 기록해놓는다.

            }
        }

        //기록한 두 점과 최솟값을 출력한다.
        bw.write(String.valueOf(n1) + " " + String.valueOf(n2) + " " + String.valueOf(min*2)); //min*2는 왕복이라서.
        bw.flush();
        bw.close();


    }

    static int sum(int n1, int n2) {
        int sum = 0;
        for(int i = 0 ; i < N ; i++) {
            if(i == n1 || i == n2) continue;
            sum += Math.min(floyd[n1][i], floyd[n2][i]);
        }
        return sum;
    }
}
//추가 : 플로이드 워셜 https://www.youtube.com/watch?v=9574GHxCbKc&t=532s

//7번  https://passionfruit200.tistory.com/435

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	public static int N, M;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	public static boolean[] visited;
	public static boolean[] counted;
	public static int resultFirstIdx = 0;
	public static int resultSecondIdx = 0;
	public static int answer = Integer.MAX_VALUE;
	
	 
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	for(int i=0;i<=N;i++) {
    		graph.add(new ArrayList<>());
    	}
    	visited = new boolean[N+1];
    	
		for(int j=0;j<M;j++) {
			st = new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			graph.get(nodeA).add(new Node(nodeA, nodeB, 0));
			graph.get(nodeB).add(new Node(nodeB, nodeA, 0));
		}
    	simulate(1, 0);
    	
    	System.out.println(resultFirstIdx+" "+resultSecondIdx+ " "+answer*2);
    }
    
    public static void simulate(int idx, int level) {
    	if(level == 2) {
    		counted = new boolean[N+1];
    		Queue<Node> q = new LinkedList<>();
    		int result = 0;
    		for(int i=1;i<=N;i++) {
    			if(visited[i] == true) {
    				q.offer(new Node(i, 0, 0));
    				counted[i] = true;
    			}
    		}
    		
    		
    		while(!q.isEmpty()) {
    			Node temp = q.poll();
    			int nodeA = temp.nodeA;
    			int cnt = temp.count;
    			
    			for(int i=0;i<graph.get(nodeA).size();i++) {
    				if(counted[graph.get(nodeA).get(i).nodeB] == false ) {
    					q.offer(new Node(graph.get(nodeA).get(i).nodeB, 0, cnt + 1));
    					counted[graph.get(nodeA).get(i).nodeB]= true;
    					result += cnt + 1;
    				}
    			}
    		}
    		
    		if(answer > result) {
    			answer = result;
    			resultFirstIdx = 0;
    			resultSecondIdx = 0;
        		for(int i=1;i<=N;i++) {
        			if(visited[i] == true) {
        				if( resultFirstIdx == 0 ) {
        					resultFirstIdx = i;
        				}else {
        					resultSecondIdx = i;
        				}
        				
        			}
        		}
    		}
    		return ;
    		
    	}
    	for(int i=idx;i<=N;i++) {
    		
    		if(visited[i] == true) continue;
    		visited[i] = true;
    		simulate(i + 1, level + 1);
    		visited[i] = false;
    	}
    }
    
    
}

class Node{
	int nodeA;
	int nodeB;
	int count = 0;
	public Node(int nodeA, int nodeB, int cnt) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.count = cnt;
	}
}
