import java.util.HashSet;
import java.util.Set;
class Solution {
    public int solution(int N, int number) {
       int answer = -1;
        Set<Integer>[] setArr = new Set[9];
        int t = N;
        for(int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + N;
        }
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                for(Integer a : setArr[i - j]) {
                for(Integer b : setArr[j]) {
                    
                        setArr[i].add(a + b);
                        setArr[i].add(a - b); 
                        setArr[i].add(a * b);
                        if(b != 0 && a != 0) {
                            setArr[i].add(a / b);
                        }
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++) {
            if(setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
