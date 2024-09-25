class Solution {

  //문자열 섞기
    public String solution(String str1, String str2) {
        String answer = "";
        int l1 = str1.length();
        int l2 = str2.length();
        int max = -1;
        int min = -1; 
        if (l1==l2) min = l1;
        else if (l1<l2) {
            min = l1; 
            max = l2; 
        }
        else if (l1>l2) {
            min = l2;
            max = l1; 
        }
        
        int i = 0;
        while (i<min) {
            answer = answer + str1.charAt(i)+str2.charAt(i);
            i++;
        }
        
        if (max==l1) {
            for (int j=i; j<max; j++) answer += str1.charAt(j);
        } else if (max==l2) {
            for (int j=i; j<max; j++) answer += str2.charAt(j);
        }
        
        return answer;
    }

  //문자 리스트를 문자열로 변환하기
    public String solution(String[] arr) {
      String answer = "";
      for (int i=0; i<arr.length; i++) {
          answer = answer + arr[i];
      }
      return answer;
  }

  //문자열 곱하기
    public String solution(String my_string, int k) {
      String answer = "";
      for (int i=0; i<k; i++) {
          answer = answer + my_string;
      }
      return answer;
  }

  //더 크게 합치기
    public int solution(int a, int b) {
      String s1 = Integer.toString(a) + Integer.toString(b);
      String s2 = Integer.toString(b) + Integer.toString(a);
      int num1 = Integer.parseInt(s1);
      int num2 = Integer.parseInt(s2);
      return num1>=num2? num1 : num2;
  }

  //두 수의 연산값 비교하기
    public int solution(int a, int b) {
      String str = Integer.toString(a) + Integer.toString(b);
      int num1 = Integer.parseInt(str);
      int num2 = 2 * a * b; 
      return num1>=num2 ? num1 : num2;
  }

  //n의 배수
    public int solution(int num, int n) {
      return num % n == 0 ? 1 : 0;
  }

  //공배수
    public int solution(int number, int n, int m) {
      return (number%n==0 && number%m==0) ? 1 : 0 ;
  }

  //홀짝에 따른 값 반환하기
    public int solution(int n) {
      int ans = 0;
      if (n%2==1) {
          for (int i=1; i<=n; i=i+2) ans += i;
      } else {
          for (int i=2; i<=n; i=i+2) ans = ans + i*i; 
      }
      return ans;
  }

  //조건 문자열
    public int solution(String ineq, String eq, int n, int m) {
      int ans = 0; 
      if (eq.equals("=")) {
          if (ineq.equals(">")) ans = n>=m ? 1 : 0; 
          else ans = n<=m ? 1 : 0; 
      } else {
          if (ineq.equals(">")) ans = n>m ? 1 : 0; 
          else ans = n<m ? 1 : 0;  
      }
      return ans;
  }

  //flag에 따라 다른 값 반환하기
    public int solution(int a, int b, boolean flag) {
      return flag==true ? a+b : a-b ;
  }
}
