package GOLD;

import java.io.*;
import java.util.*;

public class 태상이의훈련소생활 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] height = new int[N+1];
        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) height[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sum[a-1] +=k;
            sum[b] -=k;
        }

        for(int i=0; i<N; i++){
            sum[i+1] += sum[i];
            System.out.print(height[i]+sum[i]+" ");
        }
    }
}
