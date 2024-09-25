//틀린코드.. 배열길이가 십만이라 이중반복문 돌리면 안돼용 ㅠ
//그래도 최대공약수 구해서 나누는걸로 어찌저찌 합의보고 히든케이스까지 처리를 해준코드

const gcd = (a, b) => {
  if(b === 0){
     return a;
  }
  return gcd(b, a % b);
};

function solution(weights) {
    let answer = 0;
        

    
    for (let i = 0; i < weights.length - 1; i++) {
        for (let j = i + 1; j < weights.length; j++) {
            const mini = gcd(weights[i], weights[j]);
            if (weights[i] == weights[j]) {
                answer++;
                continue;
            }
            const wi = weights[i] / mini;
            const wj = weights[j] / mini;
            if (wi == 1 || wj == 1) {
                const max = Math.max(wi, wj);
                if (max * 2 <= 4) answer++;
                continue;
            }
            if (wi <= 4 && wj <= 4) {
                answer++;
            }
        }
    }

    return answer;
}
