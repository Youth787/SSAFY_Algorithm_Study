import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Stack<String[]> stop = new Stack<>();
        
        Arrays.sort(plans,(a,b)->ToSec(a[1])-(ToSec(b[1])));
      
        
        int size = plans.length;
        
        int z=0;
        int idx=0;
        int current=0;
        String type ="";
        int time =0;
        int period =0;
        int next=0;        
        while(size!=idx){
            
            type=plans[idx][0];
            time = ToSec(plans[idx][1]);
            period = Integer.parseInt(plans[idx][2]);
            
            current=time+period;
            
            //새로운 과제가 틀어 막는지 체크
            if(size-1!=idx){      
             next = ToSec(plans[idx+1][1]);
            if(current>next){
               
                stop.push(new String[]{type,current-next+""});
                current=next;
                idx++;
                
                continue;
                
                }
            }
            
            //지금 과제 완료
            answer[z++]=type;
            
            // 남은시간동안 멈춘 과제를 할수있을까?
            while(!stop.isEmpty()){
                
                int remain = next-current;
                
                String[] work = stop.pop();
                
                int re_p =Integer.parseInt(work[1]);
                
                //멈춘과제 완료
                if(remain>=re_p){
                    
                    answer[z++]=work[0];
                    current+=re_p;
                }else{
                    //과제를 또 멈춰야할때            
                    stop.push(new String[]{work[0],re_p-remain+""});
                    break;
                }
                  
            }
        
            
            idx++;
        }
        
        //모든 과제를 탐색했다. 이젠 남은 멈춘과제 마저하자
        while(!stop.isEmpty()){
            answer[z++]=stop.pop()[0];
        }
        
        return answer;
    }
    
    public int ToSec (String time){
        
        String[] t = time.split(":");
        int h =Integer.parseInt(t[0])*60;
        int m =Integer.parseInt(t[1]);
        
        return h+m;
    }
}
