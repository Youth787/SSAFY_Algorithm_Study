import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/*
 * fees = {기본시간, 기본 요금, 단위시간, 단위요금}
 * records = ex. HH:MM 1234 IN (시각 기준 오름차순)
 * 기본 시간 초과 시 기본 요금 + 초과 (단위)시간 당 단위요금 + (단위시간으로 안 떨어지면)올림
 * 차량 번호가 작은 자동차부터 청구할 주차 요금 배열에 담아 return
 허허
 * */
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map <String, Integer> map1 = new HashMap <String, Integer>(); //입차 시간
        Map <String, Integer> map2 = new HashMap <String, Integer>(); //총 주차 시간
        
        //입출차 내역 하나씩. r 은 HH:MM 1234(차번호) IN(/OUT)
        for (String r : records) {
            String[] tmp = r.split(" ");
            int time = totalTime(tmp[0]);
            String car = tmp[1];
            String info = tmp[2];
            //정보 다 받아 놓고(시간은 분으로)
            
            if (info.equals("IN")) {
                map1.put(car, time); //입차 시간 기록
            } else {
                int carTime1 = map1.get(car); 
                map1.remove(car); //출차
                //하루에 같은 차가 주차장 여러번 이용 가능 => 이용한 적 있나 확인
                if (map2.containsKey(car)) {
                    int carTime2 = map2.get(car);
                    map2.replace(car, carTime2 + time - carTime1);  //누적시간대로 업데이트  
                } else {
                    map2.put(car, time - carTime1); //첫 출차 시 주차 시간 기록
                }   
            }
        }
        int last = 1439; //23시간 59분
        for (String c : map1.keySet()) {
            int carTime1 = map1.get(c);
            if (map2.containsKey(c)) {
                    int carTime2 = map2.get(c);
                    map2.replace(c, carTime2 + last - carTime1); //마지막까지 출차 안한거   
                } else {
                    map2.put(c, last - carTime1);
            }   
        }
        Object[] sortKey = map2.keySet().toArray();	//차 번호 정렬
		    Arrays.sort(sortKey);
        answer = new int[sortKey.length];

        for (int i = 0; i<answer.length; i++) {
            int result = fees[1]; //기본 요금
            String car = String.valueOf(sortKey[i]);
            
            int val = map2.get(car);
            if (val > fees[0]) {
                result = (int) (fees[1] + Math.ceil((double)(val-fees[0])/fees[2]) * fees[3]);
            }
            answer[i] = result; //최종 요금 계산 결과
        }
        
        return answer;
    } //Solution
    
    public int totalTime(String time) {
        String[] tmp = time.split(":");
        int h = Integer.parseInt(tmp[0]) * 60;
        int m = Integer.parseInt(tmp[1]);
        return h + m;
    } //totalTime(분으로 계산)
} //class
