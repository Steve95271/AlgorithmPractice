package DataStructure.Hash;

public class HashTable2 {

    //Node class
    static class Entry{
        int hash;
        Object key;
        Object value;
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }


    Entry[] table = new Entry[16];
    int size = 0; //how many elements

    /*
        当数组长度为2的n次方时，可以把（求余运算）改成（位运算)
        hash取余%数组长度 等于 hash &（位运算）数组长度-1

        效率更高
     */

    //根据hash code去获取value
    Object get(int hash, Object key){
        int index = hash & (table.length - 1);

        //没有找到
        if (table[index] == null){
            return null;
        }

        Entry pointer = table[index];

        //遍历链表
        while(pointer != null){
            //如果找到就返回value
            if (pointer.key.equals(key)){ //检查链表中的key是不是我们想要找的key
                return pointer.value;
            }
            //没有找到就下一个数据
            pointer = pointer.next;
        }

        //循环结束之后都还没找到就返回null
        return null;
    }

    /**
     * 向hash table 存入新key value，如果key重复，则更新value
     * @param hash
     * @param key
     * @param value
     */
    void put(int hash, Object key, Object value){
        int index = hash & (table.length - 1);

        //如果有空位，直接添加数据
        if (table[index] == null){
            table[index] = new Entry(hash, key, value);
        }
        // 如果 index 处无空位，沿着链表查找
        // 如果 key 相同，更新value
        // 否则新增
        else {
            Entry pointer = table[index];

            while(pointer != null){
                //key 相同， 更新
                if (pointer.key.equals(key)){
                    pointer.value = value;
                    return;
                }

                //有空位，新增
                if (pointer.next == null){
                    pointer.next = new Entry(hash, key, value);
                    pointer = pointer.next;
                }

                pointer = pointer.next;
            }
        }
        size++;
    }

    Object remove(int hash, Object key){
        int index = hash % table.length;

        //链表中没有元素，返回null
        if (table[index] == null){
            return null;
        }

        Entry pointer = table[index];
        Entry prev = null; //记录前一个节点

        while(pointer != null){
            if (pointer.key.equals(key)){

                //当要删除的节点是第一个节点时
                //直接把原本的第一个节点换成它的下一个
                if (prev == null){
                    table[index] = pointer.next;
                }
                //在链表中间删除时，需要把前一个节点和后一个节点连接起来
                else {
                    prev.next = pointer.next;
                }

                size--;
                return pointer.value;

            }

            //当没有找到时：
            prev = pointer; //记录上一个节点
            pointer = pointer.next; //更新到下一个节点

        }

        return null;
    }

}
