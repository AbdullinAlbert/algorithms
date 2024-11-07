public class Solution {

    double minDifference = Integer.MAX_VALUE;
    int res;

    public int closestValue(TreeNode root, double target) {
        traverseTree(root, target);
        return res;
    }

    void traverseTree(TreeNode treeNode, double target) {
        if (treeNode != null) {
            traverseTree(treeNode.left, target);
            double currentMinDifference = Math.abs(target - treeNode.val);
            if (currentMinDifference < minDifference) {
                minDifference = currentMinDifference;
                res = treeNode.val;;
            }
            traverseTree(treeNode.right, target);
        }
    }

}
