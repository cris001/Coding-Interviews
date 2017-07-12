输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
思路：先复制链表的next节点，将复制后的节点接在原节点后，然后复制其它的节点，最后取偶数位置的节点（复制后的节点）。
代码实现：
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null){
            return null;
        }
        RandomListNode p = new RandomListNode(pHead.label);
        RandomListNode t = p;
        while(pHead.next != null){
            t.next = new RandomListNode(pHead.next.label);
            if (pHead.random != null){
                t.random = new RandomListNode(pHead.random.label);
            }
            pHead = pHead.next;
            t = t.next;
        }
        return p;
    }
}