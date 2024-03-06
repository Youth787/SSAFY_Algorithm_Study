package Algo_스터디.Mar_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = N-1;
        int result = Integer.MAX_VALUE;
        int[] print = new int[2];
        Arrays.sort(arr);

        while(start<end){
            int sum = arr[start]+arr[end];
            if(result > Math.abs(sum)) {
                result = Math.abs(sum);
                print[0] = arr[start];
                print[1] = arr[end];
                if(sum==0) break;
            }
            if(sum<0){
                start++;
            }else{
                end--;
            }
        }
        System.out.println(print[0]+" "+print[1]);
    }
}
