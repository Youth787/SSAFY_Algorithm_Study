//프로그래머스 인사고과 자바
//정렬
//조합에 비교에 정렬까지 할 필요 없이 그냥 정렬 두번으로 끝내는 문제..

import java.util.Arrays;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int n = scores[0][0];
        int m = scores[0][1];
        int size = scores.length;
        
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
            
        int maxScore = scores[0][1];
        for (int i = 1; i < size; i++) {
            if (scores[i][1] < maxScore) { // 인센티브 못받음
                if (scores[i][0] == n && scores[i][1] == m) { // 완호라면
                    return -1;
                }
                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                maxScore = scores[i][1];
            }
        }
        
        Arrays.sort(scores, (o1, o2) -> {
            return (o2[0] + o2[1]) - (o1[0] + o1[1]);
        });
        for (int[] temp: scores) {
            if (temp[0] == n && temp[1] == m) break;
            else answer++;
        }
        return answer;
    }
}
