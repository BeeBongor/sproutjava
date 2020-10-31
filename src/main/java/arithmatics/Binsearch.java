package arithmatics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dengmingliang
 * @Description
 * @ClassName Binsearch
 * @Date 2019/12/7 1:59 下午
 */
public class Binsearch {

    public boolean search(int[] array, int key) {
        return searchA(array, 0, array.length, key);
    }

    public boolean Find(int target, int[][] array) {
        int column = array.length;
        int row = array[0].length;
        if (column == 0 || row == 0) {
            return false;
        }
        int i = column - 1;
        int j = 0;
        while (i >= 0 && j < row) {
            if (array[i][j] > target) {
                i--;
                j = 0;
                continue;
            }
            if (array[i][j] < target) {
                if (j == row - 1) {
                    i--;
                    j = 0;
                    continue;
                }
                j++;
            }
            if (array[i][j] == target) {
                return true;
            }
        }
        return false;

    }

    private boolean searchA(int[] array, int left, int right, int key) {
        if (left >= right - 1) {
            if (array[left] == key || array[right] == key) {
                return true;
            }
            return false;
        }
        int i = left + (right - left) / 2;
        if (array[i] > key) {
            return searchA(array, left, i, key);
        } else if (array[i] == key) {
            return true;
        } else {
            return searchA(array, i, right, key);
        }
    }

    public static void main(String[] args) {
        Binsearch binsearch = new Binsearch();
        int[] key = {1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 40, 90};
        for (int i : key) {
            System.out.println(i);
            System.out.println(binsearch.search(key, i));
        }
        System.out.println(binsearch.search(key, 10));
    }

    public String replaceSpace(StringBuffer str) {
        String replace = str.toString();
        replace.replace(" ", "%20");
        return replace;
    }

    public ArrayList<Integer> printListFromTailToHead(TwoNumberSum.ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        return recurseNode(list, listNode);
    }

    private ArrayList<Integer> recurseNode(ArrayList<Integer> list, TwoNumberSum.ListNode listNode) {
        if (listNode.next == null) {
            return null;
        }
        recurseNode(list, listNode.next);
        list.add(listNode.val);
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = new TreeNode(pre[0]);
        rebuildTree(pre, in, treeNode);
        return treeNode;
    }

    private void rebuildTree(int[] pre, int[] in, TreeNode treeNode) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                if (i > 0) {
                    treeNode.left = new TreeNode(pre[1]);
                    int[] left = Arrays.copyOfRange(pre, 1, i + 1);
                    int[] right = Arrays.copyOfRange(in, 0, i);
                    rebuildTree(left, right, treeNode.left);
                }
                if (i < in.length - 1) {
                    treeNode.right = new TreeNode(pre[i + 1]);
                    int[] left = Arrays.copyOfRange(pre, i + 1, pre.length);
                    int[] right = Arrays.copyOfRange(in, i + 1, in.length);
                    rebuildTree(left, right, treeNode.right);
                }
            }
        }

    }

    @Test
    public void rebuildTest() {
        TreeNode treeNode = reConstructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7});
        System.out.println(treeNode);
    }

    public int recurse(TwoNumberSum.ListNode node, int k) {
        if (node.next == null) {
            if (k == 1) {
                System.out.println(node.val);
            }
            return 1;
        }
        int result = recurse(node.next, k) + 1;
        if (result == k) {
            System.out.println(node.val);
        }
        return result;
    }


    public int lookup(TreeNode root,int maxDepth) {

        int leftdeep = 0, rightdeep = 0;
        if (root.left != null) {
            leftdeep++;
            leftdeep = lookup(root.left, leftdeep);
        }
        if (root.right != null) {
            rightdeep++;
            rightdeep = lookup(root.right, rightdeep);
        }
        maxDepth += leftdeep > rightdeep ? leftdeep : rightdeep;
        return maxDepth;
    }




        /**
         * 复杂度
         * @param k
         * @param left
         * @param right
         * @return
         */
    public int[] quickSort(int[] k, int left, int right) {
        if (left >= right) return null;

        int temp = k[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (k[j] >= temp && j > i) {
                j--;
            }
            if (i < j) {
                k[i] = k[j];
            }
            while (k[i] < temp && j > i) {
                i++;
            }
            if (i < j) {
                k[j] = k[i];

            }
        }
        k[i] = temp;
        quickSort(k, left, i - 1);
        quickSort(k, i + 1, right);
        return k;
    }

    @Test
    public void swapValue() {
        int[] t = {4, 3, 4, 2, 10, 5, 7, 9, 2, 2, 2};

        System.out.println(quickSort(t, 0, t.length - 1));
        for (int m : t) {
            System.out.println(m);
        }
    }


}
