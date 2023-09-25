import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 새롭고 신박하게 푼 풀이를 찾음. 
// https://aorica.tistory.com/191

public class 비밀번호발음하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "", result = "";
		String regex = "^[^aeiou]+$|[aeiou]{3,}|[^aeiou]{3,}|([^eo])\\1+";
		// 1. ^[^aeiou]+$
		// ^ : 문자열의 시작을 의미
		// $ : 문자열의 끝을 의미
		// [^aeiou] : "aeiou"를 제외한다. 
		// ^[^aeiou]+$ : 문자열이 시작부터 끝까지 모음(a, e, i, o, u)을 포함하지 않는 경우
		
		// 2. [aeiou]{3,} : 문자열에 모음이 3개 이상 연속으로 등장하는 경우
	
		// 3. [^aeiou]{3,} : 문자열에 자음(모음이 아닌 문자)이 3개 이상 연속으로 등장하는 경우
		
		// 4. ([^eo])\\1+ : 문자열에 'e' 또는 'o'를 제외한 다른 문자가 2번 이상 연속으로 등장하는 경우
		// \\1+ 는 앞에서 정의한 그룹(즉, [^eo])을 참조. 그것이 하나 이상 연속으로 나오는 것을 의미.
		// \\1은 첫 번째 그룹을 참조하라는 의미. +는 그룹이 한 번 이상 반복되는 것.
		//  'e' 또는 'o'를 제외한 어떤 다른 문자가 2번 이상 연속으로 등장하는 경우를 말한다.
		
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher; // Matcher 객체 생성. 
		
		// Pattern 클래스와 Matcher 클래스는 Java의 정규 표현식을 다룰 때 사용되는 클래스.
		// Pattern 클래스는 정규 표현식을 컴파일하고 나중에 해당 정규 표현식을 사용하여 문자열과 매칭(matching)할 수 있는 패턴을 생성하는 데 사용
		// Pattern.compile() 메서드를 사용하여 컴파일하고, 컴파일된 패턴은 Pattern 클래스의 인스턴스로 반환된다. 
		
		// Matcher 클래스는 정규 표현식을 사용하여 주어진 문자열과 패턴을 매칭
		
		while (!(str = br.readLine()).equals("end")) {
			matcher = pattern.matcher(str); // 문자열과 패턴 매칭 
			result = matcher.find() ? "not acceptable." : "acceptable."; 
			// 위의 정규식의 조건을 하나라도 포함했다? 그럼 not acceptable로 출력. 
			System.out.println("<" + str + "> is " + result);
		}
	}
}
