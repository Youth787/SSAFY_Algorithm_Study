import java.util.*;
import java.io.*;

class Solution {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static long[] weight;
    static int N;
    static long answer;
    public long solution(int[] a, int[][] edges) {
        N = a.length;
        visited = new boolean[N];
        weight = new long[N];
        tree = new ArrayList<>();
        long sum =0;
      // static 으로 만든건 한번 초기화 해주고 써야 오류가 안난다
        tree.clear();
        for(int i=0;i<N;i++){
            tree.add(new ArrayList<>());
            sum += a[i];
            weight[i] = a[i];
        }
        if(sum!=0) return -1;
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        answer = 0;
      // 시작점을 edges[0][0]으로 해야 다 연결된 노드부터 시작할 수 있다
        dfs(edges[0][0],weight);
        return answer;
    }
    static long dfs(int curr, long[] weight){
        visited[curr]=true;
        for(int next:tree.get(curr)){
            if(!visited[next]){
                long tmp = dfs(next,weight);
                weight[curr] += tmp;
                answer += Math.abs(tmp);
            }
        }
        return weight[curr];
    }
}
