import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n;
    static long m, max;
    static int [] arr;
    static long result = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
 
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,arr[i]);
        }
        Arrays.sort(arr);
 
        solve();
 
        System.out.println(result);
    }
 
    private static void solve(){
        long low = 0;
        long high = m * max;
 
        while(low<=high){
            long mid = (low+high)/2;
            long sum = 0;
            for(long index: arr){
                long count = mid/index;
 
                if(sum>=m){
                    break;
                }
                sum+=count;
            }
            if(sum>=m){
                high = mid-1;
                result = Math.min(mid,result);
            }
            else{
                low = mid+1;
            }
        }
    }
}
