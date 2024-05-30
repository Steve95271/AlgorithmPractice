package DataStructure.StackAndQueue.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree1 {

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int c1 = 1; //当前层节点数
        while (!queue.isEmpty()){
            int c2 = 0; //下层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                System.out.print(n + " ");
                if (n.left != null){
                    queue.add(n.left);
                    c2++;
                }
                if (n.right != null){
                    queue.add(n.right);
                    c2++;
                }
            }
            System.out.println();
            c1 = c2;
        }

        return result;
    }

    public static void main(String[] args) {
        //Create tree node
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )

        );

        /*LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.addElement(root);


        int c1 = 1; //当前层节点数
        while (!queue.isEmpty()){
            int c2 = 0; //下层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                System.out.print(n + " ");
                if (n.left != null){
                    queue.addElement(n.left);
                    c2++;
                }
                if (n.right != null){
                    queue.addElement(n.right);
                    c2++;
                }
            }
            System.out.println();
            c1 = c2;
        }*/

        levelOrder(root);




    }
}
