import java.util.*;

// https://bada744.tistory.com/93
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
         Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(str[0].equals("0")){
            return "0";
        }
        
        for (int i = 0; i < str.length; i++) {
            answer += str[i];
        }
        
        return answer;
    }
}
