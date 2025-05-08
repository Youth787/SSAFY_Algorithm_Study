import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize==0){
            return cities.length*5;
        }
        List<String> list = new ArrayList<>();
        int answer = 0;
        
        for(String raw : cities){
            String city = raw.toLowerCase(Locale.ROOT);
            
            if(list.remove(city)){
                answer +=1;
            } else{
                if(list.size() == cacheSize) list.remove(0);
                answer +=5;
            }
            list.add(city);
            
        }
        return answer;
    }
}
