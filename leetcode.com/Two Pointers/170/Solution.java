class TwoSum {

    int[] a = new int[10_000];
    int lastIndex = 0;

    public TwoSum() {
        
    }
    
    public void add(int number) {
        int i = lastIndex;
        a[lastIndex++] = number;
        while (i > 0 && a[i] < a[i - 1]) {
            int t = a[i - 1];
            a[i - 1] = a[i];
            a[i] = t;
            i--;
        }
    }
    
    public boolean find(int value) {
        if (lastIndex == 0) return false;
        int i = 0;
        int j = lastIndex - 1;
        while (i < j) {
            if (a[i] + a[j] == value) return true;
            if (a[i] + a[j] > value) j--;
            else i++;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */