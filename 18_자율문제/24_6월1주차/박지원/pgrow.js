//프로그래머스 줄서는방법 js lv2 너무어렵다
//그냥,, 재귀만 돌면 안되는 문제.. 시간초과가 난다
//어떤 숫자가 들어올지 정해줘야 시간초과가 안남 ㅠㅠ
//참조블로그 : https://yun-devlop.tistory.com/entry/Javascript-%EC%A4%84-%EC%84%9C%EB%8A%94-%EB%B0%A9%EB%B2%95-12936

function solution(n, k) {
    let answer = [];
    let temp = Array.from({length: n}, (_, i) => i + 1);
    k -= 1;
    while (true) {
        n--;
        if (k == 0) {
            answer.push(...temp);
            break;
        }
        const index = Math.floor(k / factorial(n));
        k = k % factorial(n)
        answer.push(temp[index]);
        temp.splice(index, 1);
    }
    return answer;
}
const factorial = (num) => {
    if (num === 0) return 1;
    return num * factorial(num - 1);
}
