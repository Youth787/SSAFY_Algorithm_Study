package _20240911;

import java.util.*;

public class _21939_문제추천시스템Version1_pq이용 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // 최대 힙 (어려운 문제 기준)
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]); // 레벨이 같으면 문제 번호가 큰 순서대로
            }
            return Integer.compare(o2[0], o1[0]); // 레벨이 다르면 레벨이 큰 순서대로
        });
        
        // 최소 힙 (쉬운 문제 기준)
        PriorityQueue<int[]> minPq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]); // 레벨이 같으면 문제 번호가 작은 순서대로
            }
            return Integer.compare(o1[0], o2[0]); // 레벨이 다르면 레벨이 작은 순서대로
        });
        
        // 문제 번호를 저장하기 위한 HashMap
        Map<Integer, Integer> map = new HashMap<>();
        
        // 처음 주어지는 문제들 추가
        for (int i=0;i<N;i++) {
            int qNum = sc.nextInt();
            int qLevel = sc.nextInt();
            maxPq.add(new int[] {qLevel, qNum});
            minPq.add(new int[] {qLevel, qNum});
            map.put(qNum, qLevel);
        }
        
        int M = sc.nextInt();
        for (int i=0;i<M;i++) {
            String command = sc.next();
            
            if (command.equals("add")) {
                // 문제 추가
                int qNum = sc.nextInt();
                int qLevel = sc.nextInt();
                maxPq.add(new int[] {qLevel, qNum});
                minPq.add(new int[] {qLevel, qNum});
                map.put(qNum, qLevel);
            } else if (command.equals("recommend")) {
                // 추천 명령
                int x = sc.nextInt();
                if (x == 1) {
                    // 가장 어려운 문제 출력
                    while (!maxPq.isEmpty() && (map.get(maxPq.peek()[1]) == null || map.get(maxPq.peek()[1]) != maxPq.peek()[0])) {
                        maxPq.poll(); // 유효하지 않은 문제 제거
                    }
                    if (!maxPq.isEmpty()) {
                        System.out.println(maxPq.peek()[1]);
                    }
                } else {
                    // 가장 쉬운 문제 출력
                    while (!minPq.isEmpty() && (map.get(minPq.peek()[1]) == null || map.get(minPq.peek()[1]) != minPq.peek()[0])) {
                        minPq.poll(); // 유효하지 않은 문제 제거
                    }
                    if (!minPq.isEmpty()) {
                        System.out.println(minPq.peek()[1]);
                    }
                }
            } else if (command.equals("solved")) {
                // 문제 해결
                int qNum = sc.nextInt();
                map.remove(qNum); // 문제를 map에서 삭제하여 비활성화
            }
        }
        sc.close();
    }
}
