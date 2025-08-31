class Heap {
    int[] q;
    int size = 0;

    Heap(int[] nums, int k) {
        q = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (size < k) {
                q[size] = nums[i];
                siftUp(size);
                size++;
                continue;
            }
            if (q[0] > nums[i]) continue;
            q[0] = nums[i];
            siftDown();
        }
    }

    void siftUp(int i) {
        while (i > 0) {
            int p = (i - 1) >>> 1;
            if (q[p] <= q[i]) break;
            swap(p, i);
            i = p;
        }
    }

    void siftDown() {
        int i = 0;
        while (true) {
            int l = (i << 1) + 1;
            if (l >= size) break;
            int r = l + 1;
            int min = (r < size && q[r] < q[l]) ? r : l;
            if (q[min] < q[i]) {
                swap(min, i);
                i = min;
            } else break;
        }
    }

    void swap(int i, int j) {
        int t = q[i];
        q[i] = q[j];
        q[j] = t;
    } 

    int peek() {
        return q[0];
    }
}

class Solution {

    public int findKthLargest(int[] nums, int k) {
        Heap h = new Heap(nums, k);
        return h.peek();
    }
}