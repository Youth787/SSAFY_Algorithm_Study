// https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-3079-%EC%9E%90%EB%B0%94-java-%EC%9E%85%EA%B5%AD-%EC%8B%AC%EC%82%AC
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n;
    static long m, max; //10억까지 나올 수 있으니까 long으로
    static int [] arr;
    static long result = Long.MAX_VALUE;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String [] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
 
        arr = new int [n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,arr[i]);
        }
        Arrays.sort(arr); //이분탐색은 우선적으로 정렬이 필요함. 
        solve();
 
        System.out.println(result);
    }//main
 
    private static void solve(){
        //작은값, 큰값, 중간값 구해서 확인하며 각 값을 조정함
        long low = 0;
        long high = m * max;
 
        while(low <= high){
            long mid = (low + high)/2;
            long sum = 0;
            for(long index : arr){
                long count = mid/index; //count는 한 심사대에서 맡을 수 있는 사람 수가 구해짐.
                if(sum >= m) break;//만약 m을 넘게 되면 이제 더이상 진행 안함.
                sum+=count; //처리할 수 있는 사람 수 구함.
            }//arr을 돌면서 심사대 확인
            if(sum>=m){ //만약 sum이 m을 넘게 되면
                high = mid-1; //큰 값 탐색 기준을 현재 mid-1로 변경.
                result = Math.min(mid,result); //result에는 시간의 최소값이 저장되게 된다
            }
            else{//sum이 m보다 작으면
                low = mid+1; //작은 값 탐색 기준을 현재 mid+1로 변경.
            }
        }//while문
    }//slove
}//class
