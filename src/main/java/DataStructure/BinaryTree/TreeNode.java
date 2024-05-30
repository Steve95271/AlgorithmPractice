package DataStructure.BinaryTree;

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T val){
        this.val = val;
    }

    public TreeNode(TreeNode<T> left, T val, TreeNode<T> right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }

    public String toString(){
        return String.valueOf(this.val);
    }
}
