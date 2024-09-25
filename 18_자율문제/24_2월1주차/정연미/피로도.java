class Solution {
    int ans =0;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        npn(k, dungeons, 0);
        return ans;
    }
    public void npn(int tired, int[][] dungeons, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(!visit[i] && tired>=dungeons[i][0]) {
                visit[i] = true;
                npn(tired-dungeons[i][1], dungeons, cnt+1);
                visit[i] = false;
            }
        }
        ans = Math.max(ans,cnt);
    }
}