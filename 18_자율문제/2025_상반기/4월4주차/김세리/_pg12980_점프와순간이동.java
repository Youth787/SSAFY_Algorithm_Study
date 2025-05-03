import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while(n>0){
            if(n%2==0){
                n=n/2;
            }else {
                ans++;
                n=(n-1)/2;
            }
        }

        // System.out.println("Hello Java");

        return ans;
    }
}
