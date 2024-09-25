//백준 이중우선순위큐 자바
//TreeMap활용
//TreeMap은 이진트리를 기반으로 한 Map 컬렉션이다.
// TreeSet과의 차이점은 TreeSet은 값만 저장 한다.

// 하지만 TreeMap은 키와 값의 쌍으로 이루어진 데이터를 저장한다.
// 그래서 검색과 정렬에 적합한 컬렉션 클래스이다.

// TreeMap은 일반적으로 HashMap보다 성능이 떨어진다.
// TreeMap은 데이터를 저장할 때 즉시 정렬하기에 추가나 삭제가 HashMap보다 오래 걸린다.
// 하지만 정렬된 상태로 Map을 유지해야 하거나 정렬된 데이터를 조회해야 하는 범위 검색이 필요한 경우 TreeMap을 사용하는 것이 효율성면에서 좋다.
// 이 문제는 최소값, 최대값을 알아야 하니 트리맵이 아주 적합한 문제

import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                String[] str = br.readLine().split(" ");
                if (str[0].equals("D")) {
                    if (map.isEmpty()) continue;
                    int type = Integer.parseInt(str[1]);
                    int num = 0;
                    if (type == 1) num = map.lastKey();
                    else num = map.firstKey();
                    if (map.put(num, map.get(num) - 1) == 1) {
                        map.remove(num);
                    }

                } else {
                    int num = Integer.parseInt(str[1]);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            if (map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(map.lastKey() + " " + map.firstKey());
        }
    }

}
