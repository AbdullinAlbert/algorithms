class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];
        if (sum % 3 != 0) return false;
        int partition = sum / 3;
        int count = 0;
        sum = 0;
        int i = 0;
        while (i < arr.length) {
            sum += arr[i++];
            if (sum == partition) {
                sum = 0;
                count++;
                if (count == 2) break;
            }
        }
        if (count == 2 && i < arr.length) {
            sum = 0;
            while (i < arr.length) sum += arr[i++];
            return sum == partition;
        } else return false;
    }
}