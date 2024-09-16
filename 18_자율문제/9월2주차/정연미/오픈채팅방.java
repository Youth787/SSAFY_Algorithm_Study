import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int count =0;
        HashMap<String, String> nickname = new HashMap<>();
        
        for(int i=0; i<record.length;i++){
            String[] input = record[i].split(" ");
            
            if(input[0].equals("Enter")){
                nickname.put(input[1], input[2]);
            }else if(input[0].equals("Leave")){
                continue;
            }else if(input[0].equals("Change")){
                nickname.put(input[1],input[2]);
                count++;
            }
        }
        
        String[] answer = new String[record.length-count];
        int idx =0;
        
        for(int i=0; i<record.length; i++){
            String[] input = record[i].split(" ");
            String nick = nickname.get(input[1]);
            
            if(input[0].equals("Enter"))
                answer[idx++] = nick+"님이 들어왔습니다.";
            else if(input[0].equals("Leave"))
                answer[idx++] = nick+"님이 나갔습니다.";
        }
        
        return answer;
    }
}
