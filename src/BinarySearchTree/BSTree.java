package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTree {

    BSTNode root;

    public Object get(int key){
        return doGet(root, key);
    }

    private Object doGet(BSTNode node, int key){
        //Can't find the key
        if (node == null){
            return null;
        }

        //Search to the left
        if (key < node.key){
            return doGet(node.left, key);
        }

        //Search to the right
        if(key > node.key){
            return doGet(node.right, key);
        }

        //have found the key
        return node.value;
    }

    //Non recursion way
    public BSTNode get2(int key){
        BSTNode node = root;
        while(node != null){
            if (key < node.key){
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            }else {
                return node;
            }
        }

        return null;
    }

    //Search for min
    public Object getMin(){
        return getMin(root);
    }

    public Object getMin(BSTNode node){
        BSTNode pointer = node;

        while(pointer.left != null){
            pointer = pointer.left;
        }

        return pointer.value;
    }

    public Object getMax(){
        return getMax(root);
    }

    private Object getMax(BSTNode node){
        if (node == null){
            return null;
        }

        BSTNode pointer = node;

        while(pointer.right != null){
            pointer = pointer.right;
        }

        return pointer.value;
    }

    /**
     * Update a key's value or, if an input key doesn't exit then add a new node
     * @param key pointer of a Binary Search Tree
     * @param val value, e.g. String, integer or any other data.
     */
    public void put(int key, Object val){
        /*
            Situation 1: Key exist, update value.
            Situation 2: Key not exist, add a new one.
         */

        BSTNode node = root;
        BSTNode parent = null;

        while(node != null){
            parent = node;
            if (key < node.key){
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                //Situation 1
                node.value = val;
                return;
            }
        }

        //Situation 2
        if (parent == null){ //root node is null
            root = new BSTNode(key, val);
            return;
        }

        if (key < parent.key){// Key smaller than parent.key, new node should add to the left
            parent.left = new BSTNode(key, val);
        } else if (key > parent.key) {// If key is greater, should add to the right
            parent.right = new BSTNode(key, val);
        }

    }

    /**
     * According to the key to search the predecessor of the key.
     * @param key
     * @return the value of the key's predecessor.
     */
    public Object predecessor(int key){
        BSTNode pointer = root;
        BSTNode ancestorFromLeft = null;

        boolean loopBreaker = true;
        while(loopBreaker){
            if (pointer == null){
                loopBreaker = false;
            }else if (key < pointer.key){
                pointer = pointer.left;
            }else if (pointer.key < key) {
                ancestorFromLeft = pointer;
                pointer = pointer.right;
            }else{
                loopBreaker = false;
            }
        }

        //Can't find the node. Then return null.
        if (pointer == null){
            return null;
        }

        //Situation 1: Find the node and have left child
        if (pointer.left != null){
            return getMax(pointer.left);
        }

        //Situation 2: Find the node but don't have left child
        if (ancestorFromLeft != null){
            return ancestorFromLeft.value;
        } else {
            return null;
        }
    }

    /**
     * According to the key to search its successor value.
     * @param key
     * @return the value of successor of the key.
     */
    public Object successor(int key){
        BSTNode pointer = root;
        BSTNode ancestorFromRight = null;

        boolean loopBreaker = true;
        while(loopBreaker){
            if (pointer == null){
                loopBreaker = false;
            }else if (key < pointer.key){
                ancestorFromRight = pointer;
                pointer = pointer.left;
            }else if (pointer.key < key) {
                pointer = pointer.right;
            }else{
                loopBreaker = false;
            }
        }

        //Can't find the node. Then return null.
        if (pointer == null){
            return null;
        }

        //Situation 1: Find the node and have right child
        if (pointer.right != null){
            return getMin(pointer.right);
        }

        //Situation 2: Find the node but don't have right child
        if (ancestorFromRight != null){
            return ancestorFromRight.value;
        } else {
            return null;
        }
    }

    public Object delete(int key){
        BSTNode nodeBeDelete = root;
        BSTNode parent = null;

        boolean loopBreaker = true;
        while(loopBreaker){
            if (nodeBeDelete == null){
                loopBreaker = false;
            }else if (key < nodeBeDelete.key){
                //Record the parent node
                parent = nodeBeDelete;
                nodeBeDelete = nodeBeDelete.left;
            }else if (nodeBeDelete.key < key) {
                //Record the parent node
                parent = nodeBeDelete;
                nodeBeDelete = nodeBeDelete.right;
            }
            //当代码执行这个else条件时，节点已被找到，退出循环
            else{
                loopBreaker = false;
            }
        }

        if (nodeBeDelete == null){
            return null;
        }

        //删除操作
        //Situation 1: 有右子树但没左
        if (nodeBeDelete.left == null){
            shift(parent, nodeBeDelete, nodeBeDelete.right);
        }
        //Situation 2: 有左子树但没右
        else if (nodeBeDelete.right == null) {
            shift(parent, nodeBeDelete, nodeBeDelete.left);
        }
        //Situation 3: 有左右子树
        else {
            //3.1 被删除节点找successor
            BSTNode successor = nodeBeDelete.right;
            BSTNode sParent = nodeBeDelete; //后继节点的父节点，用于判断被删除节点和后继节点是否相邻
            while(successor.left != null){
                sParent = successor;
                successor = successor.left;
            }
            //3.2 处理后继节点的父子节点指针
            //如果被删节点和后继节点不相邻
            if (nodeBeDelete != sParent){
                shift(sParent, successor, successor.right);
                //更换顶替节点的左右child
                successor.right = nodeBeDelete.right;
            }
            //3.3 successor取代被删除节点
            shift(parent, nodeBeDelete, successor);
            //更换顶替节点的左右child
            successor.left = nodeBeDelete.left;
        }
        return nodeBeDelete.value;

    }

    /**
     * 某节点被删除后的，父节点的指针需要重新指向新的子节点。
     * @param parent 父节点
     * @param nodeBeDelete 将要被删除的节点
     * @param child 父节点指向的子节点
     */
    private void shift(BSTNode parent, BSTNode nodeBeDelete, BSTNode child){
        //特殊情况：当被删除节点为根节点，它的child将成为新的根节点
        if (parent == null){
            root = child;
        }
        //被删除节点是left child of parent
        else if (nodeBeDelete == parent.left){
            //Shift child
            parent.left = child;
        }
        //被删除节点是right child of parent
        else {
            //Shift child
            parent.right = child;
        }
    }

    //找比key小的所有value
    public List<Object> less(int key){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode pointer = root;
        LinkedList<BSTNode> stack = new LinkedList<>();

        while(pointer != null || !stack.isEmpty()){
            if (pointer != null){
                stack.push(pointer);
                pointer = pointer.left;
            }else {
                BSTNode pop = stack.pop();
                if (pop.key < key){
                    result.add(pop.value);
                }else{
                    return result;
                }
                pointer = pop.right;
            }
        }
        return null;
    }

    //找比key大的
    public List<Object> greater(int key){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode pointer = root;
        LinkedList<BSTNode> stack = new LinkedList<>();

        while(pointer != null || !stack.isEmpty()){
            if (pointer != null){
                stack.push(pointer);
                pointer = pointer.left;
            }else {
                BSTNode pop = stack.pop();
                if (pop.key > key){
                    result.add(pop.value);
                }
                pointer = pop.right;
            }
        }
        return result;
    }

    //找 > key1 且 < key2的
    public List<Object> between(int key1, int key2){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode pointer = root;
        LinkedList<BSTNode> stack = new LinkedList<>();

        while(pointer != null || !stack.isEmpty()){
            if (pointer != null){
                stack.push(pointer);
                pointer = pointer.left;
            }else {
                BSTNode pop = stack.pop();
                if(pop.key >= key1 && pop.key <= key2){
                    result.add(pop.value);
                } else if (pop.key > key2) {
                    break;
                }
                pointer = pop.right;
            }
        }
        return result;
    }

    public void inOrderTraversal(BSTNode root){
        BSTNode current = root;
        BSTNode pop = null;

        //By using stack for remember the way back
        LinkedList <BSTNode> stack = new LinkedList<>();

        while(current != null || !stack.isEmpty()){
            if (current != null) {
                stack.push(current); //push to stack to remember the way back
                current = current.left;
            }else {
                BSTNode peek = stack.peek();
                if (peek.right == null) {
                    System.out.println("in order: " + peek.value);
                    pop = stack.pop();
                }
                //This means right node is finished traversal
                else if (peek.right == pop) {
                    pop = stack.pop();
                }
                //Right node is waiting for traversal
                else {
                    System.out.println("in order: " + peek.value);
                    current = peek.right;
                }
            }
        }
    }

    public boolean isValid(BSTNode root){
        BSTNode pointer = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE;//用于判断树中最小的值

        while(pointer != null || !stack.isEmpty()){
            if (pointer != null){
                stack.push(pointer);
                pointer = pointer.left;
            }else {
                BSTNode popNode = stack.pop();
                if (prev <= popNode.key){
                    prev = popNode.key;
                }else {
                    return false;
                }
                pointer = popNode.right;
            }
        }

        return true;
    }
}
