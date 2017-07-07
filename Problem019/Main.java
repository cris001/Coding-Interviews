操作给定的二叉树，将其变换为源二叉树的镜像。
思路：使用递归或非递归方式交换每个节点的左右子树位置。
代码实现：
/*
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};*/
class Solution {
public:
    void Mirror(TreeNode *pRoot) {
        if (pRoot == nullptr){
            return;
        }
        TreeNode *lchild = pRoot->left;
        pRoot->left = pRoot->right;
        pRoot->right = lchild;
        Mirror(pRoot->left);
        Mirror(pRoot->right);
    }
};