//프로그래머스 징검다리 건너기 자바
//이분탐색 + 조건

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;
        int middle = (min + max) / 2;
        while (min <= max) {
            middle = (min + max) / 2;
            if (canCross(stones, k, middle)) {
                min = middle + 1;
                answer = Math.max(answer, middle);
            } else {
                max = middle - 1;
            }
        }
        return answer;
    }
    private static boolean canCross(int[] stones, int k, int middle) {
        int skip = 0;
        for (int a: stones) {
            if(a - middle < 0) skip++;
            else skip = 0;
            if (skip == k) return false;
        }
        return true;
    }
}
