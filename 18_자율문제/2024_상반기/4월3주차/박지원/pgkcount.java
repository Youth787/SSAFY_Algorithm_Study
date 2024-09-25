import java.util.*;

//프로그래머스 k진수에서 소수 갯수 구하기 에라토스테네스의 체, long, string reverse
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int temp = n % k;
            if (temp == 0) {
                String str = sb.reverse().toString();
                if (!str.equals("") && isPrime(Long.parseLong(str))) answer++;
                sb = new StringBuilder();
            } else sb.append(temp);
            n /= k;
        }
        String str = sb.reverse().toString();
        if (!str.equals("") && isPrime(Long.parseLong(str))) answer++;
        return answer;
    }

    public boolean isPrime(Long target) {
        if(target == 1) return false;
        if(target == 2) return true;
        for (long i = 2; i <= Math.sqrt(target); i++) {
            if (target % i == 0) return false;
        }
        return true;
    }
}
