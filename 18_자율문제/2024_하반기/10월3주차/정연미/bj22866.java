package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class bj22866 {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] leftshow = new int[N];
        int[] rightshow = new int[N];
        int[] leftnear = new int[N];
        int[] rightnear = new int[N];

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            while(!stack.isEmpty()&&arr[stack.peek()]<=arr[i]) stack.pop();
            leftshow[i] = stack.size();
            leftnear[i] = stack.isEmpty()?0:stack.peek()+1;
            stack.push(i);
        }

        stack.clear();
        for(int i=N-1; i>=0; i--){
            while(!stack.isEmpty()&&arr[stack.peek()]<=arr[i]) stack.pop();
            rightshow[i] = stack.size();
            rightnear[i] = stack.isEmpty()?0:stack.peek()+1;
            stack.push(i);
        }

        for(int i= 0; i<N; i++){
            int total = leftshow[i]+rightshow[i];
            if(total==0) System.out.println(0);
            else{
                int near = 0;
                if (leftshow[i] > 0 && rightshow[i] > 0) {
                    near = Math.abs(i-(leftnear[i]-1))<=Math.abs(i-(rightnear[i]-1))?leftnear[i]:rightnear[i];
                }else if(leftshow[i]>0) near = leftnear[i];
                else near = rightnear[i];
                System.out.println(total+" "+near);
            }
        }
    }
}
