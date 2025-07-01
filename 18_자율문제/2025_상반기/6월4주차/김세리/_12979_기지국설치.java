class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 1;
        int sIdx = 0;
        int coverage = 2*w + 1;
        
        while (idx <= n) {
            if (sIdx < stations.length && idx >= stations[sIdx] - w) {
                idx = stations[sIdx] + w + 1;
                sIdx++;
            } else {
                answer++;
                idx += coverage;
            }
        }
        return answer;
    }
}
