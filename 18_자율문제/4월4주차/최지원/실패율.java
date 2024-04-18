import java.util.HashMap;
/*
 * 실패율 = 클리어 못한 수 / 도달 수
 * 실패율이 높은 스테이지(1~)부터 내림차순
 */
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] people = new int[N+2];
        for (int i = 0; i < stages.length; i++) {
            people[stages[i]]++;
        }
        
        HashMap <Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        
        for (int i = 1; i <= N; i++) {
            if (people[i] == 0) {
                fails.put(i,0.);
            } else {
                fails.put(i, people[i]/total);
                total -= people[i];
            }
        }
        
        return fails.entrySet().stream().sorted((o1,o2)->Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}
