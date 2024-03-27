class Solution {

  //로또의 최고 순위와 최저 순위
  public int[] solution(int[] lottos, int[] win_nums) {
      int[] rank = {6, 6, 5, 4, 3, 2, 1};
      int[] answer = new int[2];
      
      for (int i = 0; i < lottos.length; i ++) {
          if (lottos[i] == 0) {
              answer[0]++;
              continue;
          }
          for (int j = 0; j < win_nums.length; j++) {
              if (lottos[i] == win_nums[j]) {
                  answer[0]++;
                  answer[1]++;
              }
          }
      }
      
      answer[0] = rank[answer[0]];
      answer[1] = rank[answer[1]];
      
      return answer;
  }
  
  //n^2 배열 자르기
  //https://taehoung0102.tistory.com/93
  public  List<Long> solution(int n, long left, long right) {
    List<Long> list = new ArrayList<>();
    for(long i=left;i<right+1;i++){
         list.add(Math.max(i/n,i%n) + 1);
    }
    return list;
  }

  //가장 큰 수
  public String solution(int[] numbers) {
      String[] arr = new String[numbers.length];
      for (int i = 0; i < arr.length; i++) {
          arr[i] = String.valueOf(numbers[i]);
      }
      Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
      
      if (arr[0].equals("0")) return "0";

      StringBuilder answer = new StringBuilder();
      for (int i = 0; i < arr.length; i++) {
          answer.append(arr[i]);
      }
      return answer.toString();
  }

//튜플 (https://fbtmdwhd33.tistory.com/253)
public ArrayList<Integer> solution(String s) {
        
      ArrayList<Integer> answer = new ArrayList<>();
      s = s.substring(2,s.length());
      s = s.substring(0,s.length()-2).replace("},{","-");
      String str[] = s.split("-");        
      Arrays.sort(str,new Comparator<String>(){
          public int compare(String o1, String o2){
              return Integer.compare(o1.length(), o2.length());
          }
      });
      
      for(String x : str){
          String[] temp = x.split(",");
          for(int i = 0 ; i < temp.length;i++){
              int n = Integer.parseInt(temp[i]);
              if(!answer.contains(n))
                  answer.add(n);
          }
      }
      
      return answer;
    }
}

// 저자 별 카테고리 별 매출액 집계하기
SELECT A.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM((SALES * PRICE)) AS TOTAL_SALES
FROM BOOK_SALES S
JOIN BOOK B ON S.BOOK_ID = B.BOOK_ID
JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE YEAR(S.SALES_DATE) = 2022 AND MONTH(S.SALES_DATE) = 1
GROUP BY CATEGORY, AUTHOR_ID
ORDER BY A.AUTHOR_ID, CATEGORY DESC

