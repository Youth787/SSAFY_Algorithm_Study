import java.util.HashSet;

//중복제거는 Key만 저장하는 HashSet으로
//HashSet은 Integer(레퍼런스 타입) vs. int[]로 return해줘야 하니까 stream()으로 변환 
//sorted()로 오름차순 정렬 
//mapToInt(Integer::intValue)로 프리미티브 타입으로 변경 
//toArray()로 hashset을 배열로

class Solution {
    public int[] solution(int[] numbers) {
        HashSet <Integer> hashset = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                hashset.add(numbers[i]+numbers[j]);
            }
        }
        return hashset.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
