import  java.util.HashMap;
import  java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        // HashMap<Character, int[]> location = new HashMap<>();
        // location.put('U', new int[]{-1,0});
        // location.put('D', new int[]{1,0});
        // location.put('R', new int[]{0,1});
        // location.put('L', new int[]{0,-1});
        int r = 5;
        int c = 5;
        HashSet<String> answer = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            char now = dirs.charAt(i);
            int nr = r;
            int nc = c;
            if (now == 'U') nr--;
            else if (now == 'D') nr++;
            else if (now == 'L') nc--;
            else nc++;
            
            if (nr < 0 || nr >= 11 || nc < 0 || nc >= 11) {
                continue;
            }
            
            answer.add(r + " " + c + " " + nr + " " + nc);
            answer.add(nr + " " + nc+ " " +r + " " + c);
            
            r = nr;
            c = nc;
        }
        return answer.size()/2;
    }
}
