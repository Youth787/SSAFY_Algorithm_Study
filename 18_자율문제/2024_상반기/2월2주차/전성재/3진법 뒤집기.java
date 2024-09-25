class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        // StringBuilder의 내용을 문자열로 변환하여 할당
        String str = sb.reverse().toString();

        for (int i = 0; i < str.length(); i++) {
            char digit = str.charAt(i);
            // 3의 제곱을 계산하여 누적
            answer += Character.getNumericValue(digit) * Math.pow(3, i);
        }

        return answer;
    }
}
