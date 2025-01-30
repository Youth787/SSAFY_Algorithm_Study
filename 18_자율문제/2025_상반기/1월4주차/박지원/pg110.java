//프로그래머스 110옮기기 자바
// stack활용한 문제. 다시풀어보자 ㅜ

import java.util.*;

class Solution {
    
    
    public String solve(String s){
        
        int cnt110 = 0;
        
        Stack<Character> st = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++){
            
            st.push(s.charAt(i));
            
            if (st.size() >= 3){
                //시간복잡도를 조금이라도 줄이고자 3개를 순차적으로 꺼내며 검사
                char first = st.pop();
                if (first != '0'){
                    st.push(first);
                    continue;
                }
                char second = st.pop();
                if (second != '1'){
                    st.push(second);
                    st.push(first);
                    continue;
                }
                char third = st.pop();
                if (third != '1'){
                    st.push(third);
                    st.push(second);
                    st.push(first);
                    continue;
                }
                cnt110++;
            }
        }
        
        //string으로 +연산시 시간초과 발생
        StringBuilder sb = new StringBuilder();
        int pos = st.size();
        boolean flag = false;
        
        //0을 발견할때까지 idx조정
        while (!st.isEmpty()){
            char pop = st.pop();
            if (!flag && pop == '1') pos--;
            if (pop == '0') flag = true;
            sb.insert(0, pop);
        }
        
        //110의 갯수만큼 110을 idx자리에 붙힘
        String fix = "";
        for (int i = 0; i < cnt110; i++)
            sb.insert(pos, "110");
    
        return sb.toString();
    }
    
    public String[] solution(String[] s) {
        
        String[] answer = {};
        answer = new String[s.length];
        
        //1케이스씩 해결
        for (int i = 0; i < s.length; i++)
            answer[i] = solve(s[i]);
        
        return answer;
    }
}
