class Solution {
    static boolean[] visit;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];

        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public static void dfs(String now, String target, String[] words, int cnt) {
        // 원하는 단어와 같아지면
        if (now.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            // 이미 쓴 단어면 넘어가기
            if (visit[i]) {
                continue;
            }

            // 단어끼리 다른 개수 찾기
            int k = 0;
            for (int j = 0; j < now.length(); j++) {
                if (now.charAt(j) != words[i].charAt(j)) {
                    k++;
                }
            }

            // 다른게 1개라면 탐색
            if (k == 1) {
                visit[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visit[i] = false;
            }
        }
    }
}
