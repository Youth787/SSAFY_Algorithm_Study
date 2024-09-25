class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10;
            storey /= 10;

            // 5인 경우, 앞자리 숫자가 5이상이면 올려주는 것이 유리함.
            if (digit == 5) {
                if (storey%10 >= 5) {
                    answer += (10 - digit);
                    storey++;
                }
                else {
                    answer += digit;    
                }
            }
            // 더하는 것이 이득
            else if (digit > 5) {
                answer += (10 - digit);
                storey++;
            }
            // 빼는 것이 이득
            else {
                answer += digit;
            }

        }
        return answer;
    }
}
