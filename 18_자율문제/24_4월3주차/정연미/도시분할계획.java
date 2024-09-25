package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 크루스칼 알고리즘
// 입력을 받아서 전체적으로 최소 스패닝 트리를 구하고
// 가장 큰 숫자 하나를 끊어서 두영역으로 나눈다.

public class 도시분할계획 {
    static int[] p; // 부모를 저장할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] edges = new int[M][3];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, (o1,o2)->(o1[2]-o2[2])); // 오름차순

        p = new int[N+1];
        for(int i=1; i<=N; i++){
            p[i] = i;
        }

        int cost = 0;
        int pick =0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<M; i++){
            int px = findset(edges[i][0]);
            int py = findset(edges[i][1]);

            if(px != py){ // 사이클이 형성이 안되는 경우
                union(px,py);
                cost += edges[i][2];
                pick++;
                if(max<edges[i][2]) max = edges[i][2];
            }

            if(pick == N-1) break;
        }

        System.out.println(cost-max);
    }

    public static void union(int x, int y){
        p[findset(y)] = findset(x);
    }

    public static int findset(int x){
        if(x!=p[x]){
            p[x] = findset(p[x]);
        }
        return p[x];
    }
}
