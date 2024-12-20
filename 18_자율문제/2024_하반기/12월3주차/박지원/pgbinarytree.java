//프로그래머스 표현가능한이진트리 자바
//트리 + 재귀

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            StringBuilder sb = new StringBuilder();
            long num = numbers[i];
            while(num > 0){
                if(num % 2 == 1){
                    sb.insert(0,"1");
                } else {
                    sb.insert(0,"0");
                }
                num /= 2;
            }
            int n=1;
            int len = sb.length();
            int addcnt;
            while(true){
                n *= 2;
                if(n - 1 >= len){
                    addcnt = n-1-len;
                    break;
                }
            }
            for(int j=0; j<addcnt; j++){
                sb.insert(0, "0");
            }

            int ans = sum(sb);
            if(ans == -1){
                answer[i] = 0;    
            } else {
                answer[i] = 1;
            }
        }
        return answer;
    }
    
    int sum(StringBuilder node){
        int len = node.length();
        if(len == 1){
            return node.charAt(0) - '0';
        }
        StringBuilder sbLeft = new StringBuilder(node.substring(0, len/2));
        StringBuilder sbRight = new StringBuilder(node.substring(len/2+1));
        
        int left = sum(sbLeft);
        if(left == -1){
            return -1;
        }
        int right = sum(sbRight);
        if(right == -1){
            return -1;
        }
        int mid = node.charAt(len/2) - '0';
        if(left + right > 0 && mid == 0){
            return -1;
        } else if(left + right + mid == 0){
            return 0;
        } else {
            return 1;
        }
    }
}
