package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q501二叉搜索树中的众数 {

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 使用map，key记录root.val, val记录频率
        Map<Integer, Integer> map = new HashMap<>();
        preorder(root, map);  // 使用前序去遍历并记录在map中

        // 找到最大频率在map中
        int maxFrequency = 0;
        for (int freq : map.values()) {   // .values返回一个数组
            if (freq > maxFrequency) {
                maxFrequency = freq;
            }
        }

        // 因为可能有很多最大频率是一样的，所以要把他先收集到list中以便拿到其size去创建array
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }

        // 创建resArr并添加modes(list)中的元素
        int[] resArr = new int[modes.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = modes.get(i);
        }

        return resArr;
    }

    private void preorder(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            preorder(root.left, map);
            preorder(root.right, map);
        }
    }

}
