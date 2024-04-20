
/*
 * 알파벳 소문자 문자열 배열 2개(뭉치)에서 순서대로 한장씩 사용해서 목표 단어배열을 만들 수 있는지
 */
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < goal.length; i++) {
            if (idx1 < cards1.length && cards1[idx1].equals(goal[i]) ) {
                idx1++;
            } else if (idx2 < cards2.length && cards2[idx2].equals(goal[i])) {
                idx2++;
            } else {
                return "No";
            }          
        }
        return "Yes";
    }
}
