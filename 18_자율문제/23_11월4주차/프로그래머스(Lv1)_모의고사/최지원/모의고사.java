import java.util.*;

class 모의고사 {
    public int[] solution(int[] answers) {
    	
        //규칙
        int [] sp1 = {1,2,3,4,5};
        int [] sp2 = {2,1,2,3,2,4,2,5};
        int [] sp3 = {3,3,1,1,2,2,4,4,5,5};
        
        //점수 저장
        int [] score = {0,0,0};

        //answers = 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == sp1[i%5]) {
            	score[0]++;            	
            }
            if(answers[i] == sp2[i%8]) {
            	score[1]++;
            }
            if(answers[i] == sp3[i%10]) {
            	score[2]++;
            }
        }//채점
       
        int max = Math.max(score[0], Math.max(score[1], score[2]));//가장 많이 맞은 경우
        
        //가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return
        List <Integer> list = new ArrayList <>();
        for (int i = 0; i<score.length; i++) {
        	if(max == score [i]) {
        		list.add(i+1);
        	}
        }
        
        int [] answer = new int [list.size()];
        for (int i = 0; i < list.size(); i++){
            answer [i] = list.get(i);
        }
        return answer;
      
    }//solution
}//class
