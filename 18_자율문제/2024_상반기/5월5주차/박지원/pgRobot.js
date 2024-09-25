// 프로그래머스 리코쳇 로봇
//자바로 2차원 배열 생성해서 처리하는건 생각보다 쉬운데
//자스로 하자니 처음부터 어케 배열을 만들지부터 생각했어야했음.. 근데거기서 막힘..
//자스에서는 그냥 Array.fill.map을 주로 사용한다!!
//또한 메서드를 따로 빼지 않고 bfs같은 경우 같은 함수 내에서 진행을 해도 무방! 
//대신 pq같은 자료구조는 없고 그냥 shift(poll의 역할), push로 진행한다.

function solution(board) {
    let answer = -1;
    const map = board.map((el) => el.split(""));
    const n = map.length;
    const m = map[0].length;
    const visited = new Array(n).fill().map(_ => new Array(m).fill(0));
    const mx = [-1, 0, 1, 0]
    const my = [0, 1, 0, -1]

    let startX;
    let startY;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (map[i][j] === 'R') {
                startX = i;
                startY = j;
                break;
            }
        }
    }
    let q = [[startX, startY, 0]];
    visited[startX][startY] = 1;
    while (q.length) {
        const [x, y, count] = q.shift()
        if (map[x][y] === 'G') {
            answer = Math.max(answer, count);
            break;
        }
        for (let i = 0; i < 4; i++) {
            let nx = x + mx[i];
            let ny = y + my[i];
            while (nx >= 0 && nx < n && ny < m && ny >= 0 && map[nx][ny] !== 'D') {
                nx += mx[i]
                ny += my[i]
            }
            nx -= mx[i]
            ny -= my[i]
            if (visited[nx][ny] === 0) {
                q.push([nx, ny, count+1])
                visited[nx][ny] = 1;
            }
        }
    }
    return answer;
}
