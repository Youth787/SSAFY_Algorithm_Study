class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] count = new int[e+1]; // 각 숫자의 약수 개수를 저장할 배열
        int[] maxNum = new int[e+1]; // 각 숫자에서 최대 약수 개수를 가진 숫자를 저장할 배열
        
        // 1. 약수 개수 미리 계산
        for (int i=1;i<=e;i++) {
            for (int j=i;j<=e;j+=i) {
                count[j]++;
            }
        }
        
        // 2. 뒤에서부터 최대 약수 개수를 가진 숫자 구하기
        int maxIdx = e; // 초기값은 가장 끝 숫자
        for (int i=e;i>0;i--) {
            if (count[i] >= count[maxIdx]) {
                maxIdx = i; // 더 많은 약수를 가진 숫자로 업데이트
            }
            maxNum[i] = maxIdx; // i 이상에서 최대 약수 개수를 가진 숫자를 저장
        }
        
        // 3. starts 배열을 처리하여 답 구하기
        for (int i=0;i<starts.length;i++) {
            answer[i] = maxNum[starts[i]]; // 각 start에 대해 미리 구한 값을 사용
        }
        
        return answer;
    }
}
