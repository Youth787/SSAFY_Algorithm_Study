package Algo_스터디.Mar_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        char[] chararr1 = input1.toCharArray();
        String input2 = br.readLine();
        char[] chararr2 = input2.toCharArray();

        int[][] dp = new int[input1.length()+1][input2.length()+1];

        for(int j=1; j<dp[0].length; j++){
            for(int i=1; i<dp.length; i++){
                if(chararr1[i-1]==chararr2[j-1]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[chararr1.length][chararr2.length]);
        Stack<Character> stack = new Stack<>();
        int x = input1.length();
        int y = input2.length();

        while (x > 0 && y > 0) {
            if (chararr1[x - 1] == chararr2[y - 1]) {
                stack.push(chararr1[x - 1]);
                x--;
                y--;
            } else if (dp[x - 1][y] > dp[x][y - 1]) {
                x--;
            } else {
                y--;
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
