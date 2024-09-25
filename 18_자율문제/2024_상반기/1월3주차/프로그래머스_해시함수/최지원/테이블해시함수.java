/*
 * 2차원 행렬. 첫번째 column은 key, 중복x
 * col번째 column 기준오름차순 정렬/ 동일하면 key 내림차순
 * S_i = i 번째 행의 튜플에 대해 각 column 값%i 의 합
 * 주어진 범위 내의 i에서 S_i 누적해 bitwise XOR (^)한 값 해시값으로 반환
 */

class Solution {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        col -= 1; //col번째 컬럼 = 인덱스는 col-1
        row_begin -= 1;

        int finalCol = col;
        
        //정렬기준: col번째[index = col-1] column값으로 오름차순, 같다면 첫번째[index = 0] column 값으로 내림차순
        Arrays.sort(data, (o1, o2) -> {
            if (o1[finalCol] == o2[finalCol]) return o2[0] - o1[0];
            return o1[finalCol] - o2[finalCol];
        });

        //i는 begin부터 end까지 S_i
        for (int i = row_begin; i < row_end; i++) {

            int finalI = i + 1;
            int dataTotal = Arrays.stream(data[i]).map(j -> j % finalI).sum();
            //(1) stream - (2) map - (3) sum

            answer = (answer ^ dataTotal); //XOR
        }

        return answer;
    }
}
