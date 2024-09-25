import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int st = 0;
        int ed = people.length -1;
        
        while(st<=ed){
            if(people[st]+people[ed]>limit){
                ed --;
                answer ++;
            }
            else{
                st ++;
                ed --;
                answer++;
            }
        }
        return answer;
    }
}