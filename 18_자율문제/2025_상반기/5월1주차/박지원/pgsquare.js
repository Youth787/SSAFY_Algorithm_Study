//프로그래머스 멀쩡한 사각형 자바스크립트
//유클리드호제법, 대각선이 지나는 사각형 갯수 구하는 공식: 가로*세로 - (가로 + 세로 - 가로세로의 최대공약수)
//참고 https://noogoonaa.tistory.com/74

function gcd(w, h) {
    const mod = w % h;
    
    if (mod === 0) {
        return h;
    }
    return gcd(h, mod);
}

function solution(w, h) {
    
    return w * h - (w + h - gcd(w, h));
}
