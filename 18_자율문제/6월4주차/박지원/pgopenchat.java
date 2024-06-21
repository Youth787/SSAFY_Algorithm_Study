//프로그래머스 오픈채팅방 자바
//풀이는 똑같은데.. map.put이랑 문자열 비교인 equals 때문에 한~~~참을 헤멨다..

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            if (!arr[0].equals("Leave")) {
                map.put(arr[1], arr[2]);
            }
            if (!arr[0].equals("Change")) cnt++;
        }
        String[] answer = new String[cnt];
        int idx = 0;
        for (int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            String str = map.get(arr[1]);
            if (arr[0].equals("Enter")) {
                answer[idx] = str + "님이 들어왔습니다.";
                idx++;
            } else if (arr[0].equals("Leave")) {
                answer[idx] = str + "님이 나갔습니다.";
                idx++;
            }
        
        }
        return answer;
    }
}
