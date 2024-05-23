//경우의수가 4가지밖에 없다!!! 이를 잘 활용해보자

function solution(weights) {
    let answer = 0;
    const store = {}
    const cal = [1, 3/2, 2, 4/3]; // 경우의 수 (1, 1) (2, 3) (2, 4) (3, 4)
    
    weights.sort((a, b) => b - a).forEach((w) => {
        let s;
        cal.forEach((i) => {
            if (s = w * i, store[s]) {
                answer += store[s]
            }
        })
        if (!store[w]) store[w] = 1;
        else store[w]++;
    })


    return answer;
}
