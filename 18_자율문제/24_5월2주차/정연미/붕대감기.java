class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int idx = 0;
        int retime = 0;
        int healthclone = health;

        for (int time = 0; time <= attacks[attacks.length - 1][0]; time++) {
            if (idx < attacks.length && time == attacks[idx][0]) {
                healthclone -= attacks[idx][1];
                if (healthclone <= 0)
                    return -1;
                idx++;
                retime = 0;
                continue;
            }

            if (retime < bandage[0]) {
                healthclone += bandage[1];
                retime++;
                if (retime == bandage[0]) {
                    healthclone += bandage[2];
                    retime = 0;
                }
            }

            if (healthclone > health)
                healthclone = health;
        }

        return healthclone;
    }
}
