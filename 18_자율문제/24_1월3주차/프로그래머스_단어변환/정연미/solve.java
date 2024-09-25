package Algo_스터디.Jan_3주차;

class Solution {
    static int answer=0;
    static boolean[] visit;
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        DFS(begin, target, words, 0);
        return answer;
    }
    public static void DFS(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            answer = cnt;
            return;
        }

        for(int i=0; i<words.length; i++){
            if(visit[i]){
                continue;
            }

            int count =0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j)==words[i].charAt(j)){
                    count++;
                }
            }

            if(count == begin.length()-1){
                visit[i] = true;
                DFS(words[i],target, words,cnt+1);
                visit[i]= false;
            }
        }
    }
}