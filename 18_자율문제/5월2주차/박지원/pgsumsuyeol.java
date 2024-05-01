import java.util.*;

//프로그래머스 연속 부분 수열 합의 갯수
//set 써서 중복없이 갯수구했다. 배열이 돌아간다그래서 두개 합친 배열을 만들었는데,, 다른사람 풀이 보니 그럴필요 없이 i를 적당 값으로 나눠주면 될 일이었다. 하하
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int max = elements.length;
        int[] ele = new int[elements.length * 2];
        for (int i = 0; i < max; i++) {
            ele[i] = ele[i + max] = elements[i];
        }


        for (int i = 0; i < ele.length; i++) {
            int length = 1;
            int sum = 0;
            Queue<Integer> q = new LinkedList<>();
            a: for (int j = i; j < ele.length; j++) {
                if (length > max) break a;
                q.add(ele[j]);
                sum += ele[j];
                if (q.size() == length) {
                   set.add(sum);
                } 
                length++;
            }
        }
        return set.size();
    }
    
}
