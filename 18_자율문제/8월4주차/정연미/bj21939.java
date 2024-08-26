package Algo_스터디.August_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj21939 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // treeset - 정렬과 효율적인 탐색이 필요한 경우 적합한 자료구조
        // 항상 정렬된 상태로 데이터를 유지 (자동정렬)
        // 중복을 허용하지 않는다.
        // 탐색과 삽입, 삭제에 효율적이다. 이진 탐색 트리
        // first(), last(), subset(), headset(), tailset()과 같은 메서드를 통해 특정 요소에 쉽게 접근
        // 시간복잡도 -> 삽입,삭제,탐색 모두 O(log N) 을 가진다. (N은 트리셋에 포함된 요소의 개수)
        // hashset과 비교했을때, 트리셋은 삭제,삽입,탐색에서 상대적으로 느리다. (해시셋의 평균 시간복잡도는 O(1))
        TreeSet<int[]> set = new TreeSet<>((a,b)->{
            if(a[1]!=b[1]) return a[1]-b[1];
            else return a[0] - b[0];
        });

        // hashmap - 해시 테이블을 사용하여 데이터를 저장하고 검색하는 구조
        // 빠른 데이터 접근. 시간 복잡도 O(1)
        // 중복 허용 안됨
        // 순서 보장 안됨
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<N ;i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[] problem = new int[]{P,L};
            set.add(problem);
            map.put(P,L);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if(a.equals("add")){
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int[] problem = new int[]{P,L};
                set.add(problem);
                map.put(P,L);
            }else if (a.equals("recommend")){
                int input = Integer.parseInt(st.nextToken());
                if(input==1) System.out.println(set.last()[0]);
                else System.out.println(set.first()[0]);
            }else{
                int input = Integer.parseInt(st.nextToken());
                int L = map.get(input);
                set.remove(new int[]{input,L});
                map.remove(input);
            }
        }
    }
}
