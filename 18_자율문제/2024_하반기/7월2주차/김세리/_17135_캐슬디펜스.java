package _20240711;

import java.util.*;
import java.io.*;

public class _17135_캐슬디펜스 {
	static int N, M, D;
    static int[][] map;
    static List<int[]> enemies;
    static int maxKills = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        enemies = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 적의 위치도 저장한다
                if (map[i][j] == 1) {
                    enemies.add(new int[]{i, j});
                }
            }
        }

        int[] archers = new int[3];
        
        // combination을 이용해서 궁수 위치 선택
        comb(0, 0, archers);
        System.out.println(maxKills);
    }

    // 백트레킹을 사용하여 M개의 열 중 3개의 위치를 선택하는 모든 조합을 생성
    static void comb(int start, int depth, int[] archers) {
        if (depth == 3) {
            simulate(archers);
            return;
        }
        
        // 0부터 시작해서 M번째 열까지 중에 3군데의 열에 궁수가 위치하게 되고,
     	// 이걸 재귀함수를 이용해서 archers배열에 그 위치를 넣고,
     	// 각 위치마다 simulate 함수를 실행하여 각각의 경우의 결과를 모두 구한다.
        for (int i = start; i < M; i++) {
            archers[depth] = i;
            comb(i + 1, depth + 1, archers);
        }
    }

    static void simulate(int[] archers) {
        int kills = 0;
        // 적 위치 복사본을 만든다
        List<int[]> tempEnemies = new ArrayList<>();
        for (int[] enemy : enemies) {
            tempEnemies.add(new int[]{enemy[0], enemy[1]});
        }
        // 적이 모두 제거될 때까지 시뮬레이션 계속
        while (!tempEnemies.isEmpty()) {
        	// 궁수들이 공격할 적의 위치 저장
        	// 이때 같은 적을 공격한다면 같은 위치이므로 저장이 반복되지 않는다.
        	// 그래서 set을 이용
            Set<int[]> targets = new HashSet<>();
            
            // 궁수마다 타겟을 고르고 targets에 저장
            for (int archer : archers) {
                int[] target = null;
                int minDist = Integer.MAX_VALUE;
                for (int[] enemy : tempEnemies) {
                    int dist = distance(enemy[0], enemy[1], N, archer);
                    
                    // 공격 거리가 D이하인 조건 만족할 경우에만 계산
                    if (dist <= D) {
                    	// 가장 가까운 적이 target이 되고,
                    	// 가장 가까운 거리에 있는 적이 여럿일 경우 왼쪽에 있는 적을 우선 선택
                        if (dist < minDist || (dist == minDist && enemy[1] < (target == null ? Integer.MAX_VALUE : target[1]))) {
                            minDist = dist;
                            target = enemy;
                        }
                    }
                }
                // 고른 target을 targets에 저장
                if (target != null) {
                    targets.add(target);
                }
            }
            
            // targets의 크기만큼 적이 제거된다
            kills += targets.size();
            // 제거된 적은 tempEnemies 리스트에서 제거한다
            tempEnemies.removeAll(targets);
            
            // 적의 이동을 반영하기 위한 movedEnemies를 만들고,
            // tempEnemies를 이동시켜서 movedEnemies에 추가한다
            List<int[]> movedEnemies = new ArrayList<>();
            for (int[] enemy : tempEnemies) {
                if (enemy[0] + 1 < N) {
                    movedEnemies.add(new int[]{enemy[0] + 1, enemy[1]});
                }
            }
            // 그리고 이렇게 이동이 반영된 적의 리스트를 tempEnemies로 업데이트 한다
            // 이런식으로 계속 반복해서 결국 tempEnemies 리스트가 비게 되면 while문이 종료된다
            tempEnemies = movedEnemies;
        }
        // 구해진 kills값 중에서 가장 최대값을 구해야 하므로
        // 경우의 수가 끝날 때마다 더 큰 값으로
        // maxKills를 업데이트 해준다
        maxKills = Math.max(maxKills, kills);
    }

    static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
