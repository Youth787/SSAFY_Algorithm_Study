package Algo_스터디.August_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj16637 {
    static int[] nums ;
    static char[] oper;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        nums = new int[input.length()/2+1];
        oper = new char[input.length()/2];

        for(int i=0; i<input.length()/2+1; i++){
            if(i==input.length()/2) {
                nums[i] = input.charAt(i*2) - '0';
                break;
            }
            nums[i] = input.charAt(i*2)-'0';
            oper[i] = input.charAt(i*2+1);
        }

        int max = DFS(0, nums[0]);
        System.out.println(max);
    }
    public static int DFS(int idx , int curr){
        if(idx == oper.length) return curr;

        int result = calc(curr,oper[idx],nums[idx+1]);
        int max_result = DFS(idx+1, result);

        int next_result =0;
        if(idx+1<oper.length) {
            next_result = calc(nums[idx + 1], oper[idx + 1], nums[idx + 2]);
            next_result = calc(curr, oper[idx], next_result);
            max_result = Math.max(max_result, DFS(idx + 2, next_result));
        }
        return max_result;
    }
    public static int calc (int a , char oper, int b ){
        if(oper =='+') return a+b;
        else if(oper =='-') return a-b;
        else if(oper =='*') return a*b;
        else return a/b;
    }
}
