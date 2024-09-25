package Algo_스터디.Fev_2주차;

import java.util.*;
import java.io.*;

public class 오큰수{
    static int N;
    static int[] req = new int[1000001];
    static int[] res = new int[1000001];
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            req[i] = Integer.parseInt(st.nextToken());
            res[i] = -1;
        }

        for(int i=0;i<N;i++){
            // 스택에 있는 가장 최근의 숫자와 현재 숫자와 비교해서 현재 숫자가 더 클 경우 스택에 있는 모든 인덱스를 현재 숫자로 넣기
            while(!stack.isEmpty() && req[stack.peek()] < req[i]){
                int idx = stack.pop();
                res[idx] = req[i];
            }
            // 현재 숫자의 인덱스를 저장
            stack.push(i);
        }

        // StringBuilder를 통해 한번에 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(res[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}