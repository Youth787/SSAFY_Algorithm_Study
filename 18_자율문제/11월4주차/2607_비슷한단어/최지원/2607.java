import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//입력 : 단어 개수, 기준 단어, 나머지 단어들
//[같은 구성] 같은 종류 문자 같은 개수만큼 <-> [비슷한 단어] 같은 구성 + 한 문자를 더하고빼고교체 
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
                    cnt++;//+1
                    chk[idx]--;//하나 깎고
                }
            }
            
            //확인하는 과정
            if(str.length()-1 == nowStr.length()){ //기준 단어에서 알파벳 하나 빼기
            	if(cnt == nowStr.length()) {
            		ans++;
            	}
            } else if(str.length()+1 == nowStr.length()){//새로운 단어에서 알파벳 하나 더하기
            	if(cnt == str.length()) {
            		ans++;
            	}
            } else if(str.length() == nowStr.length()){//새로운 단어의 알파벳 하나 교환
            	if(cnt == str.length()) {
            		ans++;
            	}
            	else if(cnt == str.length()-1) {
            		ans++;
            	}
            }
			
		}
		System.out.println(ans);
	}//main
}//class
