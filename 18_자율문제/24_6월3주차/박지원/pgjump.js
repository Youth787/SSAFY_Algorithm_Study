//프로그래머스 점프와 순간 이동 js

function solution(n)
{
    let ans = 0;
    while(n > 1) {
        if (n % 2) {
            ans++;
            n -= 1;
        }
        n /= 2;
    }
    return ans + 1;
}
