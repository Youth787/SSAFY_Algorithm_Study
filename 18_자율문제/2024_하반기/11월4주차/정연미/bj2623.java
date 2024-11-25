package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2623 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] degree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<N+1; i++) list[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            for(int j=0; j<s-1; j++){
                int num = Integer.parseInt(st.nextToken());
                list[first].add(num);
                degree[num]++;
                first = num;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<N+1; i++) if(degree[i]==0) pq.offer(i);
        ArrayList<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            result.add(curr);
            for(int i=0; i<list[curr].size(); i++){
                int check = list[curr].get(i);
                degree[check]--;
                if(degree[check]==0) pq.offer(check);
            }
        }

        if(result.size()!=N) System.out.println(0);
        else{
            for(int i=0; i<N; i++)
                System.out.println(result.get(i));
        }
    }
}
