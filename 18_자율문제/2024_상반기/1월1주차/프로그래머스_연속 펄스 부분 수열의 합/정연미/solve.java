package Algo_스터디.Jan_1주차;

class 프로그래머스_연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long[] prefixSum = new long[sequence.length+1];
        long max = 0;
        long min = 0;
        for(int i = 0; i<sequence.length; i++){
            if(i % 2 == 1)
                sequence[i] *= -1;
            prefixSum[i+1] = prefixSum[i] + sequence[i];
            max = Math.max(max, prefixSum[i+1]);
            min = Math.min(min, prefixSum[i+1]);
        }
        return max - min;
    }
}