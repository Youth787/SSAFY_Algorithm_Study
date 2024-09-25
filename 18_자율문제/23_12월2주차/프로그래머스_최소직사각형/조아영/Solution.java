
//https://velog.io/@guswls159357/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4java-%EC%B5%9C%EC%86%8C%EC%A7%81%EC%82%AC%EA%B0%81%ED%98%95
//이해 안 되는 부분 : 이렇게 하는 것보다 테트리스 하는 게 더 최솟값 될 수 있지 않나?? 
class Solution {
    public int solution(int[][] sizes) {
        int max_row = 0; //가로의 최대 길이
        int max_col = 0; // 세로의 최대 길이
        
        for(int i=0;i<sizes.length;i++){ //긴 부분을 가로로 재배치
            if(sizes[i][0]<sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            if(max_row<sizes[i][0]) max_row = sizes[i][0]; // 최대값
            if(max_col<sizes[i][1]) max_col = sizes[i][1]; // 최대값
        }  
        return max_col*max_row; //결과
    }
}
