import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations){
            String[] input = operation.split(" ");
            Character order = input[0].charAt(0);
            int num = Integer.parseInt(input[1]);
            
            if(order=='I'){
                minheap.add(num);
                maxheap.add(num);
            }else if(order =='D'){
                if(num==1){
                    if(!maxheap.isEmpty()){
                        int max = maxheap.poll();
                        minheap.remove(max);
                    }
                }else if(num==-1){
                    if(!minheap.isEmpty()){
                        int min = minheap.poll();
                        maxheap.remove(min);
                    }
                }
            }
        }
        
        if(minheap.isEmpty()&& maxheap.isEmpty())
            return new int[]{0,0};
        
        return new int[]{maxheap.poll(), minheap.poll()};
    }
}
