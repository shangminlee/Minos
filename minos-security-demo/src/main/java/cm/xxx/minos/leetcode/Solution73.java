package cm.xxx.minos.leetcode;


/**
 * 二叉树的最大深度
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution73 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }


}
