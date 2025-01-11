package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.w3c.dom.Node;

public class Q429N叉树的层序遍历 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node currNode = q.poll();
                tempList.add(currNode.val);
                List<Node> children = currNode.children;
                if (currNode == null || children.size() == 0) {
                    continue;
                }
                for (Node child : children) {
                    if (child != null) {
                        q.offer(child);
                    }
                }
            }
            res.add(tempList);
        }
        return res;
    }
}
