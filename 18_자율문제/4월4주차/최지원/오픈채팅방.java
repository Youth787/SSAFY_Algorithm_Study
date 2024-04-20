import java.util.HashMap;

/*
 * 중복 닉 허용
 * "Enter "+유저id+" "+닉네임
 * "Leave "+유저id
 * "Change "+유저id+" "+닉네임
 */

class Solution {
    public String[] solution(String[] record) {
        HashMap <String, String> users = new HashMap<>();
        int cnt = 0;
        for (String rec : record) {
            String[] info = rec.split(" ");
            //id(중복 불가)와 닉네임(중복 가능) 저장
            if (info[0].equals("Leave")) {
                continue;
            } else {
                users.put(info[1], info[2]);
                if (info[0].equals("Change")) {
                    cnt++;
                }
            }
        }
        
        String[] answer = new String[record.length - cnt];
        int idx = 0;
        for (String rec : record) {
            String[] info = rec.split(" ");
            if (info[0].equals("Enter")) {
                answer[idx++] = users.get(info[1])+"님이 들어왔습니다.";
            } else if (info[0].equals("Leave")) {
                answer[idx++] = users.get(info[1])+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}
