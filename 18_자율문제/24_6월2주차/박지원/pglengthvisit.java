//프로그래머스 방문길이 java
//생각보다 어려웠따ㅎ.ㅎ set을 사용해서 이전의 점 -> 이동한 점의 선과 이동한 점 -> 이전의 점 두가지를 set에 넣어주고 answer++
//그리고 점이 이동하지 않았다면 그냥 넘어가기.

import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<String> visited = new HashSet<>();
    static int answer = 0;
    static int[] point = {5, 5};
    public int solution(String dirs) {
        visited  = new HashSet<>();
        answer = 0;
        point[0] = 5;
        point[1] = 5;
        for (int i = 0; i < dirs.length(); i++) {
            move(dirs.charAt(i));            
        }
        return answer;
    }
    static void move(char c) {
        int[] prevPoint = point.clone(); // 이전 위치 저장
        switch (c) {
            case 'U':
                if (point[0] > 0) point[0]--;
                break;
            case 'D':
                if (point[0] < 10) point[0]++;
                break;
            case 'L':
                if (point[1] > 0) point[1]--;
                break;
            case 'R':
                if (point[1] < 10) point[1]++;
                break;
        }
        
        // 현재 경로를 문자열로 저장
        String path1 = prevPoint[0] + "," + prevPoint[1] + "->" + point[0] + "," + point[1];
        String path2 = point[0] + "," + point[1] + "->" + prevPoint[0] + "," + prevPoint[1];
        
        // 경로가 고유한지 확인
        if (!visited.contains(path1) && !visited.contains(path2)) {
            if (!path1.equals(path2)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }
            
        }
    }
}
