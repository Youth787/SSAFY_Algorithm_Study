class Solution {

  //코드 처리하기
        public String solution(String code) {
        String answer = "";
        int mod = 0;
        for (int i=0; i<code.length(); i++) {
            char c = code.charAt(i); 
            if (c=='1') {
                if (mod==0) mod=1;
                else mod=0;
              //mod = 1-mod; 
            } else {
                if (mod==0 && i%2==0) answer+=c; 
                if (mod==1 && i%2==1) answer+=c; 
            }
        }
        return answer.equals("") ? "EMPTY" : answer ;
    }

  //등차수열의 특정한 항만 더하기
  public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for(int i=0; i<included.length; i++){
            if(included[i]){
                answer += a+(d*i);
            }
        }
        return answer;
    }

  //주사위 게임 2
  public int solution(int a, int b, int c) {
        int answer = 0;
        if(a==b&&b==c){
            answer = (a+b+c)*(a*a+b*b+c*c)*(a*a*a+b*b*b+c*c*c);
        }else if(a==b&&b!=c||a==c&&c!=b||a!=b&&b==c){
            answer = (a+b+c)*(a*a+b*b+c*c);
        }else{
            answer = a+b+c;
        }
        return answer;
    }

  //원소들의 곱과 합
  public int solution(int[] num_list) {
        int answer = 0;
        int sum = 0;
        int mul = 1;
        for(int i = 0; i<num_list.length;i++){
            sum+=num_list[i];
            mul*=num_list[i];
        }
        if(sum * sum > mul){
            answer = 1;
        }
        return answer;
    }

  //이어 붙인 수
public int solution(int[] num_list) {
        String oddS = "";
        String evenS = "";
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2==0){
                evenS += Integer.toString(num_list[i]);
            }else{
                oddS += Integer.toString(num_list[i]);
            }
        }
        int oddSum = Integer.parseInt(oddS);
        int evenSum = Integer.parseInt(evenS);
        
        return oddSum + evenSum;
    }
}
