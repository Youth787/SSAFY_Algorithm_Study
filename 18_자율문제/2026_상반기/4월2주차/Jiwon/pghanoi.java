import java.util.ArrayList;
class Solution {
    static ArrayList<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; ++i){
            int[] cmd = list.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];  
        }
        return answer;
    }
    static void hanoi(int n, int from, int to, int via) {
        int[] move=  {from, to};
        if (n == 1) {
            list.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            list.add(move);
            hanoi(n - 1, via, to, from);
        }
    }
}
