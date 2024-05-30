package DataStructure.BinaryTree;

public class TestSymmetricTree {
    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();

        TreeNode tree1 = new TreeNode(
                new TreeNode(
                        new TreeNode(3),
                        2,
                        new TreeNode(4)),
                1,
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(3))
        );

        boolean flag = symmetricTree.isSymmetric(tree1);

        System.out.println(flag);
    }
}
