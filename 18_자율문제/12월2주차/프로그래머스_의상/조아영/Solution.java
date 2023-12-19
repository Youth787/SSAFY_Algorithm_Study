import java.util.*;

//https://devjanghwa.tistory.com/173
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> map = new HashMap<>();
        String[] str = new String[clothes.length];
        
        //key에 대분류, value에 숫자 1 넣기 
        //key가 겹치면 value+1
        for (int i=0; i<clothes.length; i++) {
            str[i] = clothes[i][1];
            if (map.get(clothes[i][1])==null) {
                map.put(clothes[i][1],1); //중복이 아니면 value에 1 넣고 
            } else if (map.get(clothes[i][1])!=null) { //중복이 아니면 value+1
                int tmp = map.get(clothes[i][1]);
                map.put(clothes[i][1],tmp+1);
            }             
        }
        
        String[] str2 = Arrays.stream(str).distinct().toArray(String[]::new);
        
        //value 값들을 더해주는 과정
        int ans = 1; 
        for (int i=0; i<str2.length; i++) {
            ans *= (map.get(str2[i])+1);
        }
        
        ans = ans - 1;
        return ans; 
    }
        
}
