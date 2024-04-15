class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
			int targetX = balls[i][0];
			int targetY = balls[i][1];

			int curlen, len = Integer.MAX_VALUE;
         
            // 좌
			if (!(startY == targetY && startX >= targetX)) {
				curlen = getDistance(startX, startY, targetX * (-1), targetY);
				len = curlen < len ? curlen : len;
			}
            
            // 우
			if (!(startY == targetY && startX <= targetX)) {
				curlen = getDistance(startX, startY, m + (m - targetX), targetY);
				len = curlen < len ? curlen : len;
			}
            
            // 상
			if (!(startX == targetX && startY <= targetY)) {
				curlen = getDistance(startX, startY, targetX, n + (n - targetY));
				len = curlen < len ? curlen : len;
			}

			// 하
			if (!(startX == targetX && startY >= targetY)) {
				curlen = getDistance(startX, startY, targetX, targetY * (-1));
				len = curlen < len ? curlen : len;
			}
			
			answer[i] = len;
            
        }
        
        return answer;
    }
    
    public int getDistance(int sx, int sy, int tx, int ty) {
		return (int) (Math.pow(sx - tx, 2) + Math.pow(sy - ty, 2));
	}
    
}
