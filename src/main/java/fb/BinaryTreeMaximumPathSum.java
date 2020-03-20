package fb;

import fb.helper.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {
    int maxVal ;
    public int maxPathSum(TreeNode root) {
        maxVal = Integer.MIN_VALUE;
        pathSum(root);
        return maxVal;
    }

    private int pathSum(TreeNode node) {
        if(node == null) return 0;
        int left = Math.max(0,pathSum(node.left));
        int right = Math.max(0,pathSum(node.right));
        maxVal = Math.max(maxVal, left+right+node.val);
        return Math.max(left,right) + node.val;

    }


}
