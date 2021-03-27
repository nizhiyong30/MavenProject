package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author nizy
 * @date 2021/3/15 1:03 下午
 */
public class Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        result.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<Integer>(i + 1);
            innerList.add(1);
            for (int j = 1; j < i; j++) {
                innerList.add(result.get(i - 1).get(j - 1) +  result.get(i - 1).get(j));
            }
            innerList.add(1);
            result.add(innerList);
        }
        return result;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle.generate(3));
    }
}
