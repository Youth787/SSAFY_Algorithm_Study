//프로그래머스 퍼즐 게임 챌린지 자바스크립트
//이분탐색

function solution(diffs, times, limit) {
    let max = 100000, min = 1, mid = undefined
    let answer = max
    while (min <= max){
        mid = Math.floor((max + min) / 2)
        let spendTime = 0, over = false
        for (let i = 0; i < diffs.length; ++i) {
            
            if (mid - diffs[i] < 0) {
                spendTime = spendTime + (diffs[i] - mid) * (times[i] + times[i-1]) + times[i] 
            } else { 
                spendTime += times[i]
            }
            
            if (limit < spendTime) {
                over = true
                break;
            }
        }
        
        if (over) {
           min = mid + 1
        } else {
           answer = mid 
           max = mid -1 
        }
        
    }
    return answer;
}
