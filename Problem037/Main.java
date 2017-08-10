输入两个链表，找出它们的第一个公共结点。
思路：先求出链表长度，然后长的链表先走多出的几步，然后两个链表同时向下走去寻找相同的节点，代码量少的方法需要将两个链表遍历两次，然后从头开始相同的节点。
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
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
         while(l1!=l2){
             if (l1 == null){
                 l1 = pHead2;
             }else{
                 l1 = l1.next;
             }
             if (l2 == null){
                 l2 = pHead1;
             }else{
                 l2 = l2.next;
             }
         }
        return l1;
    }
}