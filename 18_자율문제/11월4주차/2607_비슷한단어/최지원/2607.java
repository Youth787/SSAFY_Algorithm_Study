import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//입력 : 단어 개수, 기준 단어, 나머지 단어들
//[같은 구성] 같은 종류 문자 같은 개수만큼 <-> [비슷한 단어] 같은 구성 + 한 문자를 더하고빼고교체 
// (1) 먼저 기준 단어의 알파벳 구성을 확인하고 / 각 단어마다 (2-1) 길이 체크 (2-2) 같은 알파벳이 몇개 있는지 체크
// (2-1) 만약 단어 길이가 2 이상 차이나면 [비슷한 단어] 될 수가 없음 => 단어 길이가 같거나 +- 1 차이나는 친구만 뒤로 넘어간다
// (2-2) 단어 길이가 1 차이나고 서로 다른 알파벳이 하나씩 있으면 그걸 빼거나 더하고& 단어 길이가 같고 서로 다른 알파벳이 하나 있으면 교체해서 [같은 구성 완성됨]
// 또는 이미 두 단어가 [같은 구성]인 경우
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] abc = new int [26];//기준 단어 알파벳 개수   		
		String str = br.readLine();//기준
		
		for(int i=0;i<str.length();i++) {
            		abc[str.charAt(i) - 'A']++;//몇번째 알파벳인지(0번째부터), 개수 체크
        	}
		
		int ans = 0;//답
		
		//나머지 n-1개의 단어들
		for (int i=0; i<n-1; i++) {
			//기준 배열 복사
			int [] chk = Arrays.copyOf(abc, abc.length);
			String nowStr = br.readLine();//다음 단어
			
			//단어 길이 비교
			if(Math.abs(nowStr.length() - str.length())>1) {
				continue;
			}
			
			int cnt = 0;			
            		// 비교할 문자열의 알파벳 비교
            		for(int j=0;j<nowStr.length();j++){
               			int idx = nowStr.charAt(j) - 'A';
                		if(chk[idx]>0){//찾는 알파벳이 있다면
                    			cnt++;//기준과 비교대상 단어에 공통적으로 있는 알파벳 카운트+1
                    			chk[idx]--;//하나 깎고
                		}
            		}
            
            		//확인하는 과정
            		if(str.length()-1 == nowStr.length()){ //기준 단어에서 알파벳 하나 빼기
            			if(cnt == nowStr.length()) {
            				ans++;
            			}//기준 단어가 알파벳이 하나 더 많고, 비교대상 단어의 알파벳 수와 cnt가 같다 = 다 같고 알파벳 하나 차이
            		} else if(str.length()+1 == nowStr.length()){//새로운 단어에서 알파벳 하나 더하기
            			if(cnt == str.length()) {
            				ans++;
            			}//비교대상 단어가 알파벳이 하나 더 많고, 기준 단어 알파벳 수와 cnt가 같다 = 다 같고 알파벳 하나 차이
            		} else if(str.length() == nowStr.length()){//새로운 단어의 알파벳 하나 교체
            			if(cnt == str.length()) {
            				ans++;
            			}//두 단어 길이는 서로 같은데 cnt가 기준단어 알파벳 수와 같다? = 완전히 [같은 구성]
            			else if(cnt == str.length()-1) {
            				ans++;
            			}//두 단어 길이가 같고 기준 단어 알파벳 하나 빼고 다 겹치는 경우 = (비교대상 단어에서) 혼자 다른 그 알파벳을 교체
            		}			
		}//각각 단어 확인
		
		System.out.println(ans);
	}//main
}//class
