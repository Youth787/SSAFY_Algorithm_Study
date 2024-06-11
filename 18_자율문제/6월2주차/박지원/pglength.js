//프로그래머스 방문길이 js
//자바랑 푸는방법 동일했다
//근데 함수가 둘이 다르니까 헷갈려잉

function solution(dirs) {
    let answer = 0;
    const set = new Set();
    const point = [5, 5];
    
    const solve = (c) => {
        const prev = [...point];
        switch (c) {
            case 'U':
                if (point[0] > 0) point[0]--;
                break;
            case 'D':
                if (point[0] < 10) point[0]++;
                break;
            case 'R':
                if (point[1] < 10) point[1]++;
                break;
            case 'L':
                if (point[1] > 0) point[1]--;
                break;
        }
        
        const line1 = `${prev[0]+','+prev[1]+'->'+point[0]+','+point[1]}`;
        const line2 = `${point[0]+','+point[1]+'->'+prev[0]+','+prev[1]}`;
        
        if (!set.has(line1) && !set.has(line2) && line1 != line2) {
            set.add(line1);
            set.add(line2);
            answer++;
        }
    }
    
    for (let i = 0; i < dirs.length; i++) {
        solve(dirs.charAt(i));
    }
    return answer;
}
