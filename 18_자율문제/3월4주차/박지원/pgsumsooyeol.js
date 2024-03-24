//자바스크립트 연속된 부분 수열의 합 (투포인터, 슬라이딩 윈도우)

function solution(sequence, k) {
    var answer = [];
        let left = 0;
        let right = 0;
        let length = Number.MAX_SAFE_INTEGER;
        let preSum = [sequence[0]];
        for (let i = 1; i < sequence.length; i++) {
            preSum[i] = preSum[i - 1] + sequence[i];
        }
        while (right < sequence.length && left <= right) {
            let sum = preSum[right] - preSum[left] + sequence[left];
            if (sum > k) {
                left++;
            } else if (sum == k) {
                if (length > right - left + 1) {
                    length = right - left + 1;
                    answer = [left, right];
                }
                right++;
            } else {
                right++;
            }
        
    }
        
    return answer;
}
