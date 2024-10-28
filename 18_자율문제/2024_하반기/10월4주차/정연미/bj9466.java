package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class bj9466 {
    static int N;
    static int[] arr;
    static int count=0;
    static boolean[] visit, done;
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int testcase = 0; testcase<t; testcase++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N+1];
            visit = new boolean[N+1];
            done = new boolean[N+1];

            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i]==i){
                    done[i] = true;
                    count++;
                }
            }

            for(int i=1; i<=N; i++) if(!done[i]) dfs(i);
            bw.write((N-count)+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static void dfs(int idx){
        if(visit[idx]){
            done[idx] = true;
            count++;
        }else{
            visit[idx] = true;
        }

        if(!done[arr[idx]]){
            dfs(arr[idx]);
        }

        visit[idx] = false;
        done[idx] = true;
    }
}
