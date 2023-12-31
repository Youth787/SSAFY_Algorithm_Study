//풀이 방식 정리&공부 中...

//1번 : https://ws-pace.tistory.com/54
//2번 https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8-java
//3번 https://c-king.tistory.com/465
//4번 https://coder-in-war.tistory.com/entry/BOJ-JAVA21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8
//5번 https://subin-programming.tistory.com/297
//6번 https://velog.io/@dlsrjsdl6505/%EB%B0%B1%EC%A4%80-21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8-%EC%9E%90%EB%B0%94
//7번  https://passionfruit200.tistory.com/435

//대부분 따로 빼서 풀긴 했지만 3개 이하로 : 1번(line 17~), 4-1,2번(line 307~), 5번 (line 458~), 6번(line 532~), 7번(line 625~)
//메소드 따로 다 빼서 푼 코드들 : 2번(line 114~), 3번(line 201~, ArrayDeque 사용)


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

        N = Integer.parseInt(st.nextToken());//건물 수(여기서 접근성 높은 2곳을 골라서 치킨집 오픈)
        M = Integer.parseInt(st.nextToken());//도로 수(도로는 'a와 b 사이에 1시간짜리 도로가 있다' 식으로 주어짐)
        time = new int[N + 1][N + 1];//건물끼리의 최소 이동 시간 저장하는 2차원 배열
        for (int i = 1; i <= N; i++) { //건물 1번부터 n번까지
            Arrays.fill(time[i], INF);//최소 이동 시간 저장해야 하니까 int 최대값으로 초기화
            time[i][i] = 0;//본인이랑은 거리 없으니까 0으로 저장
        }

	//입력된 도로 정보를 통해 time에 시간 저장
        for (int i = 0; i < M; i++) {//m개의 도로 정보
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());//건물1
            int v = Integer.parseInt(st.nextToken());//건물2
            time[u][v] = 1;//둘 사이에는 1시간 거리의 도로 있다
            time[v][u] = 1;//반대로 이동할때도 마찬가지
        }

        floyd();//나머지 time 배열 내 값을 저장하는 과정

        // nC2 : 건물 n개 중 2개를 고른다
        boolean[] visited = new boolean[N + 1]; //방문 처리 배열
        int[] selected = new int[2]; //치킨집 후보 건물 2개의 번호를 저장하는 배열
        Arrays.fill(visited, false); //? 이미 false로 초기화되어있지 않나
        comb(1, 0, 2, visited, selected);//건물 1부터 시작하여, 아직 후보로 고른 건물이 0개고, (이건 필요없을듯?)우리가 골라야 하는 건물은 총 2개고, 방문처리했던 배열 갖고 다니면서, 후보 저장한 배열고 갖고 다님

        System.out.println(I + " " + J + " " + Min);
    }

    private static void comb(int start, int select, int max, boolean[] visited, int[] selected) {
        if (select == max) { //만약 후보를 다 골랐다면(그냥 select == 2라고 해도?)
            int sum = 0;//왕복 시간을 저장하는 변수
            for (int i = 1; i < N + 1; i++) { //1번~n번 건물을 돌면서
               if (visited[i]) continue; //방문했으면 이전 반복문에서 계산했었으니까 넘어가
                int min = INF; //어떤 치킨집이 더 가까운지를 판단하려는 변수. 치킨집까지의 편도 이동 시간 계산
                for (int k : selected) //치킨집 후보들와 건물i의 이동 시간 중
                    min = Math.min(time[i][k], min);//더 작은 거 선택해서 저장하고
                sum += min * 2;//왕복시간 계산이니까 *2해서 지금까지 방문한 건물의 왕복 이동 시간 저장
            }

            if (Min > sum) {//지금 구한 값이 더 작으면 최소값 갱신
                Min = sum;
                I = selected[0];//지금 후보들이 정식 등록됨
                J = selected[1];
            }
            return;
        }

        for (int i = start; i < N + 1; i++) {
            if (!visited[i]) {//i가 아직 방문 안한 곳이었다면?
                visited[i] = true;//방문하자
                selected[select] = i;//후보에 올려
                comb(i + 1, select + 1, max, visited, selected);//다음 후보를 찾아 떠난다
                visited[i] = false;//위에서 방문처리 했던거 철수..
            }
        }//for
    }//comb

    private static void floyd() {
        for (int k = 1; k <= N; k++) { //경유지를 도는
            for (int i = 1; i <= N; i++) { //출발지를 도는
                for (int j = 1; j <= N; j++) { //도착지를 도는
                    if (time[i][j] > time[i][k] + time[k][j]) { // 다이렉트로 가는 방법이 > 경유지 들러서 가는 경우보다 크면
                        time[i][j] = time[i][k] + time[k][j]; //거기까지 가는 방법을 아예 경유지들러서 가는 시간으로 똑같이 맞춰 적음
                    }
                }
            }
        }
    }//floyd

/* 오늘 잠깐 흘러가듯 나온 "모든 정점들에 대한 최단 경로 = 플로이드-워샬(Floyd-Warshall) 알고리즘"
for (경유지를 도는 반복문)
    for (출발지를 도는 반복문)
    	for (도착지를 도는 반복문)

=음수 사이클이 없는 그래프 내의 각 모든 정점에서, 각 모든 정점에까지의 최단거리를 모두 구할 수 있는 알고리즘.
(다잌스트라와 다른점은 그래프에 음수 사이클<사이클 돌아서 원래 지점으로 왔을 때 최종 비용이 음수인 경우>만 존재하지 않으면, 음의 가중치를 갖는 간선이 존재해도 상관없다)
=인접 행렬을 이용하여 각 노드 간 최소 비용 계산. 
= 모든 노드에서, 모든 노드로 사는 최소 비용을 "단계적으로 갱신"하면서 진행

 디익스트라 = 시작 정점에서 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식. 음의 가중치 허용 안함
 */
}

//2번 https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-21278-%ED%98%B8%EC%84%9D%EC%9D%B4-%EB%91%90-%EB%A7%88%EB%A6%AC-%EC%B9%98%ED%82%A8-java
// 이 풀이는 너무 나눠나서 저는 오히려 보기 불편했슴다.. 대신 플로이드-워샬(Floyd-Warshall) 알고리즘

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

	//솔루션으로 왔어여
    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//건물 수
        int m = Integer.parseInt(st.nextToken());//도로 수

        int[][] map = initMap(n, m);//지도

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

	//플로이드-워샬(Floyd-Warshall) 알고리즘
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
        input();//입력받자
        pro();//
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
