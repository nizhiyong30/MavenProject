package algorithm.Tree;

import java.util.HashMap;

/**
 * @author nizy
 * @date 2021/12/7 2:09 下午
 */
public class Connect {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connect(root.left, root.right);
        return root;
    }

    public void connect(Node leftNode, Node rightNode) {
        if (leftNode == null || rightNode == null) {
            return;
        }
        leftNode.next = rightNode;
        connect(leftNode.left, leftNode.right);
        connect(rightNode.left, rightNode.right);
        connect(leftNode.right, rightNode.left);
    }



    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap();
        map.put("abc", "abc");
        String value = map.get("Abc");;
        System.out.println(value);

    }
}
