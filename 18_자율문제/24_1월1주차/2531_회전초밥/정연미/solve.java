package Algo_스터디.Jan_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr= new int[N];
        int ans =0, count=0;

        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            count =0;
            int[] cnt = new int[d+1];
            boolean flag= false;

            for(int j=i; j<i+k; j++){
                if(arr[j%N]==c) flag =true;
                if(cnt[arr[j%N]]!=0) continue;
                cnt[arr[j%N]]++;
                count++;
            }

            if(!flag) count++;
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }
}
