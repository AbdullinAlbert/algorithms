class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int plantedFlowersCount = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            boolean isLeftPlotEmpty = (i - 1 == -1) || (flowerbed[i- 1] == 0);
            boolean isCenterPlotEmpty = (flowerbed[i] == 0);
            boolean isRightPlotEmpty = (i + 1 == flowerbed.length) || (flowerbed[i + 1] == 0);
            if (isLeftPlotEmpty && isCenterPlotEmpty && isRightPlotEmpty) {
                plantedFlowersCount++;
                if (plantedFlowersCount == n) return true;
                flowerbed[i] = 1;
            }
        }
        return false;
    }
}