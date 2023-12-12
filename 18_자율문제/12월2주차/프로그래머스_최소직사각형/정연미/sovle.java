class 최소직사각형 {
    public int solution(int[][] sizes) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            max1 = Math.max(max1,sizes[i][0]);
            max2 = Math.max(max2,sizes[i][1]);
        }    
        return max1 * max2;
    }
}