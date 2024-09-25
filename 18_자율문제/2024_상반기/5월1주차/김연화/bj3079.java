import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long res = Long.MAX_VALUE;

        long[] arr = new long[N];
        long max = 0;
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        long start = 0;
        long end = max*M;
        while(start <= end){
            long mid = (start+end)/2;
            long sum = 0;
            for(int i=0;i<N;i++){
                long cnt = mid/arr[i];

                if(sum >= M) break;
                sum += cnt;
            }

            if(sum>=M){
                end = mid-1;
                res = Math.min(res, mid);
            }
            else start = mid+1;
        }

        System.out.println(res);
    }
}
