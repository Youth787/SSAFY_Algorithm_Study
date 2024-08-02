package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class dot implements Comparable<dot>{
    int from, to, value;

    public dot(int from, int to, int value){
        this.from = from;
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(dot a){
        return this.value - a.value;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<dot>> line = new ArrayList<>();
        for(int i=0; i<=N; i++) line.add(new ArrayList<>());
        List<dot> result = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            line.get(A).add(new dot(A,B,C));
            line.get(B).add(new dot(B,A,C));
        }

        boolean[] visit = new boolean[N+1];
        int[] dist = new int[N+1];
        for(int i=1; i<=N; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<dot> q = new PriorityQueue<>();
        // 그냥 Queue를 사용하면 compareTo 적용 안됨.
        q.add(new dot(1,1,0));
        visit[1] = true;
        dist[1] = 0;

        while(!q.isEmpty()){
            dot curr = q.poll();

            if(!visit[curr.to]){
                visit[curr.to] = true;
                result.add(curr);
            }

            for(int i=0; i<line.get(curr.to).size(); i++){
                dot next = line.get(curr.to).get(i);
                if(dist[next.to]>dist[curr.to]+next.value){
                    dist[next.to] = dist[curr.to]+next.value;
                    q.add(new dot(next.from, next.to, dist[next.to]));
                }
            }
        }

        System.out.println(result.size());
        for(dot node : result)
            System.out.println(node.from+" "+node.to);
    }
}
