import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        String[] first = new String[str1.length() - 1];
        String[] second = new String[str2.length() - 1];
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z' && str1.charAt(i + 1) >= 'A' && str1.charAt(i + 1) <= 'Z') {
                first[i] = str1.substring(i, i + 2);
                
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z' && str2.charAt(i + 1) >= 'A' && str2.charAt(i + 1) <= 'Z') {
                second[i] = str2.substring(i, i + 2);
            }
        }
        int count = 0;
        int total = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < first.length; i++) {
            if (first[i] == null) continue;
            map.put(first[i], map.getOrDefault(first[i], 0) + 1);
            total++;
        }
        for (int i = 0; i < second.length; i++) {
            if (second[i] == null) continue;
            if (map.getOrDefault(second[i], -1) > 0) {
                count++;
                map.put(second[i], map.get(second[i]) - 1);
            } else if (map.getOrDefault(second[i], 0) == 0) {
                total++;
            }
        }
        
        if (count == 0 && total == 0) return 65536;
        else answer = (int) Math.floor(65536 * ((double) count / (double) total));
        return answer;
        
    }
}
