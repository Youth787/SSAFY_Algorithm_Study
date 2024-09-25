import java.util.*;

//프로그래머스 모음사전 LV2
//아예 이걸 어떻게 풀지 생각이 안났던 문제 ㅠㅠ 
//완전탐색인데 이 aeiou조합을 어떤식으로 만들어야할지 생각이 안나서 찾아봤음. 근데 dfs였음..역시 재귀는 어렵다ㅠ
class Solution {
    char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    ArrayList<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        makeString("");
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    void makeString(String str) {
        list.add(str);
        if (str.length() == 5) return;
        for (int i = 0; i < alphabet.length; i++) {
            makeString(str + alphabet[i]);
        }
    }
}
