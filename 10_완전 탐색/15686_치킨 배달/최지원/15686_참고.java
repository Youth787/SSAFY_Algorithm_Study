//package p15686_치킨배달;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//[문제]n*n 도시에서 최대 M개 치킨집을 고르고, 나머지 치킨집은 모두 없앨 때 도시의 치킨 거리 최소값을 구하는 프로그램
//치킨 거리 = 집과 가장 가까운 치킨집 사이의 거리=|r1-r2| + |c1-c2|. 도시의 치킨 거리 = 모든 집의 치킨 거리의 합
//[입력] n, m / n개의 줄에 도시 정보( 비었거나(0), 집이거나(1), 치킨집이거나(2))
//집은 1~(2n-1)개. 치킨집은 m<= <=13


//class 따로 만들어줘서 이 값을 ArrayList 안에 넣겠다
class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Point> person;
    static ArrayList<Point> chicken;
    static int ans;
    static boolean[] open;//방문처리
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());//도시 크기
        M = Integer.parseInt(st.nextToken());//최대로 남길 치킨집 수
 
        map = new int[N][N];//도시정보	
        person = new ArrayList<>();//집 좌표
        chicken = new ArrayList<>();//치킨집 좌표
 
        // 미리 집과 치킨집에 해당하는 좌표를 ArrayList에 넣어 둠.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
 
                if (map[i][j] == 1) {
                    person.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
 
        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];
 
        DFS(0, 0);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }//main

  
 	//인자로 cnt = 고른 치킨집 cnt. m개의 치킨집을 골랐을 때인지 보려고.
    public static void DFS(int start, int cnt) {
      //m개의 치킨집을 다 고른 상황에, 모든 집에서의 거리 비교하고, 최소값이 나왔는지 확인함
        if (cnt == M) {
            int res = 0;

          //그 집에서 열려있는 치킨집과의 거리들을 다 구하면서, 최소값인 친구를..
            for (int i = 0; i < person.size(); i++) {
                int temp = Integer.MAX_VALUE;
 
                // 어떤 집과 치킨집 중 open한 치킨집의 모든 거리를 비교한다.
                // 그 중, 최소 거리를 구한다.
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(person.get(i).x - chicken.get(j).x)
                                + Math.abs(person.get(i).y - chicken.get(j).y);
 
                        temp = Math.min(temp, distance);
                    }
                }//다 돌면 이제 i집의 치킨 거리 가 구해짐.
                res += temp;//res에 여기까지의 거리합을 더함
            }//지금 경우에서의 "도시의 치킨 거리"(모든 집의 치킨거리를 다 더함)이 resTmp에 저장
            ans = Math.min(ans, res);//지금까지의 최소값과 지금 구한 값(resTmp)의 비교
            return;
        }
 
        // 백트래킹
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            DFS(i + 1, cnt + 1);//방문한 경우의 수
            open[i] = false;//방문안했다고 초기화
        }
    }
 
}//class
