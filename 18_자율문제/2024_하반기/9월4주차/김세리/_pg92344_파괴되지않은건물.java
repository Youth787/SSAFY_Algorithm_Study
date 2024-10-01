class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        
        // 누적합을 위한 보조 배열 생성
        int[][] acc = new int[n + 1][m + 1];
        
        // 스킬 적용
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4];
            int degree = s[5];
            
            // 공격(1)은 음수, 회복(2)은 양수로 처리
            if (type == 1) degree = -degree;
            
            // 누적합 배열에 변화를 기록
            acc[r1][c1] += degree;
            acc[r1][c2 + 1] -= degree;
            acc[r2 + 1][c1] -= degree;
            acc[r2 + 1][c2 + 1] += degree;
        }
        
        // 누적합을 계산 (행 방향)
        for (int r = 0; r < n; r++) {
            for (int c = 1; c < m; c++) {
                acc[r][c] += acc[r][c - 1];
            }
        }
        
        // 누적합을 계산 (열 방향)
        for (int c = 0; c < m; c++) {
            for (int r = 1; r < n; r++) {
                acc[r][c] += acc[r - 1][c];
            }
        }
        
        // 누적합을 board에 반영하면서 살아남은 건물 카운트
        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                board[r][c] += acc[r][c];
                if (board[r][c] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}


// 효율성 다 실패 뜬 코드ㅎㅎ

// class Solution {
//     public int solution(int[][] board, int[][] skill) {
//         int answer = board.length * board[0].length;
        
//         for(int i=0;i<skill.length;i++){
//             int type = skill[i][0];
//             int r1 = skill[i][1];
//             int c1 = skill[i][2];
//             int r2 = skill[i][3];
//             int c2 = skill[i][4];
//             int degree = skill[i][5];
            
//             if(type==1){
//                 for(int r=r1;r<=r2;r++){
//                     for(int c=c1;c<=c2;c++){
//                         boolean chk=false;
//                         if(board[r][c]<=0) chk=true;
                        
//                         board[r][c]= board[r][c]-degree;
//                         if(!chk && board[r][c]<=0) answer--;
//                     }
//                 }
//             }
//             else if(type==2){
//                 for(int r=r1;r<=r2;r++){
//                     for(int c=c1;c<=c2;c++){
//                         boolean chk=false;
//                         if(board[r][c]<=0) chk=true;
                        
//                         board[r][c]= board[r][c]+degree;
//                         if(chk && board[r][c]>0) answer++;
//                     }
//                 }
//             }
//         }
        
//         return answer;
//     }
// }
