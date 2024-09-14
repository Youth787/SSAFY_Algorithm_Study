package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class bj16946 {
    static int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] map, result, group_map;
    static int N,M,cnt;

    static int num =1;
    static boolean[][] visit;
    static HashMap<Integer,Integer> hashmap = new HashMap<>(); // 그룹번호 / 그룹 수
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // 입력배열
        group_map = new int[N][M]; // 그룹 배열
        result = new int[N][M]; // 결과 출력 배열
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<M; j++)
                map[i][j] = Integer.parseInt(input[j]);
        } // 입력받기 완료

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0&& !visit[i][j]){
                    cnt=1;
                    DFS(i,j);
                    hashmap.put(num,cnt);
                    num++;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==1){
                    int sum =0;
                    set = new HashSet<>();
                    for(int k=0; k<4; k++){
                        int r = i+dir[k][0];
                        int c = j+dir[k][1];
                        if(r>=0&&c>=0&&r<N&&c<M&&group_map[r][c]!=0){
                            set.add(group_map[r][c]);
                        }
                    }
                     for(int a : set) sum+=hashmap.get(a);
                    result[i][j] = (sum+1)%10;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++)
                System.out.print(result[i][j]);
            System.out.println();
        } // 결과 출력

    }

    public static void DFS(int i, int j){
        visit[i][j] = true;
        group_map[i][j]  = num;
        for(int k=0; k<4; k++){
            int r = i+dir[k][0];
            int c = j+dir[k][1];
            if(r>=0&&c>=0&&r<N&&c<M&& !visit[r][c]&& map[r][c]==0) {
                cnt++;
                DFS(r,c);
            }
        }
    }

}
