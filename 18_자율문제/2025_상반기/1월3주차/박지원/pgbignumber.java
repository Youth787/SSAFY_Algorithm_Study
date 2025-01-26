//프로그래머스 가장 큰 수 자바
//정렬(compareTo함수, 두개를 앞뒤, 뒤앞으로 붙여서 한다는 생각으 ㄹ못했음

import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] numberStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String temp = Integer.toString(numbers[i]);
            numberStr[i] = temp;
        }
        Arrays.sort(numberStr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (numberStr[0].equals("0")) {
           return "0";
        }
        for (String str: numberStr) sb.append(str);
        return sb.toString();
    }
}
