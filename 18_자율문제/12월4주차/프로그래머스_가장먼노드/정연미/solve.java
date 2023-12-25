package Algo_스터디.Dec_4주차;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프로그래머스_가장먼노드_BFS {
        static int[] visit;
        static int depth=0;
        static List<Integer>[] list;

        public int solution(int n, int[][] edge) {
            int ans = 0;

            visit = new int[n+1];
            list = new ArrayList[n+1];
            for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
            for(int i=0; i<edge.length; i++){
                list[edge[i][0]].add(edge[i][1]);
                list[edge[i][1]].add(edge[i][0]);
            }

            BFS(1,1);

            for(int i=1; i<=n; i++){
                if(visit[i] == depth) ans+=1;
            }

            return ans;
        }

        public static void BFS(int idx, int cnt){
            Queue<Integer> q = new LinkedList<>();
            q.add(idx);
            q.add(cnt);
            visit[idx] = cnt;

            while(!q.isEmpty()){
                int node = q.poll();
                int c = q.poll();

                if(depth < c) depth = c;
                for(int i=0; i<list[node].size(); i++){
                    int curr = list[node].get(i);
                    if(visit[curr]!=0) continue;
                    visit[curr] = c+1;
                    q.add(curr);
                    q.add(c+1);
                }
            }
        }
    }
