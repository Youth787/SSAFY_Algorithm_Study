class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        
        int aa = a;
        int bb = b; //input 값 직접 건들이기 싫어서
        while (aa != bb) {           
            // num /= 2; // num 개 경기로 나뉨
            aa = (aa+1)/2;
            bb = (bb+1)/2; // 몇번째 경기인지 확인
            if (aa == bb) {
                return answer;
            }
            answer++; //다음 라운드
        }
        return answer;
    }
}
