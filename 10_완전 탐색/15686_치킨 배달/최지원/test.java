package p15686_치킨배달;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.MinimalHTMLWriter;

//[문제]n*n 도시에서 최대 M개 치킨집을 고르고, 나머지 치킨집은 모두 없앨 때 도시의 치킨 거리 최소값을 구하는 프로그램
//치킨 거리 = 집과 가장 가까운 치킨집 사이의 거리=|r1-r2| + |c1-c2|. 도시의 치킨 거리 = 모든 집의 치킨 거리의 합
//[입력] n, m / n개의 줄에 도시 정보( 비었거나(0), 집이거나(1), 치킨집이거나(2))
//집은 1~(2n-1)개. 치킨집은 m<= <=13
class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
} //*****이걸 밖에 안쓰고 main 안에 쓰면 오류 뜸*****

//DFS, 백트래킹
public class Main {

	static int n, m, ans;
	static int [][] city;
	static ArrayList<Point> home;
	static ArrayList<Point> store;
	static boolean [] visited; //방문처리
	
	//인자로 cnt = 고른 치킨집 cnt. m개의 치킨집을 골랐을 때인지 보려고.
	static void DFS(int cnt) {
		//기저 : m개의 치킨집을 다 고른 상황에, 모든 집에서의 거리 비교하고, 최소값이 나왔는지 확인함
		if (cnt == m) {
			//그 집에서 열려있는 치킨집과의 거리들을 다 구하면서, 최소값인 친구를 
			int resTmp = 0;
			
			for (int i = 0; i<home.size(); i++) {
				int minTmp = Integer.MAX_VALUE;//치킨집과의 최소 거리
				for (int j = 0; j< store.size(); j++) {//열려있는 모든 치킨집을 도는 for문
					if (visited[j]) { //거리 공식 = |r1-r2| + |c1-c2|
						int distTmp = Math.abs(home.get(i).x - store.get(j).x) + Math.abs(home.get(i).y - store.get(j).y) ;
						minTmp = Math.min(distTmp, minTmp); //j치킨집과 집의 거리와 지금까지의 최소값의 비교.
					}
				}//다 돌면 이제 i집의 치킨 거리 가 구해짐.
				resTmp += minTmp;
			}//지금 경우에서의 "도시의 치킨 거리"(모든 집의 치킨거리를 다 더함)이 resTmp에 저장
			ans = Math.min(ans, resTmp);//지금까지의 최소값과 지금 구한 값(resTmp)의 비교
			return; //다했으면 나가
		}
		
		//백트래킹 : 
		
		
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//도시 크기
		m = sc.nextInt();//최대로 남길 치킨집 수
		ans = Integer.MAX_VALUE;//최소값 구해야 하니 최대로 초기화
		
		city = new int[n][n]; //도시정보		
		home = new ArrayList<>();//집 좌표
		store = new ArrayList<>();//치킨집 좌표	

		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n ; j++) {
				city[i][j] = sc.nextInt();
				if (city[i][j] == 1) {
                    home.add(new Point(i, j));
                } else if (city[i][j] == 2) {
                    store.add(new Point(i, j));
                }
			}
		}//도시 정보( 비었거나(0), 집이거나(1), 치킨집이거나(2))
		
		visited = new boolean [store.size()];
		
		//완전 탐색
		//거리합 임시변수
		int tmp = 0;
		
		//지금 치킨집 ch개에서 m개만 뽑는다면? 
		
		
		
	}//main
}//class
