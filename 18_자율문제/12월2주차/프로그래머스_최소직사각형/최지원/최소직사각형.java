class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;
        int maxH = 0;
        int w = 0;//그냥 긴거
        int h = 0;//작은거
        for (int i = 0; i < sizes.length; i++){
            w = Math.max(sizes[i][0],sizes[i][1]);
            h = Math.min(sizes[i][0],sizes[i][1]);
            if (maxW < w){
                maxW = w;
            }
            if (maxH < h){
                maxH = h;
            }
        }
        
        answer = maxW*maxH;
        
        return answer;
    }
}
