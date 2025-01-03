import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++){ 
            num[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE; 
      
        for(int i = 0; i <= N-K; i++){
            int sum = 0;
            for(int j = i; j < i+K; j++){ 
                sum = sum + num[j];
            }
            max = Math.max(sum, max); 
        }
        System.out.println(max);
    }
}
