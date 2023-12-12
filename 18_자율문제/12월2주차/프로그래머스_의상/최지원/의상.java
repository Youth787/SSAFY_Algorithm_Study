//해시맵에는 아직도 모르는 메서드가 넘 많아여... https://gre-eny.tistory.com/97
import java.util.HashMap;

class 의상 {
    public int solution(String[][] clothes) {
    	//의상 종류 별로 몇개 있는지 확인 하고, (개수+1)곱-1하면 됨: +1하는건 그거 안입을 때, -1하는건 아무것도 안입을 때
    	
    	//{의상 이름, 의상 종류}
        HashMap<String, Integer> map = new HashMap<>();
        //key = 의상 종류, value = 의상 수
        
        for (String[] cloth : clothes) {//의상 배열에서 하나씩
            String cType = cloth[1]; //의상 종류
            //HashMap의 getOrDefault(Object key, V DefaultValue) 메서드
            //key = 값을 가져와야 하는 요소의 키
            //defaultValue = 지정된 키로 매핑된 값이 없는 경우 반환되는 기본값 설정
            map.put(cType, map.getOrDefault(cType, 0) + 1);//옷 개수++
        }

        int ans = 1;//곱셈 해야되니까 1로

        //HashMap의 keySet 메서드 : 모든 키를 포함하는 집합 Set 반환
        for (String key : map.keySet()) {//의상 종류 하나씩 확인
            ans *= (map.get(key) + 1);//이 종류는 아예 안입거나 + 하나 골라 입거나 하는 경우의 수
        }
        
        return ans - 1;//적어도 하나는 입어야 함
    }
}
