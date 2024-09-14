import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // words 배열에 target이 없으면 변환할 수 없음
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // BFS를 위한 큐와 방문 체크 배열
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        // 시작 단어 삽입
        queue.add(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word current = queue.poll();

            // 현재 단어가 target과 같으면 변환 완료
            if (current.word.equals(target)) {
                return current.steps;
            }

            // words 배열에서 변환할 수 있는 단어 탐색
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(current.word, words[i])) {
                    visited[i] = true; // 방문 체크
                    queue.add(new Word(words[i], current.steps + 1)); // 변환한 단어를 큐에 추가
                }
            }
        }

        // target에 도달할 수 없는 경우
        return 0;
    }

    // 두 단어가 한 글자만 다른지 확인하는 함수
    private boolean canConvert(String word1, String word2) {
        int diffCount = 0;
        for (int i=0;i<word1.length();i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false; // 1글자보다 많이 다르면 변환 불가능
            }
        }
        return diffCount == 1;
    }

    // 큐에 저장할 단어와 변환 횟수를 담은 클래스
    private class Word {
        String word;
        int steps;

        Word(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}
