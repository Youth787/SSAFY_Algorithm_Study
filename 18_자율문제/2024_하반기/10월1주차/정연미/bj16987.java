package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class egg{
    int in;
    int weight;
    public egg(int in, int weight){
        this.in=in;
        this.weight=weight;
    }
}

public class bj16987 {
    static int result=0;
    static int N;
    static List<egg> eggs;
    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        eggs = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs.add(new egg(in,weight));
        }

        backtrack(0);
        System.out.println(result);
    }
    public static void backtrack(int currentidx){
        if(currentidx==N){
            int broke =0;
            for(egg one :eggs) if(one.in<=0) broke++;
            result = Math.max(result, broke);
            return;
        }

        if(eggs.get(currentidx).in<=0){
            backtrack(currentidx+1);
            return;
        }

        boolean hit = false;
        for(int i=0; i<N; i++){
            if(i!=currentidx && eggs.get(i).in>0){
                hit = true;

                eggs.get(currentidx).in -= eggs.get(i).weight;
                eggs.get(i).in -= eggs.get(currentidx).weight;

                backtrack(currentidx+1);

                eggs.get(currentidx).in += eggs.get(i).weight;
                eggs.get(i).in += eggs.get(currentidx).weight;
            }
        }

        if(!hit) backtrack(currentidx+1);
    }
}
