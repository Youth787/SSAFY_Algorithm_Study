class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int begin = 1;
        for(int i = 0; i < stations.length; i++) {
            if(begin < stations[i] - w)
                answer += chk(begin, stations[i] - w - 1, w);
            begin = stations[i] + w + 1;
        }
        if(stations[stations.length - 1] + w < n)
            answer += chk(stations[stations.length - 1] + w + 1, n, w);
        return answer;
    }

    public int chk(int st, int ed, int w) {
        int tmp = (ed - st + 1) / (2 * w + 1);
        if((ed - st + 1) % (2 * w + 1) > 0) {
            tmp++;
        }
        return tmp;
    }
}
