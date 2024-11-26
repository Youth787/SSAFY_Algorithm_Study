class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        
        int n = lock.length;
        int m = key.length;
        int extendedSize = n + 2*(m-1);
        // 자물쇠 배열을 확장
        int[][] extendedLock = new int[extendedSize][extendedSize];
        // 확장된 자물쇠 배열 가운데에 실제 자물쇠 배치
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                extendedLock[m-1+i][m-1+j] = lock[i][j];
            }
        }
        // 열쇠를 4번 회전하며 확인
        for(int rotation=0;rotation<4;rotation++){
            // 열쇠 회전
            key = rotateKey(key);
            for(int x=0;x<=extendedSize-m;x++){
                for(int y=0;y<=extendedSize-m;y++){
                    if(canUnlock(key,extendedLock,x,y,n)){
                        // 한버이라도 true나오면 열쇠로 풀 수 있다는 의미
                        return true;
                    }
                }
            }
        }
        // 모든 경우에서 다 실패한 경우
        return false;
    }
    // 열쇠 회전
    private int[][] rotateKey(int[][] key) {
        int m = key.length;
        int[][] rotated = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                rotated[j][m-1-i] = key[i][j];
            }
        }
        return rotated;
    }
    // 열쇠 확인
    private boolean canUnlock(int[][] key, int[][] extendedLock, int startX, int startY, int lockSize){
        int m = key.length;
        int[][] tmpLock = new int[extendedLock.length][extendedLock.length];
        // 확장된 자물쇠를 복사
        for(int i=0;i<extendedLock.length;i++){
            System.arraycopy(extendedLock[i],0,tmpLock[i],0,extendedLock[i].length);
        }
        // 시작 지점에 맞춰서 열쇠 위치 배치하여 자물쇠에 더해준다
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                tmpLock[startX+i][startY+j] +=key[i][j];
            }
        }
        // 실제 자물쇠 부분을 확인해서 맞는지 확인
        // 자물쇠 위치의 값이 전부 1이면 열쇠가 맞는 것임.
        // 하나라도 안맞으면 false 반환
        for(int i=0;i<lockSize;i++){
            for(int j=0;j<lockSize;j++){
                if(tmpLock[m-1+i][m-1+j]!=1){
                    return false;
                }
            }
        }
        return true;
    }
}
