import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numbers.length; i++) list.add(numbers[i]);
        
        // arraylist 정렬 
        Collections.sort(list, (a,b)->{
            String aa = String.valueOf(a);
            String bb = String.valueOf(b);
            return Integer.parseInt(bb+aa)-Integer.parseInt(aa+bb);
        });
        
        for(int i=0; i<numbers.length; i++) sb.append(list.get(i));
        
        String answer = sb.toString();
        if(answer.charAt(0) =='0') answer = "0"; 
        return answer;
    }
}
