package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 캐슬디펜스 {
    static List<int[]> targets;
    static int result = Integer.MIN_VALUE;
    static int N, M, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        targets = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input==1){
                    targets.add(new int[]{i,j});
                }
            }
        }

       int[] arrows = new int[3];
        Combination(0,0,arrows);
        System.out.println(result);
    }
    public static void Combination(int start, int sidx, int[] arrows){
        if(sidx ==3 ){
            startgame(arrows);
            return;
        }

        for(int i=start; i<M; i++){
            arrows[sidx] = i;
            Combination(i+1,sidx+1,arrows);
        }
    }

    public static void startgame(int[] arrows){
        int kills =0;
        List<int[]> enemies = new ArrayList<>(targets);

        while(!enemies.isEmpty()) {
            Set<int[]> killed_enemy = new HashSet<>(); // 중복허용하지 않음
            for (int a : arrows) {
                int[] curr_target = null;
                int minDist = Integer.MAX_VALUE;
                for (int[] enemy : enemies) {
                    int dist = distcheck(enemy[0], enemy[1], N, a);
                    if(dist<=D){
                        if(dist<minDist || (dist ==minDist && enemy[1] < (curr_target==null?Integer.MAX_VALUE : curr_target[1]))){
                            minDist = dist;
                            curr_target = enemy;
                        }
                    }
                }
                if(curr_target !=null)
                     killed_enemy.add(curr_target);
            }

            kills += killed_enemy.size();
            enemies.removeAll(killed_enemy);

            List<int[]> copyenemies = new ArrayList<>();
            for(int[] one : enemies){
                if(one[0]+1<N)
                    copyenemies.add(new int[]{one[0]+1, one[1]});
            }
            enemies = copyenemies;
        }
        result = Math.max(result, kills);
    }
    public static int distcheck(int i , int j, int N, int a){
        return Math.abs(i-N) + Math.abs(j-a);
    }
}
