package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1182 {
    static int[] arr;
    static int result =0;
    static int N,S;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        calc(0,0);
        if(S==0) result-=1;
        System.out.println(result);
    }
    public static void calc(int idx,int sum){
        if(idx == N) {
            if(sum==S) result++;
            // System.out.println(sum);
            return;
        }
        calc(idx+1,sum+arr[idx]);
        calc(idx+1, sum);
    }
}
