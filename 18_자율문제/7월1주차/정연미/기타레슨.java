package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int right = 0;
        int left =0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }// 입력받기

        while(left<=right){
            int mid = (left+right)/2;
            int result = calculate(N,mid,arr);
            if(result>M){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(left);
    }
    public static int calculate(int n,int mid, int[] arr){
        int sum =0;
        int cnt =0;
        for(int i=0; i<n; i++){
            if(sum+arr[i]>mid){
                cnt++;
                sum=0;
            }
            sum+=arr[i];
        }
        if(sum!=0) cnt++;
        return cnt;
    }
}
