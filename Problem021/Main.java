定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
思路：定义两个栈，一个存放入的值。另一个存最小值。
代码实现：
public void push(int node) {
    stack1.push(node);
    if (stack2.isEmpty()) {
        stack2.push(node);
    }else {
        if (stack2.peek() > node) {
            stack2.push(node);
        }
    }
}

public void pop() {
    if (stack1.pop() == stack2.peek()) {
        stack2.pop();
    }
}

public int top() {
    return stack1.peek();
}

public int min() {
    return stack2.peek();
}