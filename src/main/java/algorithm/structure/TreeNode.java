package algorithm.structure;

import lombok.Data;

/**
 * @author kelai 2020-06-06 10:34
 */
@Data
public class TreeNode {

    private String value;
    private TreeNode left;
    private TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
