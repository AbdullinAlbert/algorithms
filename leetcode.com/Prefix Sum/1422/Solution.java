class Solution {
    public int maxScore(String s) {
        int[] psz = new int[s.length() + 1];
        int[] pso = new int[s.length() + 1];
        for (int i = 1; i < psz.length; i++) {
            char c = s.charAt(i - 1);
            int add = (c == '0') ? 1 : 0;
            psz[i] = psz[i - 1] + add;
            add = (c == '1') ? 1 : 0;
            pso[i] = pso[i - 1] + add;
        }
        int score = 0;
        for (int i = 1; i < psz.length - 1; i++) {
            int tempScore = psz[i] + (pso[pso.length - 1] - pso[i]);
            if (tempScore > score) score = tempScore;
        }
        return score;
    }
}