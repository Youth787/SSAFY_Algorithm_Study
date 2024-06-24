class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int n = citations.length;
        int[] count = new int[n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<n;j++){
                if(citations[j]>=i){
                    count[i]++;
                }
            }
            if(count[i]>=i) answer=i;
        }
        return answer;
    }
}
