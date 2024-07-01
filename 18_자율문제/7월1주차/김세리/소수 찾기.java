import java.util.*;
import java.io.*;

class Solution {
    public HashSet<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        int N = numbers.length();
        char[] arr = numbers.toCharArray();
        
        // 모든 숫자의 조합을 생성한다
        generateNums("", arr, new boolean[N]);
        
        // 생성된 숫자 조합이 소수인지 판별한다
        // 소수일 경우 answer 증가
        for(int num : numberSet){
            if(isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    private void generateNums(String combination, char[] arr, boolean[] used){
        if(!combination.equals("")){
            numberSet.add(Integer.valueOf(combination));
        }
        
        for(int i=0;i<arr.length;i++){
            if(!used[i]){
                used[i] = true;
                // 현재 숫자를 조합에 추가하고 재귀호출로 또 새로운 조합을 생성
                generateNums(combination+arr[i],arr,used);
                used[i] = false;
            }
        }
    }
    
    // 소수인지 판별
    private boolean isPrime(int number){
        if(number < 2) return false;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}
