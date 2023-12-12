import java.util.*;

class Solution {
public int solution(String[][] clothes) {
    	// HashMap은 Map 인터페이스를 구현한 클래스 중 하나로, 해시 테이블을 사용하여 키-값 쌍을 저장합니다.
    	// 키나 값으로 null을 허용하며, 중복된 키를 허용하지 않습니다.
    	
    	// length : 배열의 길이를 구할때. 
    	// length() : 문자열 객체의 메서드. 문자열의 길이를 반환한다. 
    	// size : 컬렉션 프레임워크에서 주로 사용. 컬렉션의 크기를 반환 ex) list, set, map 
    	
		int answer = 1;
	    HashMap<String, Integer> map = new HashMap<>();
	    for(int i=0; i<clothes.length; i++){
	        String key = clothes[i][1];
	        if(!map.containsKey(key)) map.put(key,1);
	        else map.put(key,map.get(key)+1);
	    }
    	
    	// System.out.println(map.keySet()); //[eyewear, headgear]
    	// System.out.println(map.values()); // [1, 2]
    	
	    Iterator<Integer> it = map.values().iterator(); 
    	while(it.hasNext()) {
    		answer *= it.next().intValue()+1;
    		// it.next()에서 반환되는 값은 Integer 객체 
    		// intValue() 메서드는 Integer 객체를 기본 자료형 int로 변환하는 메서드
    	}
    	// while(it.hasNext()) {
    	//	System.out.print(it.next().intValue()+" "); // 1 2 
    	//}
    	return answer-1;
    }
}
