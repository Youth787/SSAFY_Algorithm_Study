class Solution {

//머쓱이보다 키 큰 사람
    public int solution(int[] array, int height) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > height) answer++;
        }
        return answer;
    }

  //세균 증식
  public int solution(int n, int t) {
  int answer = n; 
    for (int i=1; i<=t; i++) answer *= 2; 
    return answer;
   }

  //편지 
  public int solution(String message) {
        int answer = message.length() * 2;
        return answer;
    }

  //양꼬치 
  public int solution(int n, int k) {
		int answer = 0;
			answer=(n*12000)+((k-(n/10))*2000);
		return answer;
	}

  //각도기 
   public int solution(int angle) {
        int answer = 0;
        if(angle < 90) {
            answer = 1;
        } else if(angle == 90) {
            answer = 2;
        } else if(angle < 180) {
            answer = 3;
        } else if(angle == 180) {
            answer = 4;
        }
        return answer;
    }
  
}
