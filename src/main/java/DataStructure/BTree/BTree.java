package DataStructure.BTree;

import java.util.Arrays;

public class BTree {

    static class Node {
        int[] keys;
        Node[] children;
        int keySize;
        boolean isLeaf = true;
        int minDegree;

        public Node(int minDegree) {
            // 给最小度数赋值需要 >=2
            this.minDegree = minDegree;
            this.children = new Node[2 * minDegree];
            this.keys = new int[2 * minDegree -1];
        }

        @Override
        public String toString(){
            // 方便调试用
            return Arrays.toString(Arrays.copyOfRange(keys,0, keySize));
        }

        /**
         * 查找 key
         * @param key 需要查找的key
         * @return key对应的节点
         */
        public Node get(int key) {
            int i = 0;
            while (i < keySize) {
                if (keys[i] == key) {
                    return this;
                }

                if (keys[i] > key) {
                    break;
                }
                i++;
            }

            /*
            退出循环后检查是否叶子节点
            如果是：没有找到对应的节点，直接返回null
             */
            if (isLeaf) {
                return null;
            }

            return children[i].get(key);
        }

        // 向指定索引插入 key
        public void insertKey(int key, int index) {
            // 先从后往前移动元素
            // 方式一
            for (int i = keySize - 1; i >= index ; i--) {
                keys[i+1] = keys[i];
            }

            // 方式二，System.arraycopy，性能更高，不过不好理解
            //System.arraycopy(keys, index, keys, index + 1, keySize - index);

            keys[index] = key;
            keySize++;
        }

        // 向指定索引插入 child
        public void insertChildren(Node child, int index) {
            // 从后往前移动元素
            for (int i = keySize-1; i > index ; i--) {
                children[i + 1] = children[i];
            }
            children[index] = child;
        }
    }

}
