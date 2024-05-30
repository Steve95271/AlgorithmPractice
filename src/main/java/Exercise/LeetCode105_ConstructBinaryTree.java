package Exercise;

/*
    Given two integer arrays preorder and inorder where preorder is the preorder
    traversal of a binary tree and inorder is the inorder traversal of the same tree,
    construct and return the binary tree.
 */

import DataStructure.BinaryTree.TreeNode;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class LeetCode105_ConstructBinaryTree {

    TreeNode buildTree(int[] preOrder, int[] inOrder) {
        //递归结束条件
        if (preOrder == null || inOrder == null) {
            return null;
        }

        //创建根节点
        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        //区分左右子数
        for(int i = 0; i < inOrder.length; i++) {
            //找到中序遍历的根节点的值
            if (inOrder[i] == rootValue) {
                //这四行代码要结合GoodNode的笔记来看才能理解
                //总之，拆分左右子树为了后面继续递归
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                int[] preLeft = Arrays.copyOfRange(preOrder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preOrder, i + 1, preOrder.length);

                //由于每次递归拿到的是root节点
                //而递归结束返回的是root的左右子节点
                //因此有一下代码：
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);

                //当中序遍历的中间节点找到后无需继续循环
                break;
            }
        }

        return root;
    }

    //LeetCode官方题解
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

}
