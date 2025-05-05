//프로그래머스 파일명 정렬 자바
//문자형, 숫자형, 캐릭터 다루기, pq 정렬, 문자열 비교

import java.util.*;

class Solution {
    private static class Word implements Comparable <Word> {
        String head, number, foot;
        int idx;
        
        public Word (String head, String number, String foot, int idx) {
            this.head = head;
            this.idx = idx;
            this.number = number;
            this.foot = foot;
        }
        
        @Override
        public int compareTo (Word w) {
            int headComp = this.head.toLowerCase().compareTo(w.head.toLowerCase());
            if (headComp != 0) return headComp;

            int num1 = Integer.parseInt(this.number);
            int num2 = Integer.parseInt(w.number);
            if (num1 != num2) return num1 - num2;

            return this.idx - w.idx;
        }
        
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        PriorityQueue<Word> pq = new PriorityQueue<>();
        int index = 0;
        for (String file: files) {
            int len = file.length();
            boolean flagNum = false;
            String head = "";
            String num = "";
            String foot = "";
            for (int i = 0; i < len; i++) {
                char c = file.charAt(i);
                if (c >= '0' && c <= '9' && num.length() < 5) {
                    num += c; 
                    flagNum = true;
                } else {
                    if (!flagNum) head += c;
                    else {
                        foot += file.substring(i);
                        break;
                    }
                }
            }
            pq.add(new Word(head, num, foot, index++));
        }
        int idx = 0;
        while (!pq.isEmpty()) {
            Word now = pq.poll();
            answer[idx++] = now.head + now.number + now.foot;
        }
        return answer;
    }
}
