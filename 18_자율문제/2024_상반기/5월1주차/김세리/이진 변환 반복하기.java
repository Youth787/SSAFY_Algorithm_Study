import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0; // 0을 제거한 횟수
        int trans = 0; // 변환 횟수
        while(!s.equals("1")){
            int n = s.length();
            String x = ""; // 0을 제거한 새로운 문자열을 담을 변수
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == '1'){
                    x += '1';
                } else {
                    cnt++;
                }
            }
            int c = x.length();
            s = Integer.toBinaryString(c);
            trans++;
        }
        int[] answer = new int[]{trans, cnt}; // 결과를 담을 배열
        return answer;
    }
}
