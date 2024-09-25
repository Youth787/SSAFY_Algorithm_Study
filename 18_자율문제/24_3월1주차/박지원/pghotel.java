import java.util.*;
 
//프로그래머스 호텔대실 누적합으로 푸니 훨씬 이해가 빨랐다
class Solution {
    private static final int MAX_TIME = 1450; // 24*60 + 10;
    private static final int HOUR = 60;
    private static final int CLEAN_TIME = 10; // 청소시간

    public static int solution(String[][] book_time) {
        int answer = 0;

        int[] rooms = new int[MAX_TIME];

        for (String[] time : book_time) {
            String inTime = time[0];
            String outTime = time[1];

            rooms[calTime(inTime)] += 1; // 입실 시간
            /*
              끝+1을 하지 않는 것은 seeminglyjs님의 질문에 대한 댓글을 참고해 주세요!
            */
            rooms[calTime(outTime) + CLEAN_TIME] += -1; // 퇴실 + 청소 시간
        }

        // 누적합
        for (int i = 1; i < MAX_TIME; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }

        return answer;
    }

    private static int calTime(String time){
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];
        return ((Integer.parseInt(hour) * HOUR) + Integer.parseInt(minute));
    }
}

//https://ksb-dev.tistory.com/269
