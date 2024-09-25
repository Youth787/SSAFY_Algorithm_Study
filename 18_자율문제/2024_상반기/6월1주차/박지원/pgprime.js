//프로그래머스 소수 찾기 js lv2
//자스 너무 어려워요... 소수 찾는 함수까지 만드는건 성공했는데
//자스로 순열만들기가 어려워서 블로그참조..
//https://prefer2.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%86%8C%EC%88%98-%EC%B0%BE%EA%B8%B0-level2-js

function solution(numbers) {
    const answer = new Set();
    const nums = numbers.split("");
    
    const getPermutation = (arr, fixed) => {
        if (arr.length >= 1) {
            for (let i = 0; i < arr.length; i++) {
                const newNum = fixed + arr[i];
                const copyArr = [...arr];
                copyArr.splice(i, 1);
                if (!answer.has(+newNum) && isPrime(+newNum)) {
                    answer.add(+newNum);
                }
                getPermutation(copyArr, newNum);
            }
        }
    }
    
    getPermutation(nums, '');
    return answer.size;
}

const isPrime = (num) => {
    if (num <= 1) return false;
    for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) return false;
    }
    return true;
}

