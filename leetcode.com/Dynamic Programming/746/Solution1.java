class Solution1 {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) cost[i] += min(cost[i - 1], cost[i - 2]);
        return min(cost[cost.length - 1], cost[cost.length - 2]);
    }
    
    int min(int a, int b) {
        return (a > b) ? b : a;
    }
}