import java.util.*;
import java.io.*;
/*
 * 학생 수 n과 구간 수 k가 주어지고, 성적 s가 주어지면. 학번 구간의 학생들 성적 평균 계산
 */ 
 
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int N = Integer.parseInt(st.nextToken());//학생수
        int K = Integer.parseInt(st.nextToken());//구간수
 
        int[] scores = new int[N+1];
        st = new StringTokenizer(in.readLine());
        for(int i=1;i<=N;i++){
            scores[i] = scores[i-1]+Integer.parseInt(st.nextToken());
        }
 
        StringBuilder sb = new StringBuilder();
        int a,b;
        double result;
        for(int i=0;i<K;i++){
            st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            result = (double)(scores[b]-scores[a-1])/(b-a+1);
            //result = Math.round(result*100)/(double)100;
            //sb.append(result).append("\n");
            
            sb.append(String.format("%.2f\n",result));
        }
 
        System.out.println(sb);
 
    }
}
