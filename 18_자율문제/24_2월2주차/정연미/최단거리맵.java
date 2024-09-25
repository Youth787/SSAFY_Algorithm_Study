import java.util.*;

class Solution {
    int[][] dir = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};

    public int solution(int[][] maps) {
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length]; // 1. 방문처리 배열 생성

        BFS(maps,visited); // 2. BFS 함수 돌기
        answer = visited[maps.length-1][maps[0].length-1];

        if(answer==0){
            answer = -1;
        }
        return answer;
    }

    public void BFS(int[][] maps, int[][] visited){
        int x = 0;
        int y = 0;
        visited[x][y] = 1; // 3. 첫번째 인덱스 방문처리
        Queue<int[]> queue = new LinkedList<>(); // 4. 큐 생성
        queue.add(new int[]{x,y}); // 5. 큐에 첫번째 원소 넣기

        while(!queue.isEmpty()){ // 6. while문 돌기.
            int[] current = queue.poll(); // 7. 첫번째 원소 큐에서 뽑기
            int cx = current[0];
            int cy = current[1];

            for(int k=0; k<4; k++){
                int nx = cx+dir[k][0];
                int ny = cy+dir[k][1];

                if(nx>=0 && nx <maps.length && ny >=0 &&ny<maps[0].length){
                    if(visited[nx][ny]==0 && maps[nx][ny]==1){ // 8. 조건에 부합하는지 검사
                        visited[nx][ny] = visited[cx][cy]+1; // 9. 부합하면 해당 인덱스 방문처리
                        queue.add(new int[]{nx,ny}); // 10. 해당 인덱스 큐에 넣기
                    }
                }
            } // dir end
        }// while end
    }// bfs end
}