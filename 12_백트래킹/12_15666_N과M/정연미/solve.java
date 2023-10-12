package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

//입력값에 중복된 값이 들어온다. 
//인덱스에 대한 중복을 허용하는 조합

public class N과M12 {
    static int[] result, arr;
    static boolean[] visited;
    static LinkedHashSet<String> set;
    static int N, M;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        result = new int[M];
        arr = new int[N];
        set = new LinkedHashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) 
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        NCR(0,0);
        set.forEach(System.out::println);
        
    }// main end 
    
    public static void NCR(int idx, int sidx) {
        if(sidx == M) {
            sb = new StringBuilder();
            for(int i=0; i<M; i++) {
                sb.append(result[i]+" ");
            }
            set.add(sb.toString());
            return;
        }
        
        for(int i =idx; i< N ;i++) {
            result[sidx] = arr[i];
            NCR(i, sidx+1);
        }
    }
}
