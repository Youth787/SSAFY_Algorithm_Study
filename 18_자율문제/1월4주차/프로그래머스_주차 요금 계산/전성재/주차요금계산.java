import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();
        
        for(int i = 0; i < records.length; i++){
            feeMap.put(records[i].split(" ")[1], 0);
        }
        
        for(int i = 0; i < records.length; i++){
            String[] data = records[i].split(" ");
            // 이미 들어가 있다면
            
            if(map.containsKey(data[1])){
                String[] inTime = map.remove(data[1]).split(":");
                String[] outTime = data[0].split(":");
                
                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
                
                feeMap.replace(data[1], feeMap.get(data[1]) + 60 * hour + minute);
                
            }else{
                map.put(data[1], data[0]); // 차 번호, 시간
            }
        }
         for(String key : map.keySet()){
            String[] Time = map.get(key).split(":");
            
            int hour = 23 - Integer.parseInt(Time[0]);
            int minute = 59 -Integer.parseInt(Time[1]);
            
            feeMap.replace(key, feeMap.get(key) + 60 * hour + minute);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList(feeMap.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return Integer.parseInt(o1.getKey()) > Integer.parseInt(o2.getKey()) ? 1 : 
            Integer.parseInt(o1.getKey()) < Integer.parseInt(o2.getKey()) ? -1 : 0;
        });
        

        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            if(list.get(i).getValue() > fees[0]){
                answer[i] = fees[1] + (int) Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3];
            }else{
                answer[i] = fees[1];
            }
        }
        
        return answer;
        
        
        
    
    }
}
