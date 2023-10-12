import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 중복 안되는 조합이다. 

public class N과M6 {
    static int N, M;
    static int[] arr, result;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N]; 
        result = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }// 입력 받기 완료 
        
        Arrays.sort(arr);
        nCr(0, 0);
    }// main end 
    
    public static void nCr(int sidx, int idx) {
        if(sidx==M) {
            for(int i=0 ;i<M; i++) {
                    System.out.print(result[i]+" ");
            }System.out.println();
            return;
        } //기저 조건 
        
        if(idx==N) 
            return;
        
                result[sidx] = arr[idx];
                nCr(sidx+1,idx+1);
                nCr(sidx, idx+1);
        }
}