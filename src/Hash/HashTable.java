package Hash;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HashTable {

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
    float loadFactor = 0.75f; //元素个素达到数组的四分之三就将数组扩容
    int threshold = (int)(loadFactor * table.length);


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
        int index = hash % (table.length);

        //如果有空位，直接添加数据
        if (table[index] == null){
            table[index] = new Entry(hash, key, value);
        }
        // 如果 index 处无空位，沿着链表查找
        // 如果 key 相同，更新value
        // 否则新增
        else {
            Entry pointer = table[index];
            boolean running = true;
            while(running){
                //key 相同， 更新
                if (pointer.key.equals(key)){
                    pointer.value = value;
                    return;
                }

                if (pointer.next == null){
                    running = false;
                }else{
                    pointer = pointer.next;
                }
            }
            pointer.next = new Entry(hash, key, value);
        }
        size++;

        //扩容
        if (size > threshold){
            resize();
        }


    }



    private void resize(){
        //创建一个容量翻倍的数组
        Entry[] newTable = new Entry[table.length * 2];

        for (int i = 0; i < table.length; i++) {
            Entry pointer = table[i]; //拿到链表头
            if(pointer != null){
                //拆分链表，移动到新数组
                //一个链表最多拆成两个
                //hash & table.length == 0的一组
                //hash & table.length != 0的一组
                //分配到 a b 两个指针

                Entry pointerA = null;
                Entry pointerB = null;

                //需要两个链表的头指针
                Entry aHead = null;
                Entry bHead = null;

                while (pointer != null){
                    //Bitwise operation AND(&):
                    //The AND operator compares each binary digit of two integers
                    //and gives back 1 if both are 1, otherwise it returns 0.
                    if ((pointer.hash & table.length) == 0) {
                        //先设置head指针
                        if (pointerA == null){
                            aHead = pointer;
                        }

                        //在分配到pointerA之前，先把它的next指针指向下一个元素
                        if (pointerA != null){
                            pointerA.next = pointer;
                        }

                        //在完成上面的步骤时才能更新pointerA节点
                        //分配到 pointerA
                        pointerA = pointer;
                    }else {
                        //设置head指针
                        if (pointerB == null){
                            bHead = pointer;
                        }

                        if (pointerB != null){
                            pointerB.next = pointer;
                        }

                        //分配到 pointerB
                        pointerB = pointer;
                    }
                    pointer = pointer.next;
                }

                //当循环结束，分配完最后一个元素时，应该把指针A和B的next指针设置为null
                if (pointerA != null){
                    pointerA.next = null;

                    //设置新链表的数组储存位置
                    //链表A会在原来的索引中
                    newTable[i] = aHead;
                }
                if (pointerB != null){
                    pointerB.next = null;

                    //设置新链表的数组储存位置
                    //链表B会在i加上数组长度的索引位置
                    newTable[i + table.length] = aHead;
                }

            }
        }

        //将新的hash table覆盖旧的table
        table = newTable;

        //新的阈值
        threshold = (int)(loadFactor * table.length);
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



    /*
        改造 get（） put（） remove（）这三个方法
        现在这三个方法可以自己生成哈希值
     */
    private int hash(Object key) {
        return key.hashCode();
    }
    public Object get(Object key){
        int hash = hash(key);

        return get(hash, key);
    }

    public void put(Object key, Object value){
        int hash = hash(key);

        put(hash, key, value);
    }

    public Object remove(Object key){
        int hash = hash(key);

        return remove(hash, key);
    }

    public void print() {
        int[] sums = new int[table.length];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            while (p != null){
                sums[i]++;
                p = p.next;
            }
        }

        //用Map集合去统计元素个素
        Map<Integer, Long> collect = Arrays.stream(sums).boxed().collect(Collectors.groupingBy(
                e -> e, Collectors.counting()
        ));

        System.out.println(collect);
    }




}
