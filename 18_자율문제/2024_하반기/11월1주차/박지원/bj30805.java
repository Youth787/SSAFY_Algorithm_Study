//백준 사전 순 최대 공통 부분 수열 자바
//그리디 
//인덱스와 값 둘다 저장시켜놓고 큰값순으로 정렬 후 비교해주면서 정답배열에 넣기

import java.util.*;

public class Main {
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Pair> a = new ArrayList<>();
        List<Pair> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            a.add(new Pair(v, i));
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            b.add(new Pair(v, i));
        }

        List<Integer> ans = new ArrayList<>();

        // Custom comparator for sorting in descending order
        a.sort((p1, p2) -> {
            if (p1.first == p2.first) return Integer.compare(p1.second, p2.second);
            return Integer.compare(p2.first, p1.first);
        });

        b.sort((p1, p2) -> {
            if (p1.first == p2.first) return Integer.compare(p1.second, p2.second);
            return Integer.compare(p2.first, p1.first);
        });

        int idxa = 0, idxb = 0, limita = 0, limitb = 0;
        while (idxa < n && idxb < m) {
            if (a.get(idxa).first == b.get(idxb).first) {
                if (limita > a.get(idxa).second) {
                    idxa++;
                } else if (limitb > b.get(idxb).second) {
                    idxb++;
                } else {
                    limita = a.get(idxa).second;
                    limitb = b.get(idxb).second;
                    ans.add(a.get(idxa).first);
                    idxa++;
                    idxb++;
                }
            } else if (a.get(idxa).first > b.get(idxb).first) {
                idxa++;
            } else {
                idxb++;
            }
        }

        System.out.println(ans.size());
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
