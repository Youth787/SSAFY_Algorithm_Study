import java.util.*;


//프로그래머스 개인정보 수집 유효기간 (map썼고 빡구현으로함)
class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {        
        ArrayList<Integer> answer = new ArrayList<>();
        int year = Integer.parseInt(today.substring(0, 4));
        int month = Integer.parseInt(today.substring(5, 7));
        int day = Integer.parseInt(today.substring(8, 10));
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String s: terms) {
            map.put(s.substring(0, 1), Integer.parseInt(s.substring(2)));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String grade = privacies[i].substring(11, 12);
            int term = map.get(grade);
            String s = privacies[i].substring(0, 10);

            int tempY = Integer.parseInt(s.substring(0, 4));
            int tempM = Integer.parseInt(s.substring(5, 7));
            int tempD = Integer.parseInt(s.substring(8, 10));
            tempM += term;
            tempD--;
            if (tempD <= 0) {
                tempD = 28;
                tempM--;
            }
            if (tempM <= 0) {
                tempM = 12;
                tempY--;
            }
            while (tempM > 12) {
                tempM -=12;
                tempY++;
            }

            if (year > tempY) {
                answer.add(i + 1);
            } else if (year == tempY) {
                if (month > tempM) {
                    answer.add(i + 1);
                } else if (month == tempM) {
                    if (day > tempD) {
                        answer.add(i + 1);
                    }
                }
            } else continue;
        }
        
        
        
        
        
        
        return answer;
    }
}
