/*
 * 한 번에 한 개의 알파벳만 바꾸고 / words에 있는 단어로만 바꿀 수 있음
 * begin -> target 최소 변환 횟수 리턴
 */
class Solution {
    static boolean[] visited;
    static int answer = 0; //변환 못하면 0 반환
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        DFS(begin, target, words, 0);
        return answer;
    } //solution
    
      public static void DFS(String begin, String target, String[] words, int cnt) {
        //기저 : 단어가 같아졌다면 answer에 횟수 저장하고 리턴
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        // 현재 단어와 배열 속 단어의 스펠링이 몇개 같은지 확인하고, 
        // "한번에 한개의 알파벳만 바꿀 수 있기 때문에" 이 경우에만 그 단어로 변환했다고 생각하고 재귀로 다시 변환 시도
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            } // 이미 사용한 단어는 visited에 체크되어 있음

            int k = 0;    
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            } // 같은 스펠링 몇개인지 세기

            if (k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                visited[i] = true;
                DFS(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        } 
    } //DFS
} //class
