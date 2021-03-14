package algorithm.structure;

import lombok.Data;

/**
 * @author kelai 2020-06-06 10:34
 */
@Data
public class TreeNode<T> {

    public T val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T x) { val = x; }
    public TreeNode() {

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value='" + val + '\'' +
                '}';
    }

    public T getValue() {
        return val;
    }

    public void setValue(T value) {
        this.val = value;
    }
}
