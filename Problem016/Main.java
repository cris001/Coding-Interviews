输入一个链表，反转链表后，输出链表的所有元素。
扩展题：输出反转后链表的头节点，定义三个指针反向输出。
思路：定义两个指针，反向输出
代码实现：
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode p = null;
        while(cur!=null){
            ListNode t = cur.next;
            cur.next = p;
            p = cur;
            cur = t;
        }
        return p;
    }
}