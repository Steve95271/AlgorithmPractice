package BinaryTree;

public class TestMinDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(6),
                        2,
                        new TreeNode(15)),
                1,
                new TreeNode(
                        new TreeNode(7),
                        3,
                        new TreeNode(null,
                                5,
                        new TreeNode(null,
                                9,
                                new TreeNode(null,
                                        11,
                                        null)
                        )
                        )
                )
        );

        int result = new TreeMinDepth().minDepth2(root);

        System.out.println(result);
    }
}
