//프로그래머스 순위 자바
//플로이드 와샬 알고리즘 아래 설명 - 경 출 도

class Solution {
    public int solution(int n, int[][] results) {
        int[][] winlose = new int[n + 1][n + 1];
        for (int[] result: results) {
            winlose[result[0]][result[1]] = 1;
            winlose[result[1]][result[0]] = -1;
        }
        //출발
        for (int i = 1; i <= n; i++) {
            //도착
            for (int j = 1; j <= n; j++) {
                //경유
                for (int k = 1; k <= n; k++) {
                    if (winlose[i][k] == 1 && winlose[k][j] == 1) {
                        winlose[i][j] = 1;
                        winlose[j][i] = -1;
                    } 
                    if (winlose[i][k] == -1 && winlose[k][j] == -1) {
                        winlose[i][j] = -1;
                        winlose[j][i] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j <= n; j++) {
                if (winlose[i][j] != 0) cnt++;
            }
            if (cnt == n - 1) answer++;
        }
        
        return answer;
    }
}


//플로이드 와샬 알고리즘
// n명의 선수가 있을 때 나를 제외한 n-1명과의 경기 결과를 알면 나의 순위를 알 수 있다.
// 위의 예제에서 보았듯이 5명의 선수 중 4위 선수에게 패배했을 때 나의 순위는 5위가 된다. n-1명과 경기를 안 펼쳐도 내 순위를 알 수 있다.

// 예시로 b선수가 a선수를 이겼다. a선수는 c선수를 이겼다. 그렇다면 b선수와 c선수는 경기를 치루지 않아도 선수가 c선수보다 순위가 높다.
// 즉, b > a && a > c 이면 b > c이다.

// 이를 이용하여 플로이드 와샬 알고리즘을 수행한 후 한 선수에 대해 n-1 선수의 승/패 정보를 알면 순위를 알 수 있다.
