import java.util.*;

class 구명보트 {
    public int solution(int[] people, int limit) {      
        int first = 0;
        Arrays.sort(people);//먼저 정렬

        int ans = 0;
        for (int i = people.length -1; i >= first; i--) {
        	if (people[first] + people[i] <= limit) {
        		first++;
        	} 
        	ans++;
        }
        return ans;
    }
}
