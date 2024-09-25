class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int section = 0;
        
        for(int i = 0; i <= stations.length; i++){
            if(i == 0){ //구간 시작부터 ~ 첫번째 기지국 구간

                section = stations[i] - 1 - w;
                
            }
            else if(i == stations.length){//마지막 기지국 ~ 구간 끝 구간
                section = n - stations[i - 1] - w;
            }
            else{//기지국들 사이의 구간
                section = stations[i] - stations[i - 1] - 2 * w - 1; 
            }
            
            if (section >= 0) {
                answer += section / (2 * w + 1);
                    
                if (section % (2 * w + 1) != 0) {
                    answer++;
                    }
            }
        }
        return answer;
    }
}
