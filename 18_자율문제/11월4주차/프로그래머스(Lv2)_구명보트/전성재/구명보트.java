import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int min = 0;
        int answer = 0;
        Arrays.sort(people);
        for(int max = people.length - 1; min <= max; max--){
            if(people[min] + people[max] <= limit){
                min++;
                answer++;
            }
            else{
                answer++;
            }
        }
        
        return answer;
    }
}
