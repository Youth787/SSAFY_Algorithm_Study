import java.util.HashMap;
/*
 * participant(1~100,000) 중 완주(completion)하지 못한 선수 이름 return
 * 동명이인 가능 => HashMap에서 이름을 Key값으로 가져야한다
 */
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap <String, Integer> hashmap = new HashMap<>();
        for (String name : completion) {
            hashmap.put(name, hashmap.getOrDefault(name, 0) + 1);
        }
        
        for (String name : participant) {
            if (hashmap.getOrDefault(name, 0) == 0) {
                return name; //0 = default 값 = 완주 못한 사람
            }
            hashmap.put(name, hashmap.get(name) -1);
        }
        
        return null;
    }
}
