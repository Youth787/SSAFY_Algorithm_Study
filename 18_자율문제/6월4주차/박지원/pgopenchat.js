//프로그래머스 오픈채팅방 자바스크립트
//무난 무난한 문제 근데 아래 다른 사람이 푼 방식이 자스에선 더 좋을듯!

//내가푼방식
function solution(record) {
    var answer = [];
    let userMap = new Map();
    record.map((el) => {
        const records = el.split(" ");
        if (records[0] != 'Leave') {
            userMap.set(records[1], records[2]);
        }
    })
    record.map((el) => {
        const records = el.split(" ");
        if (records[0] == 'Enter') {
            answer.push(`${userMap.get(records[1])}님이 들어왔습니다.`);
        } else if (records[0] == 'Leave') {
            answer.push(`${userMap.get(records[1])}님이 나갔습니다.`)
        }
    })
    return answer;
}

//다른 사람이 푼 방식
function solution(record) {
    const userInfo = {};
    const action = [];
    const stateMapping = {
        'Enter': '님이 들어왔습니다.',
        'Leave': '님이 나갔습니다.'
    }

    record.forEach((v) => {
        const [state, id, nick] = v.split(' ');

        if(state !== "Change") {
            action.push([state, id]);
        }

        if(nick) {
            userInfo[id] = nick;
        }
    })

    return action.map(([state, uid]) => {
        return `${userInfo[uid]}${stateMapping[state]}`;    
    })
}
