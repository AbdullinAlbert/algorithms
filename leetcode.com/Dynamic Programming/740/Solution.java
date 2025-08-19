class Solution {
    
    class Node {
        Pair pair;
        Node next;
            
        Node(int number) {
            pair = new Pair(number);
        }
    }
    
    class Pair {
        int number;
        int count;
        
        Pair(int number) {
            this.number = number;
            count = 1;
        }
    }
    
    public int deleteAndEarn(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        Node first = new Node(nums[0]);
        Node currentNode = first;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (currentNode.pair.number == nums[i]) currentNode.pair.count++;
            else {
                currentNode.next = new Node(nums[i]);
                currentNode = currentNode.next;
                count++;
            }
        }
        Pair[] pairs = new Pair[count];
        currentNode = first;
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = currentNode.pair;
            currentNode = currentNode.next;
        }
        if (pairs.length == 1) return pairs[0].number * pairs[0].count;
        int[] r = new int[pairs.length];
        r[0] = pairs[0].number * pairs[0].count;
        r[1] = pairs[1].number * pairs[1].count;
        if (pairs[1].number - pairs[0].number != 1) r[1] += r[0];
        for (int i = 2; i < pairs.length; i++) {
            r[i] = pairs[i].number * pairs[i].count;
            if (pairs[i].number - pairs[i - 1].number == 1) {
                if (i == 2) r[i] += r[0];
                else r[i] += max(r[i - 2], r[i - 3]);
            }
            else r[i] += max(r[i - 1], r[i - 2]);            
        }
        return max(r[r.length - 1], r[r.length - 2]);
    }
    
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    class Borders {
        int left;
        int right;
        
        Borders(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    
    void qSort(int[] a, int start, int end) {
        if (start >= end) return;
        Borders borders = partition(a, start, end);
        qSort(a, start, borders.left - 1);
        qSort(a, borders.right + 1, end);
    }
    
    Borders partition(int[] a, int start, int end) {
        int pivot = ((end - start) / 2) + start;
        
        int h = a[start];
        a[start] = a[pivot];
        a[pivot] = h;
        
        int less = start;
        int eq = start;
        
        for (int i = start + 1; i <= end; i++) {
            if (a[i] < a[start]) {
                
                h = a[less + 1];
                a[less + 1] = a[i];
                a[i] = h;
                
                if (less < eq) {
                    h = a[eq + 1];
                    a[eq + 1] = a[i];
                    a[i] = h;
                }
                
                less++;
                eq++;
                
            } else if (a[i] == a[start]) {
                
                h = a[eq + 1];
                a[eq + 1] = a[i];
                a[i] = h;
                
                eq++;
            }
        }
        
        h = a[start];
        a[start] = a[less];
        a[less] = h;
        
        return new Borders(less, eq);
    }
    
}