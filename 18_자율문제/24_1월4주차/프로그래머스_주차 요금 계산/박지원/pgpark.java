import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
      //이문제의 핵심!! 맵을 두개 이용하라!!
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        
        int baseTime = fees[0];
        int baseFee = fees[1];
        int partTime = fees[2];
        int partFee = fees[3];
        
        for (String record : records) {
            String[] tmp = record.split(" ");
            int time = getRealTime(tmp[0]);
            String car = tmp[1];
            String io = tmp[2];
            
            if (io.equals("IN")) {
                map1.put(car, time);
            } else {
                int carTime1 = map1.get(car);
                map1.remove(car);
              //아웃할건데 이미 아웃 한번 했었음 ?? 그럼 map2에서 가져오셈
                if (map2.containsKey(car)) {
                    int carTime2 = map2.get(car);
                    map2.replace(car, carTime2 + time - carTime1);    
                } else { //아니라면 map2에 넣어주셈
                    map2.put(car, time - carTime1);
                }   
            }
        }
        int lastTime = 1439;
        for (String car : map1.keySet()) {
            int carTime1 = map1.get(car);
            if (map2.containsKey(car)) {
                    int carTime2 = map2.get(car);
                    map2.replace(car, carTime2 + lastTime - carTime1);    
                } else {
                    map2.put(car, lastTime - carTime1);
            }   
        }
        Object[] sortKey = map2.keySet().toArray();	//차 번호 순서대로 정렬
		Arrays.sort(sortKey);
        answer = new int[sortKey.length];

        for (int i = 0; i<answer.length; i++) {
            int result = baseFee;
            String car = String.valueOf(sortKey[i]);
            
            int val = map2.get(car);
            if (val > baseTime) {
                result = (int) (baseFee + Math.ceil((double)(val-baseTime)/partTime) * partFee);
            }
            answer[i] = result;
        }
        
        return answer;
    }
    
    public int getRealTime(String time) {
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        int minute = Integer.parseInt(tmp[1]);
        return hour + minute;
    }
    
    
}

//https://velog.io/@rlvy98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A3%BC%EC%B0%A8-%EC%9A%94%EA%B8%88-%EA%B3%84%EC%82%B0Java-%EC%9E%90%EB%B0%94
