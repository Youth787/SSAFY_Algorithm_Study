import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = 1;
        for(int len=n;len>1;len--){
            for(int start=0;start<=n-len;start++){
                if(isPalindrome(s,start,start+len-1)){
                    // 가장 긴 팰린드롬 찾으면 즉시 반환
                    return len;
                }
            }
        }
        // 못 찾았을 경우 1이 가장 긴 팰린드롬이므로 1 반환
        return answer;
    }
    private boolean isPalindrome(String s,int left,int right){
        
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;        
    }
}
