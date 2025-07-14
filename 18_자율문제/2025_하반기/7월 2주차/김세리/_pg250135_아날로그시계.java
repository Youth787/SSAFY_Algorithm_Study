int start = toSecond(h1, m1, s1);
        int end = toSecond(h2, m2, s2);
        return countAlarm(end) - countAlarm(start) + (alarmNow(start) ? 1 : 0);
    }

    // 총 알람 횟수 계산 (0 ~ t초까지)
    int countAlarm(int t) {
        // 분침-초침 만남: 3600초(1시간)에 59번(초침이 한 바퀴 더 빠름) 겹침
        int sm = t * 59 / 3600;

        // 시침-초침 만남: 43200초(12시간)에 719번 겹침
        int sh = t * 719 / 43200;

        // 12:00:00, 즉 43200초는 두 번 세었으므로 중복 빼기
        int dup = t >= 43200 ? 2 : 1;

        return sm + sh - dup;
    }

    // 알람이 '딱 지금' 울리는 순간인지
    boolean alarmNow(int t) {
        return t * 59 % 3600 == 0 || t * 719 % 43200 == 0;
    }

    int toSecond(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }
}
