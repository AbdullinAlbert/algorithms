class Solution {
    public int distMoney(int money, int children) {
        money -= children;
        if (money < 0) return -1;
        int count = 0;
        while ((money > 6) && (count < children)) {
            money -= 7;
            count++;
        }
        if (((count == children) && (money != 0)) || ((money == 3) && (children - count == 1))) return --count;
        return count;
    }
}