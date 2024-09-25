import java.util.*;

//프로그래머스 뒤에 있는 큰수 찾기 스택
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i = numbers.length - 1; i >= 0; i--){
            while(!s.isEmpty()){
                if(s.peek() > numbers[i]){
                    answer[i] = s.peek();
                    break;
                } else {
                    s.pop();
                }
            }
            if(s.isEmpty()){
                answer[i] = -1;
            }
            s.push(numbers[i]);
        }

        return answer;
    }
}
