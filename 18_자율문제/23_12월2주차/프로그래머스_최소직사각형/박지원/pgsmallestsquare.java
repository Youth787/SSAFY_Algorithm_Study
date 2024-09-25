class Solution {
    public int solution(int[][] sizes) {
        int answer = 1;
        int longnum = 0;
        int shortnum = 0;
        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            if (a >= b) {
                longnum = Math.max(longnum, a);
                shortnum = Math.max(shortnum, b);
            } else {
                longnum = Math.max(longnum, b);
                shortnum = Math.max(shortnum, a);
            }
        }
        return answer * longnum * shortnum;
    }
}
