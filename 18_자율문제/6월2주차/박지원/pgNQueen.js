//프로그래머스 nQueen js
//나는.. 재귀함수는 진짜 안될거같아... 포기선언.

function solution(n) {
    let count = 0;
    const isPossible = (chess, col) => {
        for (let i = 1; i < col; i++) {
            if (chess[col] == chess[i]) return false;
            if (Math.abs(col - i) == Math.abs(chess[col] - chess[i])) return false;
        }
        return true;
    }
    const nQueen = (chess, depth) => {
        if (depth == n) {
            count++;
        } else {
            for (let i = 1; i <= n; i++) {
                chess[depth + 1] = i;
                if (isPossible(chess, depth + 1)) nQueen(chess, depth + 1);
            }
        }
    }
    for(let i = 1; i <= n; i++) {
        const chess = new Array(n+1).fill(0);
        chess[1] = i;
        nQueen(chess, 1);
    }
    return count;
}
