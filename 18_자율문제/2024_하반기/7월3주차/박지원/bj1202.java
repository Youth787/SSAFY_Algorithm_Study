//백준 보석도둑 자바
//그리디 + PriorityQueue를 이용해서 풀자!
//class정의하는 것과 comparator사용해서 정렬하는 것을 잘 알아야할것같다.

import java.io.*;
import java.util.*;

public class Main{
    private static class Jewelry {
        int m;
        int v;

        public Jewelry(int m, int v) {
            this.m = m;
            this.v = v;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Jewelry[] jewelry = new Jewelry[n];
        int[] bags = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelry[i] = new Jewelry(m, v);
        }
      //정렬은 무게가 낮은순부터, 무게가 같다면 가치는 높은순부터
        Arrays.sort(jewelry, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry j1, Jewelry j2) {
                if (j1.m == j2.m) {
                    return j2.v - j1.v;
                }
                return j1.m - j2.m;
            }
        });

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순
        long answer = 0;
        for (int i = 0, j = 0; i < k; i++) {
            while (j < n && jewelry[j].m <= bags[i]) {
                pq.add(jewelry[j++].v);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);

    }
}


//그리디 알고리즘과 우선순위 큐를 사용하여 풀 수 있는 문제였습니다. 가방에는 보석을 최대 1개 씩만 넣을 수 있기때문에 무조건 가격이 비싼 보석을 가방에 넣어야 합니다. 
//단, 여기서 무게에 따라 넣을 수 있는 보석이 있고, 넣을 수 없는 보석이 있으므로 무게를 처리하는 것이 까다로웠습니다.
// 사실, 모든 가방에 대해 모든 보석을 검사하면 위 문제를 해결할 수 있으나, N과 K는 최대 30만이기때문에 O(9 x 10^10)으로 시간 초과가 납니다. 
//따라서 O(N^2)보다 줄이기 위해서 우선순위 큐 자료구조를 이용하기로 하였습니다.

// 전반적인 로직은 다음과 같습니다.
// 1. 보석은 무게에 대해 오름차순 정렬하되, 무게가 같을 경우 가격에 대해 내림차순 정렬한다.
// 2. 가방은 오름차순 정렬한다.
// 3. 모든 가방에 대해서 반복문을 수행한다.
// 3-1. 특정 가방의 무게보다 작은 보석의 가격을 모두 우선순위 큐에 집어넣는다. (이때, 우선순위 큐는 가격에 대해 내림차순 정렬을 해야한다.)
// 3-2. 우선순위 큐가 비어있지 않다면, 우선순위 큐에서 맨 앞 요소를 하나 빼고 그 가격을 ans에 더한다.
