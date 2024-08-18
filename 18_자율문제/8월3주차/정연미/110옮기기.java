import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0; i<s.length; i++){
            List<Character> list = new ArrayList<>();
            String curr = s[i];
            int count110 =0;
            
            for(int j=0; j<curr.length(); j++){
                list.add(curr.charAt(j));
                int size = list.size();
                
                if(size>=3 && list.get(size-1)=='0'&&list.get(size-2)=='1'&&list.get(size-3)=='1'){
                    count110++;
                    list.remove(size-1); 
                    list.remove(size-2);
                    list.remove(size-3);
                } 
            }     
            
            // list에 있는 문자들 문자열로 바꾸기
            StringBuilder sb = new StringBuilder();
            list.stream().forEach(sb::append); //:: 의미 : sb클래스의 append메서드 참조
            String remain = sb.toString();
            
            StringBuilder result = new StringBuilder();
            int index = remain.lastIndexOf('0')+1;
            result.append(remain.substring(0,index));
            for(int k=0; k<count110; k++)result.append("110");
            result.append(remain.substring(index));
            
            answer[i] = result.toString();
        }
        return answer;
    }
}
