package _20240911;

import java.util.*;

public class _21939_문제추천시스템Version1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TreeSet: 문제의 레벨과 문제 번호를 관리
        TreeSet<int[]> problems = new TreeSet<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]); // 레벨이 같으면 문제 번호로 정렬
            }
            return Integer.compare(o1[0], o2[0]); // 레벨 기준으로 정렬
        });

        // HashMap: 문제 번호로 빠르게 문제의 레벨에 접근
        Map<Integer, Integer> map = new HashMap<>();
        
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int qNum = sc.nextInt();
            int qLevel = sc.nextInt();
            problems.add(new int[]{qLevel, qNum});
            map.put(qNum, qLevel);
        }
        
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            String command = sc.next();

            if (command.equals("add")) {
                // 문제 추가
                int qNum = sc.nextInt();
                int qLevel = sc.nextInt();
                problems.add(new int[]{qLevel, qNum});
                map.put(qNum, qLevel);
            } else if (command.equals("recommend")) {
                // 추천 명령
                int x = sc.nextInt();
                if (x == 1) {
                    // 가장 어려운 문제 출력
                    System.out.println(problems.last()[1]); // 가장 큰 값
                } else {
                    // 가장 쉬운 문제 출력
                    System.out.println(problems.first()[1]); // 가장 작은 값
                }
            } else if (command.equals("solved")) {
                // 문제 해결
                int qNum = sc.nextInt();
                int qLevel = map.get(qNum); // 문제 번호에 해당하는 레벨 가져오기
                problems.remove(new int[]{qLevel, qNum}); // 문제 제거
                map.remove(qNum); // HashMap에서도 삭제
            }
        }
        sc.close();
    }
}
