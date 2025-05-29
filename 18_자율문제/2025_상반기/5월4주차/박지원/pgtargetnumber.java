//프로그래머스 타겟넘버 자바
//DFS

class Solution {
    private static int answer, tar;
    private static int[] number;
    public int solution(int[] numbers, int target) {
        answer = 0;
        tar = target;
        number = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            number[i] = numbers[i];
        }
        dfs(0, 0);
        return answer;
    }
    private static void dfs(int depth, int num) {
        if (depth == number.length) {
            if (num == tar) answer++;
            return;
        }
        dfs(depth + 1, num + number[depth]);
        dfs(depth + 1, num - number[depth]);
        
    }
}
