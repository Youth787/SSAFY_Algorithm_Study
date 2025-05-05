class Solution {
    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];
        int num=1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j] = num++;
            }
        }
        int[] answer = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            answer[i] = rotate(queries[i][0]-1,queries[i][1]-1,queries[i][2]-1,queries[i][3]-1);
        }
        
        return answer;
    }
    static int rotate(int x1, int y1, int x2, int y2){
        int temp = arr[x1][y1];
        int min = temp;
        
        for(int i=x1;i<x2;i++){
            arr[i][y1] = arr[i+1][y1];
            min = Math.min(min,arr[i][y1]);
        }
        for(int i=y1;i<y2;i++){
            arr[x2][i] = arr[x2][i+1];
            min = Math.min(min,arr[x2][i]);
        }
        for(int i=x2;i>x1;i--){
            arr[i][y2] = arr[i-1][y2];
            min = Math.min(min,arr[i][y2]);
        }
        for(int i=y2;i>y1;i--){
            arr[x1][i] = arr[x1][i-1];
            min = Math.min(min,arr[x1][i]);
        }
        arr[x1][y1+1] = temp;
        return min;
        
    }
}
