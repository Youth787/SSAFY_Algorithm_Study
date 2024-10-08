class Solution {
    public int solution(int n, int[][] results) {
        // 플로이드-위셜 알고리즘 사용
        int[][] graph = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j){
                // 자기 자신과의 경기는 0
                    graph[i][j]=0;
                } else {
                // 초기화 값 입력
                    graph[i][j]=100000;
                }
            }
        }
        
        // 결과 반영, 승리한 경우 1, 패배한 경우 -1, 나머지는 0
        for(int[] result: results){
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = 1;
            graph[loser][winner] =-1;
        }
        
        // 플로이드-위셜 알고리즘 이용하여 모든 선수의 관계를 개선
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    // i 선수가 k 선수를 이기고, k 선수가 j 선수를 이기면 i 선수가 j 선수를 이김
                    if(graph[i][k]==1 && graph[k][j]==1){
                        graph[i][j]=1;
                    }
                    // i 선수가 k 선수에게 지고, k 선수가 j 선수에게 졌다면 i 선수가 j 선수에게 짐
                    if(graph[i][k]==-1 && graph[k][j]==-1){
                        graph[i][j]=-1;
                    }
                }
            }
        }
        
        // 순위 확정된 선수 계산
        int answer = 0;
        for(int i=1;i<=n;i++){
            int count =0;
            for(int j=1;j<=n;j++){
                if(graph[i][j] != 100000 || graph[j][i] != 100000){
                    count++;
                }
            }
            // 불확실한 관계가 없다는 의미
            if(count==n){
                answer++;
            }
        }
        return answer;
    }
}
