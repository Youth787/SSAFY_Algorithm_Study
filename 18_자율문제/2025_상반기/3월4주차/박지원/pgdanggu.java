//프그 당구연습 자바
//구현 + 수학공식

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
         int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int now = 0; 
            int result = Integer.MAX_VALUE;

            // 원 쿠션이므로
            // x축의 경우
            // 시작 지점에서부터 0 또는 m까지 이동 거리 + 0 또는 m에서부터 타겟까지의 거리를 제곱해야 하고
            // y축의 경우
            // 시작 지점에서부터 0 또는 n까지 이동 거리 + 0 또는 n에서부터 타겟까지의 거리를 제곱해야 함


            // 좌측으로 이동할 경우
            // x축의 0에서 startX까지의 거리
            // x축의 0에서 targetX까지의 거리
            // 이 두가지 거리를 더해서 제곱을 해줘야 함
            if (!(startY == targetY && startX >= targetX)) {
                now = distance(startX, startY, targetX * (-1), targetY);
                result = Math.min(now, result);
            }

            // 우측으로 이동할 경우
            // startX에서 m까지의 거리
            // m에서 targetX까지의 거리
            // 이 두가지 거리를 더해서 제곱을 해줘야 함
            if (!(startY == targetY && startX <= targetX)) {
                now = distance(startX, startY, m + (m - targetX), targetY);
                result = Math.min(now, result);
            }

            // 상
            if (!(startX == targetX && startY <= targetY)) {
                now = distance(startX, startY, targetX, n + (n - targetY));
                result = Math.min(now, result);
            }

            // 하
            if (!(startX == targetX && startY >= targetY)) {
                now = distance(startX, startY, targetX, targetY * (-1));
                result = Math.min(now, result);
            }

            answer[i] = result;
        }

        return answer;
    }
        // 거리를 구하는 공식
    // Math.sqrt(Math.pow((maxX - minX)) + Math.pow((maxY - minY)))
    // 여기서는 거리에 제곱을 한다 했으므로
    // Math.pow((maxX - minX)) + Math.pow((maxY - minY))
    public static int distance(int sx, int sy, int tx, int ty) {
        return (int) (Math.pow(sx - tx, 2) + Math.pow(sy - ty, 2));
    }
}
