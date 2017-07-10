从上往下打印出二叉树的每个节点，同层节点从左至右打印。
思路：利用队列（链表）辅助实现。
代码实现：
public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>();
    if (root == null) {
        return list;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null) {
            queue.addLast(node.left);
        }
        if (node.right != null) {
            queue.addLast(node.right);
        }
    }
    return list;
}