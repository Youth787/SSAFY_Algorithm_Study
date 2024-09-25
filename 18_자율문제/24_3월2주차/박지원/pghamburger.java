//햄버거만들기 자바 stack사용하지 않고 배열로 만들기, 삭제하지 않고 덮어쓰기 => 시간 절약

class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }
}

//자바스크립트로 풀었을 때
function solution(ingredient) {
    let answer = 0;
    let stack = [];
    for (let i = 0; i < ingredient.length; i++) {
        stack.push(ingredient[i]);
        if (stack.slice(-4).join('') == '1231') {
            answer++;
            stack.splice(-4);
        }
    }
    return answer;
}
