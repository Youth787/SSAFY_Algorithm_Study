//무인도 여행 자바스크립트
//자바만큼 익숙해지게 많이 풀어보기
//이 문제는 자바로 푸는거랑 푸는 방식이 아예 똑같았다. 방문처리, x가 아닌 곳을 찾아 bfs 를 돌리고 answer처리해주면 됨

function solution(maps) {
    var answer = [];
    const [x, y] = [maps.length, maps[0].length];
    const visited = Array.from({length: x}, () => Array(y).fill(0));
    const move = [[0, 1], [1, 0], [-1, 0], [0, -1]];
    
    const bfs = (a, b) => {
        let cnt = 0;
        const q = [[a, b]];
        cnt += parseInt(maps[a][b]);
        visited[a][b] = 1;
        while(q.length) {
            const [r, c] = q.shift();
            for (let i = 0; i < 4; i++) {
                const ma = r + move[i][0];
                const mb = c + move[i][1];
                if (ma >= 0 && mb >= 0 && ma < x && mb < y && !visited[ma][mb] && maps[ma][mb] != 'X') {
                    visited[ma][mb] = 1;
                    cnt += parseInt(maps[ma][mb]);
                    q.push([ma, mb]);
                }
                
            }
        }
        answer.push(cnt);
    }
    
    for (let i = 0; i < x; i++) {
        for (let j = 0; j < y; j++) {
            if (!visited[i][j] && maps[i][j] != 'X') {
                bfs(i, j);
            }
        }
    }
    
    if (answer.length == 0) return [-1]
    return answer.sort((a, b) => a - b);
}
