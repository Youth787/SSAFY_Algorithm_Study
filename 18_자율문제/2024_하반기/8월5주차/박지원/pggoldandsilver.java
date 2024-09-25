//프로그래머스 금과 은 운반하기 자바
//이분탐색.. 이걸 이분탐색이라고 떠올릴 수가 있을까..? 흑흑
//아무튼 mid(시간)에 금과은을 옮길수 있는가 없는가를 판단해야함

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long left = 1;
        long right = (long)(10e9 * 2 * 10e5 * 2);
        int len = s.length; 
        while (left <= right) {
            long mid = (left + right) / 2;
            
            int gold = 0;
            int silver = 0;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                int weight = w[i];
                int time = t[i];
                
                long cnt = mid / (time * 2);
                if ((mid % (time * 2)) >= time) {
                    cnt++;
                }
                gold += Math.min(g[i], weight * cnt);
                silver += Math.min(s[i], weight * cnt);
                sum += Math.min(g[i] + s[i], weight * cnt);
                
            }
            if (gold >= a && silver >= b && sum >= a + b) {
                answer = mid;
                right = mid - 1;
            } else left = mid + 1;
            
        }
        return answer;
    }
}
