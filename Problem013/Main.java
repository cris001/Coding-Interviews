O(1)时间删除链表节点 
思路：将要删除节点的下一个节点的值赋给要删除的节点，然后指向下下一个节点
代码实现：
public void deleteNode(ListNode head, ListNode deListNode) {
    if (deListNode == null || head == null)
        return;

    if (head == deListNode) {
        head = null;
    } else {
        // 若删除节点是末尾节点，往后移一个
        if (deListNode.nextNode == null) {
            ListNode pointListNode = head;
            while (pointListNode.nextNode.nextNode != null) {
                pointListNode = pointListNode.nextNode;
            }
            pointListNode.nextNode = null;
        } else {
            deListNode.data = deListNode.nextNode.data;
            deListNode.nextNode = deListNode.nextNode.nextNode;
        }
    }
}