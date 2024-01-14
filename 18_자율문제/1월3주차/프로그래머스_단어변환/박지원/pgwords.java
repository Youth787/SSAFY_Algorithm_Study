import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);    
        
        return answer;
    }
    static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            int check = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    check++;
                }
            }
            if (check == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}

//https://velog.io/@hammii/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%A8%EC%96%B4-%EB%B3%80%ED%99%98-java
//https://velog.io/@rari_1110/DFS-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%A8%EC%96%B4%EB%B3%80%ED%99%98-JAVA
//단어를 바꾸는 것이 아닌, 갯수를 세서 풀면 편하다!!
//한 글자 빼고 나머지가 같은 단어를 words에서 찾는다.
// 찾은 단어를 visited = true 로 설정해 준다.
// cnt를 증가시키며 dfs 함수를 재귀 호출한다.
// 모든 경우의 수를 보기 위해 visited = false로 재설정한다.
// begin과 target이 같은 경우, cnt를 answer에 대입하고 종료한다.
