//프로그래머스 키패드 누르기(자바스크립트)

function solution(numbers, hand) {
    var answer = '';
    let left = 10;
    let right = 10;
    let map = new Map();
    
    map[2] = [3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4];
    map[5] = [2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3];
    map[8] = [1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2];
    map[0] = [0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1];
    
    for (number of numbers) {
        switch (number) {
            case 1:
            case 4:
            case 7:
                answer += "L";
                left = number;
                break;
            case 3:
            case 6:
            case 9:
                answer += "R";
                right = number;
                break;
            case 2:
            case 5:
            case 8:
            case 0:
                let leftDiff = map[number][left];
                let rightDiff = map[number][right];
                
                if (leftDiff > rightDiff) {
                    answer += "R";
                    right = number;
                } else if (leftDiff < rightDiff) {
                    answer += "L";
                    left = number;
                } else if (leftDiff == rightDiff) {
                    if (hand == "right") {
                        answer += "R";
                        right = number;
                    } else {
                        answer += "L";
                        left = number;
                    }
                }
                break;
        }
    }
    return answer;
}
