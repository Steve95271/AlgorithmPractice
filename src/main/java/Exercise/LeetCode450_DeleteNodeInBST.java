package Exercise;

/*
    Given a root node reference of a BST and a key, delete the node with the given key in the BST.
    Return the root node reference (possibly updated) of the BST.
    Basically, the deletion can be divided into two stages:
    Search for a node to remove.
    If the node is found, delete the node.
 */


import java.util.TreeMap;

public class LeetCode450_DeleteNodeInBST {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.remove(1);
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    TreeNode globalRoot = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        globalRoot = root;
        if (root == null) {
            return root;
        } else if (root.left == null && root.right == null) {
            if (root.val == key) {
                return null;
            } else {
                return root;
            }
        }

        TreeNode node = globalRoot;
        TreeNode parentOfNode = null;
        // search the key
        while (node != null) {
            if (key < node.val) {
                parentOfNode = node;
                node = node.left;
            } else if (node.val < key) {
                parentOfNode = node;
                node = node.right;
            } else {
                break;
            }
        }

        if (node == null) {
            return root;
        }

        // 情况1: 被删除节点没左子树，但是右右子树
        if (node.left == null) {
            shift(parentOfNode, node, node.right);
        }
        // 情况2: 被删除节点没右子树，但是右左子树
        else if (node.right == null) {
            shift(parentOfNode, node, node.left);
        }
        // 情况3: 被删除节点左右子树都有
        else {
            // 先找被删除节点的后继
            TreeNode successor = node.right;
            TreeNode parentOfSuccessor = node;
            while (successor.left != null) {
                parentOfSuccessor = successor;
                successor = successor.left;
            }
            // 处理后继节点的父子节点指针
            // 如果被删除节点与后继节点不相邻
            if (node != parentOfSuccessor) {
                // 细节：当代码执行到这里时，后继节点只能有right child
                shift(parentOfSuccessor, successor, successor.right);
                // 后继节点顶替被删除节点。接手被删除节点的右子树即可
                successor.right = node.right;
            }
            // 被删除节点与后继节点相邻
            shift(parentOfNode, node, successor);
            successor.left = node.left;
        }

        return globalRoot;
    }

    /**
     * 某节点被删除后的，父节点的指针需要重新指向新的子节点。
     * @param parent 父节点
     * @param nodeToBeDeleted 将要被删除的节点
     * @param child 父节点指向的子节点
     */
    private void shift(TreeNode parent, TreeNode nodeToBeDeleted, TreeNode child) {
        if (parent == null) {
            globalRoot = child;
        } else if (nodeToBeDeleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

}
