给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
思路：若节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；若节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果
代码实现：
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null){
            return null;
        }
        TreeLinkNode p = pNode;
        if (pNode.right!=null){
            p = pNode.right;
            while(p.left!=null){
                p = p.left;
            }
            return p;
        }
        TreeLinkNode pre = pNode;
        p = pNode;
        while(p.next!=null){
            if (p.next.left == p){
                return p.next;
            }
            pre = p;
            p = p.next;
        }
        return p.next;
    }
}