package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class college{
    int p, d;
    public college(int p, int d){
        this.p=p;
        this.d=d;
    }
}

public class bj2109 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<college> pq = new PriorityQueue<>((a,b)->{
            if(a.p==b.p) return a.d-b.d;
            return b.p-a.p;
        });

        int maxdate = 0;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            maxdate = Math.max(D,maxdate);
            pq.add(new college(P,D));
        }

        boolean[] visit = new boolean[maxdate+1];
        int result =0;
        while(!pq.isEmpty()){
            college curr = pq.poll();
            out: for (int i = curr.d; i >=1; i--) {
                if (!visit[i]) {
                    visit[i] = true;
                    result += curr.p;
                    break out;
                }
            }
        }

        System.out.println(result);
    }
}
