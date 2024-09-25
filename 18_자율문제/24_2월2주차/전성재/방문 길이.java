import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> s = new HashSet<String>();  //중복확인 위해 사용하는 set
        
        int len = dirs.length();
        
        int nowX = 0;
        int nowY = 0;
        
        for(int i=0; i<len; i++){
            int nextX = nowX;
            int nextY = nowY;
            String road = "";       //경로 저장할 문자열
            // U : "현재 좌표"+"이동 후 좌표"
            if(dirs.charAt(i) == 'U'){
                nextY++;
                road += nowX;
                road += nowY;
                road += nextX;
                road += nextY;
            }
            // D :  "이동 후 좌표" + "현재 좌표"
            else if(dirs.charAt(i) == 'D'){
                nextY--;
                road += nextX;
                road += nextY;
                road += nowX;
                road += nowY;
            }
            // R : "현재 좌표"+"이동 후 좌표"
            else if(dirs.charAt(i) == 'R'){
                nextX++;
                road += nowX;
                road += nowY;
                road += nextX;
                road += nextY;
            }
            // L :  "이동 후 좌표" + "현재 좌표"
            else if(dirs.charAt(i) == 'L'){
                nextX--;
                road += nextX;
                road += nextY;
                road += nowX;
                road += nowY;
            }
            
            //범위 벗어나면 무시
            if(nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5)
                continue;
            
            s.add(road);
            nowX = nextX;
            nowY = nextY;
        }
        answer = s.size();
        return answer;
    }
}
