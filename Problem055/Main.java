在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
思路：先新建一个头节点，然后向后查找值相同的节点，重复查找后删除
代码实现：
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode t = new ListNode(-1);
        if (pHead == null){
            return t.next;
        }
        t.next = pHead;
        ListNode p = pHead;
        ListNode pre = t;
        while(p!=null && p.next != null){
            if (p.val != p.next.val){
                pre = p;
                p = p.next;
            }else{
                int v = p.val;
                while(p.next != null && p.next.val == v){
                    p = p.next;
                }
                pre.next = p.next;
                p = p.next;
            }
            
        }
        return t.next;
    }
}