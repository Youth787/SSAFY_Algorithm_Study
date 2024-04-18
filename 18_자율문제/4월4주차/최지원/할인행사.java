import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        //특정일에 회원가입하면 받을 수 있는 품목, 품목 개수 해시 맵으로 만들기
        int answer = 0;
        HashMap<String, Integer> wantmap = new HashMap<>();
        for (int i=0;i<want.length;i++){
            wantmap.put(want[i],number[i]);
        }
        for (int i=0;i<discount.length-9;i++){
            HashMap<String, Integer> discountInfo = new HashMap<>();
            for (int j=i;j<i+10;j++){
                if (wantmap.containsKey(discount[j])){
                    discountInfo.put(discount[j],discountInfo.getOrDefault(discount[j], 0)+1);
                }
            }
            
            if (discountInfo.equals(wantmap)){
                answer++;
            }
        }  
        return answer;
    }
}
