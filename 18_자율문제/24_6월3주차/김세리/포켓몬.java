import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer>map = new HashMap<>();
        int N = nums.length;
        
        for(int i=0;i<N;i++){
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                // System.out.println("map추가 : "+nums[i]);
            }
        }
        if(N/2 >= map.size()) answer=map.size();
        else answer = N/2;
        
        return answer;
    }
}
