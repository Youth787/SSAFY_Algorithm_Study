//프로그래머스 불량 사용자 자바
//백트래킹, hashset

import java.util.*;

class Solution {
    private static String[] userIds;
    private static String[] bannedIds;
    private static boolean[] visited;
    private static HashSet<HashSet<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        visited = new boolean[userIds.length];
        DFS(new HashSet<>(), 0);
        return result.size();
    }
    private static void DFS(HashSet<String> set, int depth) {
        if (depth == bannedIds.length) {
            result.add(set);
            return;
        }
        for (int i = 0; i < userIds.length; i++) {
            if (set.contains(userIds[i])) {
                continue;
            }
            if (check(userIds[i], bannedIds[depth])) {
                set.add(userIds[i]);
                DFS(new HashSet<>(set), depth + 1);
                set.remove(userIds[i]);
            }
        }
    }
    private static boolean check(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }
        boolean match = true;
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                match = false;
                break;
            }
        }
        return match;
    }
}
