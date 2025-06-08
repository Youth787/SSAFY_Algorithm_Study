import java.util.*;

class Solution {

    private Set<Set<String>> result = new HashSet<>();
    private List<List<String>> candidates = new ArrayList<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        for(String banned : banned_id){
            List<String> possibleUsers = new ArrayList<>();
            for(String user : user_id) {
                if(isMatch(banned,user)){
                    possibleUsers.add(user);
                }
            }
            candidates.add(possibleUsers);
        }
        dfs(new HashSet<>(),0);
        
        return result.size();
    }
    
    private boolean isMatch(String banned, String user){
        if(banned.length()!=user.length()){
            return false;
        }
        for(int i=0;i<banned.length();i++){
            if(banned.charAt(i)!='*' && banned.charAt(i)!=user.charAt(i)){
                return false;
            }
        }
        return true;
    }
    
    private void dfs(Set<String> selected, int index){
        if(index == candidates.size()){
            result.add(new HashSet<>(selected));
            return;
        }
        for(String user : candidates.get(index)){
            if(!selected.contains(user)){
                selected.add(user);
                dfs(selected, index+1);
                selected.remove(user);
            }
        }
        
    }
}
