import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && prices[stack.peek()]>prices[i]){
                int idx = stack.pop();
                answer[idx] = i-idx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx]=N-1-idx;
        }
        return answer;
    }
}
