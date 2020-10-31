package mathmatics.tree;

import mathmatics.tree.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengmingliang on 2020/4/23
 */
public class RightSideTree {

  public static List<Integer> getRightSideView(TreeNode treeNode) {
    // 层序遍历
    List<Integer> rightSeeNodeVal = new ArrayList<>();
    if (treeNode == null) {
      return rightSeeNodeVal;
    }
    List<TreeNode> currentLevelNodes = new ArrayList<>();
    currentLevelNodes.add(treeNode);
    while (currentLevelNodes.size() != 0) {
      List<TreeNode> nextLevelNodes = new ArrayList<>();
      rightSeeNodeVal.add(currentLevelNodes.get(currentLevelNodes.size() - 1).val);
      for (int i = 0; i < currentLevelNodes.size(); i++) {
        if (currentLevelNodes.get(i) != null) {
          if (currentLevelNodes.get(i).left != null) {
            nextLevelNodes.add(currentLevelNodes.get(i).left);
          }
          if (currentLevelNodes.get(i).right != null) {
            nextLevelNodes.add(currentLevelNodes.get(i).right);
          }
        }
      }
      currentLevelNodes = nextLevelNodes;
    }
    return rightSeeNodeVal;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.right = new TreeNode(4);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(6);
    root.left.left.left = new TreeNode(7);
    System.out.println(getRightSideView(root));

  }


}
