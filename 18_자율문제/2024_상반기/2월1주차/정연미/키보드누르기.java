class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        
        for(int num : numbers){
            if(num==1 || num==4 || num==7){
                answer+="L";
                left = num;
            }else if(num==3 || num==6||num==9){
                answer+="R";
                right=num;
            }
            else{
                if(num==0) num = 11;
                int leftdist = Math.abs(left-num)/3+Math.abs(left-num)%3;
                int rightdist = Math.abs(right-num)/3+Math.abs(right-num)%3;
                
                if(leftdist<rightdist){
                    answer +="L";
                    left=num;
                }else if(rightdist<leftdist){
                    answer+="R";
                    right=num;
                }
                else{
                    if(hand.equals("left")){
                        answer+="L";
                        left=num;
                    }else{
                        answer+="R";
                        right=num;
                    }
                }
            }
        }
        return answer;
    }
}