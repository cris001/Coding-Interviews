输入一个链表，从尾到头打印链表每个节点的值。
思路：借助栈实现，或使用递归的方法。
代码实现：
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null){
            return list;
        }
        Stack<ListNode> mystack = new Stack<>();
        while(listNode != null){
            mystack.push(listNode);
            listNode = listNode.next;
        }
        while(!mystack.empty()){
            list.add(mystack.pop().val);
        }
        
        return list;
    }
}