class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = toSec(play_time);
        int advSec = toSec(adv_time);

        long[] timeline = new long[playSec + 2];

        // 시청 로그를 누적합용 배열에 기록
        for (String log : logs) {
            String[] times = log.split("-");
            int start = toSec(times[0]);
            int end = toSec(times[1]);
            timeline[start]++;
            timeline[end]--;
        }

        // 1. 초 단위로 시청자 누적 (누적합)
        for (int i = 1; i <= playSec; i++) {
            timeline[i] += timeline[i - 1];
        }
        // 2. 누적 시청 시간 (1초 전까지의 합)
        for (int i = 1; i <= playSec; i++) {
            timeline[i] += timeline[i - 1];
        }

        // 3. 광고 구간별 누적합 최댓값 탐색
        long maxView = timeline[advSec - 1];
        int maxStart = 0;
        for (int i = advSec; i <= playSec; i++) {
            long curView = timeline[i] - timeline[i - advSec];
            if (curView > maxView) {
                maxView = curView;
                maxStart = i - advSec + 1;
            }
        }

        return toTime(maxStart);
    }

    int toSec(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 3600 +
               Integer.parseInt(t[1]) * 60 +
               Integer.parseInt(t[2]);
    }

    String toTime(int sec) {
        int h = sec / 3600;
        int m = (sec % 3600) / 60;
        int s = sec % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
