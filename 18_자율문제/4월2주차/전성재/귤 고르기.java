import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : tangerine){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        for(int list : keyList){
            if(k <= 0){
                break;
            }
            answer++;
            k -= map.get(list);
        }
        
        return answer;
    }
}
