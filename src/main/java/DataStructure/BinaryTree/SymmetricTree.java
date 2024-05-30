package DataStructure.BinaryTree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root){
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right){
        //第一次判断
        //如果左右节点都为空，是对称二叉树，返回true
        if (left == null && right == null){
            return true;
        }

        //第二次判断
        //当代码执行到这里，意味着有一个节点为null另一个不为null
        //所以下面代码可以简写
        /*if ((left != null && right == null) || (left == null && right != null)){

        }*/

        //简写版本
        //只需要判断左或右其中一个是否为null就可以知道这个Tree不是对称二叉树
        if (left == null || right == null){
            return false;
        }

        //第三次判断
        if (left.val != right.val){
            return false;
        }

        return check(left.left, right.right) && check(left.right, right.left);




    }
}
