/*
 * 펄스 수열: 1 또는 -1로 시작하여 번갈아 나오는 수열
 * 연속 펄스 부분 수열(어떤 수열의 "연속 부분" 수열에, 같은 길이의 펄스 수열을 곱하겠다)
 * 연속 펄스 부분 수열의 "합" 중 "가장 큰 것" 리턴
 * 
 * 먼저 sequence의 부분수열에 곱할 펄스 수열이 1로 시작할지, -1로 시작할지의 경우가 있음
 * (1)음수이면서 숫자는 큰 것*-1, (2)음수이면서 숫자는 작은 것*1, (3) 양수이면서 숫자는 작은 것*-1, (4)양수이면서 숫자는 큰 것*1
 * ex. 홀수번째는 더히고
 * */
class Solution {
    public long solution(int[] sequence) {
        int[] pulse = {1,-1};//펄스 수열 축소버전
        
        //
        long sum0 = sequence[0];
        long sum1 = sequence[0] * -1;
        long min0 = 0; 
        long min1 = 0; 
        long answer = Long.MIN_VALUE;//최대를 구하니까

        int len = sequence.length;
        for (int i = 1; i <= len; i++) {
            pulse[0] *= -1;
            pulse[1] *= -1;
            
            answer = Math.max(answer, sum0 - min0);
            answer = Math.max(answer, sum1 - min1);
            
            min0 = Math.min(min0, sum0);
            min1 = Math.min(min1, sum1);
            
            if (i == len) {
                break;
            }//len까지 갔다면 여기서 끝
          
            sum0 += sequence[i] * pulse[0];
            sum1 += sequence[i] * pulse[1];
        }
        
        return answer;
    }
}
