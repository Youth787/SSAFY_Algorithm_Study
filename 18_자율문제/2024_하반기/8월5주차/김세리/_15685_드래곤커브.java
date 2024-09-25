package _20240902;

import java.util.*;

public class _15685_드래곤커브 {
	// 격자의 최대 가능한 범위 설정
	static boolean[][] map = new boolean [101][101];
	// 드래곤 방향 순서대로 설정
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			
			drawDragonCurve(x,y,d,g);
		}
		
		System.out.println(countSquares());
	}
	
	private static void drawDragonCurve(int x, int y, int d, int g) {
		List<Integer> directions = new ArrayList<>();
		directions.add(d);
		
		// 첫 번째 세대부터 g세대까지 방향을 생성
        for (int i=0;i<g;i++) {
            int size = directions.size();
            for (int j=size-1;j>=0;j--) {
                directions.add((directions.get(j) + 1) % 4);
            }
        }

        // 드래곤 커브를 평면에 그리기
        map[x][y] = true;
        for (int dir : directions) {
            x += dx[dir];
            y += dy[dir];
            map[x][y] = true;
        }
    }

    private static int countSquares() {
        int count = 0;
        for (int i=0;i<100;i++) {
            for (int j=0;j<100;j++) {
                if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
                    count++;
                }
            }
        }
        return count;
    }
}
