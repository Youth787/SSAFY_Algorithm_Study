class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        // x*y = b+y
        // (x-2)*(y-2) = y
        // x>=3
        // y>=3
        
        int total = brown + yellow;
        out : for(int i=(int)Math.sqrt(total); i<=total; i++){
            if(total%i==0){
                 if(i>=total/i && i>=3 && total/i>=3) {
                    int x = i;
                    int y = total/i;
                    if((x-2)*(y-2) == yellow){
                         answer = new int[]{x,y};
                         break out;
                    }
                 } else continue;
            }
        }
        
        return answer;
    }
}
