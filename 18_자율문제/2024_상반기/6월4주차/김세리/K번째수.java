import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            int start = commands[i][0] - 1;
            int end = commands[i][1];

            int[] tmp = Arrays.copyOfRange(array, start, end);

            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }
        return answer;
    }
}
