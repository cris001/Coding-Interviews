输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
思路：递归与非递归求解，小数放在前面。
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
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode t = null;
        if (list1.val < list2.val){
            t = list1;
            t.next = Merge(list1.next, list2);
        }else{
            t = list2;
            t.next = Merge(list1, list2.next);
        }
        return t;
    }
}