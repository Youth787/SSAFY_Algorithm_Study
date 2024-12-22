//프로그래머스 합승 택시 요금 자바
//다익스트라 / 플로이드워셜

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] node = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                node[i][j] = 20000001; //200 * 100000 + 1
            }
            node[i][i] = 0;
        }
        
        for(int i = 0; i < fares.length; i++) {
            node[fares[i][0]][fares[i][1]] = fares[i][2];
            node[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < n + 1; j++) {
                    if(node[i][j] > node[i][k] + node[k][j]) {
                        node[i][j] = node[i][k] + node[k][j];
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n + 1; i++) {
            min = Math.min(min, node[s][i] + node[i][a] + node[i][b]);
        }
        return min;
    }
}
