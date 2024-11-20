package _20241119;

import java.util.*;
import java.io.*;

public class _1379_강의실2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 강의 정보를 저장할 배열
        int[][] schedule = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 강의 번호
            schedule[i][1] = Integer.parseInt(st.nextToken()); // 시작 시간
            schedule[i][2] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 시작 시간 기준으로 정렬
        Arrays.sort(schedule, Comparator.comparingInt(a -> a[1]));

        // 종료 시간을 관리할 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0])); // 종료 시간 기준
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>(); // 재사용 가능한 강의실 번호

        // 강의실 배정 결과 저장
        int[] classroom = new int[N+1];
        int roomCount = 0;

        for (int[] curr : schedule) {
            int lectureNo = curr[0];
            int start = curr[1];
            int end = curr[2];

            // 이전 강의 중 종료된 강의실을 반환
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                availableRooms.add(pq.poll()[1]);
            }

            // 강의실 배정
            if (availableRooms.isEmpty()) {
                roomCount++;
                classroom[lectureNo] = roomCount;
                pq.add(new int[] {end, roomCount});
            } else {
                int roomNo = availableRooms.poll();
                classroom[lectureNo] = roomNo;
                pq.add(new int[] {end, roomNo});
            }
        }

        // 출력
        System.out.println(roomCount);
        for (int i=1;i<=N;i++) {
            System.out.println(classroom[i]);
        }
    }
}
