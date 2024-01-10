// https://velog.io/@qodlstjd12/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B8%B0%EC%A7%80%EA%B5%AD-%EC%84%A4%EC%B9%98-Java

class Solution {
    public int bsearch(int begin, int end, int w) {
        int res = (end - begin + 1) / (2 * w + 1);
        if((end - begin + 1) % (2 * w + 1) > 0) res++;
        return res;
    }
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int begin = 1;
        for(int i = 0; i < stations.length; i++) {
            if(begin < stations[i] - w)
                answer += bsearch(begin, stations[i] - w - 1, w);
            begin = stations[i] + w + 1;
        }
        if(stations[stations.length - 1] + w < n)
            answer += bsearch(stations[stations.length - 1] + w + 1, n, w);
        return answer;
    }
}
