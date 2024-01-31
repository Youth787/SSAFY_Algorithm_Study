import java.util.*;

public class Solution5432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); 
        for (int t=1; t<=tc; t++) { 
            String bracket = sc.next(); 
            char[] arr = bracket.toCharArray(); 
            Stack<Character> st = new Stack<>(); 
            int sum = 0; 
            for(int i=0; i<arr.length; i++) {
                if (arr[i]=='(') {
                    st.push(arr[i]); 
                } else if (arr[i]==')' && arr[i-1]=='(') {
                    st.pop();
                    sum = sum + st.size(); 
                } else if (arr[i]==')' && arr[i-1]==')') { 
                    st.pop();
                    sum = sum+1; 
                }
            }
            System.out.println("#"+t+" "+sum);
        }
    }
}

