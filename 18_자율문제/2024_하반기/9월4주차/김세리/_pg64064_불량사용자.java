import java.util.*;

class Solution {
    // 결과 저장
    private Set<Set<String>> result = new HashSet<>();
    // 후보들 저장(각 불량 사용자 아이디 별로 추측한 제재 아이디 목록)
    private List<List<String>> candidates = new ArrayList<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        for(String banned : banned_id){
            // 제재 대상이 될 수 있는 아이디 목록
            List<String> possibleUsers = new ArrayList<>();
            for(String user : user_id) {
                if(isMatch(banned,user)){
                    possibleUsers.add(user);
                }
            }
            // 그렇게 만든 목록을 후보군 목록에 추가
            // candidates는 각 제재 아이디 목록인 possibleUsers를 모은 목록임
            candidates.add(possibleUsers);
        }
        // 후보군을 토대로 조합 가능한 결과를 만든다
        dfs(new HashSet<>(),0);
        
        return result.size();
    }
    
    private boolean isMatch(String banned, String user){
        // 글자 길이가 다르면 아예 일치하지 않으므로 false 반환
        if(banned.length()!=user.length()){
            return false;
        }
        // 한 글자씩 비교해서 *가 아닌데 글자가 일치하지 않은 경우에도 false 반환
        for(int i=0;i<banned.length();i++){
            if(banned.charAt(i)!='*' && banned.charAt(i)!=user.charAt(i)){
                return false;
            }
        }
        // 위 조건에 해당하지 않으면 일치하는 것이므로 true 반환
        return true;
    }
    
    private void dfs(Set<String> selected, int index){
        // candidates 마지막까지 제재 가능한 아이디 목록을 만들었으면 result에 추가한다
        if(index == candidates.size()){
            result.add(new HashSet<>(selected));
            return;
        }
        // candidates에서 index별로 아이디를 하나씩 골라서 목록을 만들어야 하므로
        // 목록에 추가된 user는 selected에 넣고 다음 index로 넘어감.
        // 이 때 다음 index에선 selected에 없는 아이디만 골라서 목록에 추가 가능함.
        // dfs를 계속 돌려야 하므로 조합이 끝난 후엔 selected에서 해당 user 제거.
        for(String user : candidates.get(index)){
            if(!selected.contains(user)){
                selected.add(user);
                dfs(selected, index+1);
                selected.remove(user);
            }
        }
        
    }
}
