输入一个链表，输出该链表中倒数第k个结点。
扩展题：找中间节点，使用两个指针，一个走一步，一个走两步。找到中间节点
思路：定义一快一慢两个指针，快指针走K步，然后慢指针开始走，快指针到尾时，慢指针就找到了倒数第K个节点。
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
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k<=0){
            return null;
        }
        if (getLength(head) < k){
            return null;
        }
        ListNode p = head;
        for(int i = 1;i<=k;i++){
            p = p.next;
        }
        ListNode ret = head;
        while(p!=null){
            p = p.next;
            ret = ret.next;
        }
        return ret;
    }
    
    public int getLength(ListNode head){
        int l = 1;
        ListNode p = head;
        while (p.next != null){
            p = p.next;
            l++;
        }
        return l;
    }
}