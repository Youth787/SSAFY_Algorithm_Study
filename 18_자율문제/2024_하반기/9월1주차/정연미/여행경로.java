import java.util.*;

class Solution {
    boolean[] visit;
    String[][] tickets;
    String[] answer;
    List<String[]> list;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        
        // Arrays.sort(tickets, (a,b)-> a[1].compareTo(b[1]));
        list = new ArrayList<>();
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                visit = new boolean[tickets.length];
                String[] road = new String[tickets.length+1];
                road[0] = "ICN";
                DFS(i,1, visit, road);
            }
        }
        
        Collections.sort(list, (a,b)-> {
            for(int i=0; i<a.length; i++){
                int compare = a[i].compareTo(b[i]);
                if(compare!=0)
                    return compare;
            }
            return 0;
        });
        
        return list.get(0);
    }
    public void DFS(int idx, int cnt, boolean[] visit, String[] road){
        visit[idx] = true;
        
        if(cnt == tickets.length){
            road[tickets.length] = tickets[idx][1];
            list.add(road.clone());
            visit[idx] = false;
            return;
        }
        
        String find = tickets[idx][1];
        
        for(int i=0; i<tickets.length; i++){
            if(!visit[i]&& tickets[i][0].equals(find)){
                road[cnt] = find;
                DFS(i, cnt+1,visit, road);
            }
        }
        visit[idx] = false;
    }
}
