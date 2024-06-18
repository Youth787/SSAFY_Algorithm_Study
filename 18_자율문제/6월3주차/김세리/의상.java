import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
      // 내가 처음에 푼 풀이
        // int answer = 1;
        
        // HashMap<String,Integer>map=new HashMap<>();
        // int n = clothes.length;
        // for(int i=0;i<n;i++){
        //     if(map.containsKey(clothes[i][1])) {
        //         int tmp = map.get(clothes[i][1]);
        //       // put에서 이미 값이 존재한다면 뒤짚어쓰므로 remove를 하지 않아도 된다
        //         map.remove(clothes[i][1]);
        //         map.put(clothes[i][1],tmp+1);
        //     }
        //     else {
        //         map.put(clothes[i][1],1);
        //     }
        // }
        // for(String key : map.keySet()){
        //     answer = answer * (map.get(key)+1);
        // }
        // // 모두 다 안입는 경우는 빼줘야 하므로 -1 해준다
        // answer--;
        // return answer;

      // 더 효율적인 풀이
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

      // map.values()는 해시맵의 값들을 Collection 형태로 반환
      // stream()은 이 Collection을 스트림으로 변환
      
      // reduce는 스트림의 모든 요소를 하나의 값으로 합친다
      // 1은 초기값.
      // (acc, count) -> acc * (count + 1)는 람다식으로,
      // 누적기(accumulator)와 현재 값(count)을 인수로 받아 새로운 누적값을 반환

        int answer = map.values().stream()
                            .reduce(1, (acc, count) -> acc * (count + 1));
      
        answer--;
        return answer;
    }
}
