class KthLargest {

    private static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode treeNode;
    private final int k;
    private int currentK = 0;

    private int res = 0;

    private int nodesSize = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        if (nums.length > 0) {
            treeNode = new TreeNode(nums[0]);
            res = nums[0];
            for (int i = 1; i < nums.length; i++) addValue(treeNode, nums[i]);
        }
    }

    public int add(int val) {
        if (treeNode == null) {
            treeNode = new TreeNode(val);
            res = val;
            return res;
        }

        addValue(treeNode, val);
        nodesSize++;

        if (nodesSize <= k || val > res) {
            currentK = 0;
            findElement(treeNode);
        }
        return res;
    }

    private void findElement(TreeNode treeNode) {
        if (treeNode != null) {
            findElement(treeNode.right);

            currentK++;
            if (currentK == k) res = treeNode.val;
            if (currentK >= k) return;

            findElement(treeNode.left);
        }
    }

    private void addValue(TreeNode treeNode, int val) {
        if (treeNode.val > val) {
            if (treeNode.left == null) treeNode.left = new TreeNode(val);
            else addValue(treeNode.left, val);
        } else if (treeNode.val <  val) {
            if (treeNode.right == null) treeNode.right = new TreeNode(val);
            else addValue(treeNode.right, val);
        } else {
            if (treeNode.right == null) treeNode.right = new TreeNode(val);
            else {
                TreeNode h = treeNode.right;
                TreeNode newNode = new TreeNode(val);
                newNode.right = h;
                treeNode.right = newNode;
            }
        }
    }

}