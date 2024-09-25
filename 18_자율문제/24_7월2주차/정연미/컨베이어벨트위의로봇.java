package GOLD.구현;

import java.io.*;
import java.util.*;

public class 컨베이어벨트위의로봇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] belt = new int[N*2];
        boolean[] robots = new boolean[N];
        for(int i=0; i<N*2; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        // 단계
        int result = 1;

        while(true){
            // 1.  로봇과 함께 벨트가 이동한다.
            int temp = belt[2*N-1];
            for(int i=N*2-1; i>0;i--)
                belt[i] = belt[i-1];
            belt[0] = temp;

            // 로봇의 위치를 옮긴다.
            for(int i = N-1; i>0; i--)
                robots[i] = robots[i-1];
            robots[0] = false;

            // 내리는 위치에 로봇이 있으면 내린다.
            if(robots[N-1]) robots[N-1] =false;

            // 2. 벨트 회전 방향으로 앞의 로봇부터 이동할 수 있으면 이동
            // 로봇이 없거나, 내구도 1 이상이면 이동 가능
            // 이동했다면 내구도 1 감소
            for(int i = N-1; i>0; i--){
                if(robots[i-1] && !robots[i] && belt[i] >=1) {
                    robots[i-1] = false;
                    robots[i] = true;
                    belt[i] -= 1;
                }
            }

            // 내리는 위치에 로봇이 있으면 내린다.
            if(robots[N-1]) robots[N-1] =false;

            //올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if(belt[0] !=0) {
                robots[0] = true;
                belt[0]--;
            }

            //내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int cnt=0;
            for(int i=0; i<N*2; i++){
                if(belt[i]==0) cnt++;
            }
            if(cnt>=K) break;
            result++;
        }
        System.out.println(result);
    }
}
