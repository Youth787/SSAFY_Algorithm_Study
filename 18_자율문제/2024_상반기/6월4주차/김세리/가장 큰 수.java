import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numStrs = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            numStrs[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numStrs, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String order1 = o1+o2;
                String order2 = o2+o1;
                
                return order2.compareTo(order1);
            }
        });
        
        StringBuilder answer = new StringBuilder();
        for(String numStr : numStrs){
            answer.append(numStr);
        }
        
        if(answer.charAt(0)=='0') return "0";
        return answer.toString();
    }
}
