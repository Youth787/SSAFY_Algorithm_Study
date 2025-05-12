import java.util.*;

class Solution {
    private static final int[] WEIGHT = {781, 156, 31, 6, 1};
    private static final Map<Character, Integer> IDX 
        = Map.of('A', 0, 'E', 1, 'I', 2, 'O', 3, 'U', 4);

    public int solution(String word) {
        int pos = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            pos += IDX.get(ch) * WEIGHT[i];
        }
        return pos + word.length();
    }
}
