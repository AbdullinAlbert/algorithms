class Solution {

    class NumInfo {
        int value;
        int index;

        NumInfo(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        NumInfo[] a = new NumInfo[nums.length];
        for (int i = 0; i < nums.length; i++) a[i] = new NumInfo(nums[i], i);
        quickSort(a, 0, a.length - 1);
        int i = 0;
        while (i < a.length - 1) {
            int j = i + 1;
            while (j < a.length && a[j].value == a[i].value) j++;
            for (int h = i; h < j - 1; h++) {
                int ad = abs(a[h].index - a[h + 1].index);
                if (ad <= k) return true;
            }
            i = j;
        }
        return false;
    }

    int abs(int n) {
        return (n >= 0) ? n :(n * -1);
    }

    private void quickSort(NumInfo[] a, int start, int end) {
        if (start >= end) return;
        int p = partition(a, start, end);
        quickSort(a, start, p - 1);
        quickSort(a, p + 1, end);
    }

    private int partition(NumInfo[] a, int start, int end) {
        int pivot = ((end - start) / 2) + start;

        NumInfo h = a[start];
        a[start] = a[pivot];
        a[pivot] = h;

        int less = start;

        for (int i = start + 1; i <= end; i++) {
            int compare = compare(a[i], a[start]);
            if (compare < 0) {
                h = a[less + 1];
                a[less + 1] = a[i];
                a[i] = h;
                less++;
            } 
        }

        h = a[start];
        a[start] = a[less];
        a[less] = h;

        return less;
    }

    private int compare(NumInfo n1, NumInfo n2) {
        int res = n1.value - n2.value;
        if (res != 0) return res;
        return n1.index - n2.index;
    }
}