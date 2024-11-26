//프로그래머스 가장 긴 팰린드롬 자바
//문자열

class Solution {
    public int solution(String s) {
        char[] chr = s.toCharArray();
        for (int leng = s.length(); leng > 1; leng--) {
            for (int start = 0; start + leng <= s.length(); start++) {
                boolean chk = true;
                // 처음부터 문자열 길이의 반틈만큼 문자가 같은지 비교
                for (int i = 0; i < leng/2; i++) {
                    if (chr[start + i] != chr[start + leng  - i - 1]) {
                        chk = false;
                        break;
                    }
                }
                if (chk) return leng;
            }
        }
        
        return 1;
    }
}
