package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1766 {
    public static void main(String[] args) throws IOException {
        // 위상정렬 , 우선순위 큐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] degree = new int[N+1];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            list[first].add(last);
            degree[last]++;
        }

        for(int i=1; i<N+1; i++) if(degree[i]==0) q.offer(i);

        while(!q.isEmpty()){
            int curr = q.poll();
            sb.append(curr).append(" ");
            for(int i=0; i<list[curr].size(); i++){
                int idx = list[curr].get(i);
                degree[idx]--;
                if(degree[idx]==0) q.offer(idx);
            }
        }

        System.out.println(sb.toString());

    }
}
