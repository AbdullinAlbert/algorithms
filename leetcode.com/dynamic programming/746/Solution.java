class Solution {

    class PosInfo {
        int pos;
        int sum = 0;

        PosInfo(int pos, int sum) {
            this.pos = pos;
            this.sum = sum;
        }
    }

    public int minCostClimbingStairs(int[] cost) {
        PosInfo min1 = new PosInfo(0, cost[0]);
        PosInfo min2 = new PosInfo(1, cost[1]);
        boolean newIterate = true;
        do {
            int dif = cost.length - 1 - min2.pos;
            if (dif > 1) {
                PosInfo oldMin1 = min1;
                PosInfo oldMin2 = min2;
                //2 - 4
                int a = oldMin2.sum + cost[oldMin2.pos + 2];
                //1 - 2 - 4
                int b = oldMin1.sum + cost[oldMin1.pos + 1] + cost[oldMin1.pos + 3];
                //1 - 3 - 4
                int c = oldMin1.sum + cost[oldMin1.pos + 2] + cost[oldMin1.pos + 3];

                int newMin2Sum = Math.min(c, Math.min(a, b));

                min2 = new PosInfo(oldMin2.pos + 2, newMin2Sum);
                //2 - 3
                a = oldMin2.sum + cost[oldMin2.pos + 1];
                //1 - 3
                b = oldMin1.sum + cost[oldMin1.pos + 2];

                int newMin1Sum = Math.min(a, b);
                min1 = new PosInfo(oldMin1.pos + 2, newMin1Sum);
            } else {
                if (dif == 1) min1 = new PosInfo(min1.pos + 2, min1.sum + cost[min1.pos + 2]);
                newIterate = false;
            }
        } while (newIterate);

        return Math.min(min1.sum, min2.sum);
    }

}