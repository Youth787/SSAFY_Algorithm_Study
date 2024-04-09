
import java.util.*;

class Solution {

  //내적 
  public int solution(int[] a, int[] b) {
    int answer = 0;
    for (int i = 0; i < a.length; i++) {
        answer += a[i] * b[i];
    }
    return dotProduct;
  }

  //두 개 뽑아서 더하기 
  public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<numbers.length; i++){
            for (int j = i+1; j<numbers.length; j++){
                int sum = numbers[i]+numbers[j];
                set.add(sum);
            }
        }
        int[] answer = new int[set.size()];
        int idx = 0;
        for (int num : set){
            answer[idx++] = num;
        }
        Arrays.sort(answer);
        return answer;
    }

  //3진법 뒤집기 
  public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(n != 0) {
            list.add(n%3);
            n /= 3;
        } 
        int tmp = 1;
        for(int i=list.size()-1;i>=0;i--) {
            answer += list.get(i)*tmp;
            tmp *= 3;
        }
        return answer;
    }

  //이진 변환 반복하기
  public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")){
            char[] charArr = s.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                if ("1".equals(String.valueOf(charArr[i]))) continue;
                else answer[1]++;
            }
            s = Integer.toBinaryString(s.replaceAll("0", "").length());
            answer[0]++;
        }
        return answer;
    }
}
