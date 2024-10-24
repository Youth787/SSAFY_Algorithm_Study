package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class bj2252 {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");

        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        int[] edge = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=N+1; i++) list.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            String[] temp = br.readLine().split(" ");
            list.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
            edge[Integer.parseInt(temp[1])]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<edge.length; i++) if(edge[i]==0) q.add(i);

        while(!q.isEmpty()){
            int curr = q.poll();
            bw.write(String.valueOf(curr)+" ");

            List<Integer> graph = list.get(curr);
            for(int i=0; i<graph.size(); i++){
                int temp = graph.get(i);
                edge[temp]--;
                if(edge[temp]==0) q.add(temp);
            }
        }

        bw.flush(); // 출력
    }
}
