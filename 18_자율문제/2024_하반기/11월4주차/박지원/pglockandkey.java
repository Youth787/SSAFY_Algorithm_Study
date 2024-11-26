//프로그래머스 자물쇠와 열쇠 자바
//lock을 확장하는게 핵심이었따.. 

import java.util.*;

class Solution {
    public boolean solution (int[][] key, int[][] lock) {
        boolean answer = false;
        //열쇠로 자물쇠를 열수 있으면 true를, 열 수 없으면 false를 return
        
        //lock을 확장
        int len = lock.length + key.length * 2 - 2;
        int[][] nl = new int[len][len];
        for (int i = key.length - 1; i < key.length + lock.length - 1; i++) {
            for (int j = key.length - 1; j < key.length + lock.length - 1; j++) {
                nl[i][j] = lock[i - key.length + 1][j - key.length + 1];
            }
        }
        
        //회전시킴
        for (int i = 0; i < 4; i++) {
            if (match(key, nl, lock.length)){
                answer = true;
                break;
            }
            else{
                //key 회전시키기
                rotate(key);
            }
        }
        
        return answer;
    }
    
    public boolean match (int[][] key, int[][] lock, int len){
        for (int i = 0; i < key.length + len - 1; i++) {
            for (int j = 0; j < key.length + len - 1; j++) { //이동
                //new lock + key
                for (int x = 0; x < key.length; x++) {
                    for (int y = 0; y < key.length; y++) {
                        lock[i + x][j + y] += key[x][y];
                    }
                }
                
                //lock이 전부 1이 되었는지 확인 - 홈이 모두 채워졌는지 + 돌기와 돌기가 만나지 않았는지
                boolean check = true;
                for (int x = key.length - 1; x < key.length + len - 1; x++) {
                    for (int y = key.length - 1; y < key.length + len - 1; y++) {
                        if (lock[x][y] != 1){
                            check = false;
                            break;
                        }
                    }
                }
                
                if (check) {
                    return true;
                }
                
                //lock 원상복구. lock - key
                for (int x = 0; x < key.length; x++) {
                    for (int y = 0; y < key.length; y++) {
                        lock[i + x][j + y] -= key[x][y];
                    }
                }
                
            }
        }
        return false;
    }
    
    public void rotate (int[][] key){
        int[][] temp = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                temp[i][j] = key[j][key.length - i - 1];
            }
        }
        
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key[i][j] = temp[i][j];
            }
        }
    }
}
