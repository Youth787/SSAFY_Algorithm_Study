class Solution {
    public int solution(int n, int[] stations, int w) {

      //내가 푼 오류코드 테케 11개추가했는데도 안풀리네 아오 뭐가 잘못된거지!!!
//         int answer = 0;
//         int left = 1;
//         for (int station: stations) {
//             if (left < station) {
//                 int cnt = station - left - w;
//                 if (cnt != 0) {
//                     if (cnt % (2 * w + 1) == 0) answer += cnt / (w * 2 + 1);
//                     else answer += cnt / (2 * w + 1) + 1;
//                 }
//             } 
//             left = station + w + 1;
//         }
//         if (left < n) {
//             answer += (n - left - w) / (w * 2 + 1) + 1;    
//         } else if (left == n) {
//             answer++;
//         } 
        
//         return answer;
        int answer = 0;
            int leftStart = 1;

            for (int sub : stations) {
                if (leftStart < sub - w) {
                    int leftEnd = sub - w;

                    int length = leftEnd - leftStart;

                    int count = length / (w * 2 + 1);
                    if (length % (w * 2 + 1) != 0)
                        count++;

                    answer += count;
                }

                leftStart = sub + w + 1;
            }

            if(stations[stations.length-1] + w < n){
                leftStart = stations[stations.length-1] + w + 1;

                int leftEnd = n + 1;

                int length = leftEnd - leftStart;

                int count = length / (w * 2 + 1);
                if (length % (w * 2 + 1) != 0)
                    count++;

                answer += count;
            }

            return answer;
    }
}
