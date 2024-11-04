public class Solution {

    TreeNode treeNode;
    public TreeNode sortedArrayToBST(int[] nums) {
        addValue(0, nums.length - 1, nums);
        return treeNode;
    }

    private void addValue(int start, int end, int[] nums) {
        int middleIndex = ((end - start) / 2) + start;
        if (treeNode == null) treeNode = new TreeNode(nums[middleIndex]);
        else add(treeNode, nums[middleIndex]);
        if (start >= end) return;
        addValue(start, middleIndex, nums);
        addValue(middleIndex + 1, end, nums);
    }

    private void add(TreeNode treeNode, int val) {
        if (treeNode.val < val) {
            if (treeNode.right == null) treeNode.right = new TreeNode(val);
            else add(treeNode.right, val);
        } else if (treeNode.val > val) {
            if (treeNode.left == null) treeNode.left = new TreeNode(val);
            else add(treeNode.left, val);
        }
    }
}
