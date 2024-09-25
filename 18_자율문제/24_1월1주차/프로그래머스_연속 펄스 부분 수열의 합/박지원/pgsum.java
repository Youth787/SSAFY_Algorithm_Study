class Solution {    
  public long solution(int[] sequence) {
    long answer = 0;
    boolean isPlus = true;
    long purse1 = 0;
    long purse2 = 0;
    for (int num: sequence) {
      purse1 += isPlus ? num : -num;
      purse2 += isPlus ? -num : num;
      purse1 = Math.max(0, purse1);       
      purse2 = Math.max(0, purse2);           
      answer = Math.max(answer, Math.max(purse1, purse2));         
      isPlus = !isPlus;  
    }               
    return answer;  
  }
}
// 출처: https://tang25.tistory.com/entry/프로그래머스-연속-펄스-부분-수열의-합-Lv3-JAVA-DP엄탱 [엄탱 개발 블로그:티스토리]
