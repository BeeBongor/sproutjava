package arithmatics;

import static jdk.nashorn.internal.objects.NativeString.search;

/**
 * @author dengmingliang
 * @Description
 * @ClassName BinaryTree
 * @Date 2019/12/10 3:03 下午
 */
public class BinaryTree {

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 前序遍历二叉树
     */
    public void traverse(TreeNode tree) {
        if (tree.left != null) {
            traverse(tree.left);
        }

        System.out.print(tree.val + " ");
        if (tree.right != null) {
            traverse(tree.right);
        }

    }

    /**
     * 重建二叉平衡树 dependon 有序数组
     *
     * @param args
     */
    public TreeNode buildBinarySearch(int[] args) {
        int middle = args.length / 2;
        TreeNode root = new TreeNode(args[middle]);
        root.left = generateBinaryTree(args, 0, middle - 1);
        root.right = generateBinaryTree(args, middle + 1, args.length - 1);
        return root;
    }

    /**
     * 根据有序数组生成平衡二叉树，左子树+右子树
     *
     * @param args
     * @param left
     * @param right
     * @return
     */
    private TreeNode generateBinaryTree(int[] args, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(args[(left + right) / 2]);
        root.left = generateBinaryTree(args, left, (left + right) / 2 - 1);
        root.right = generateBinaryTree(args, (left + right) / 2 + 1, right);
        return root;
    }

    /**
     * 树深度
     *
     * @param treeNode
     */
    public int getDepth(TreeNode treeNode, int deep) {
        if (treeNode == null) return 0;
        int left = 0;
        int right = 0;
        if (treeNode.left != null) {
            left = getDepth(treeNode.left, left) + 1;
        }
        if (treeNode.right != null) {
            right = getDepth(treeNode.right, right) + 1;
        }
        deep += left > right ? left : right;
        return deep;
    }

    /**
     * 插入二叉平衡树
     *
     * @param
     */
    public int insert(TreeNode root, int i) {
        //find place
        int t = 0;
        int k = 0;
        if (i < root.val && root.left != null) {
            k = 1;
            t = insert(root.left, i);
        } else if (i < root.val && root.left == null) {
            k = 2;
            root.left = new TreeNode(i);
            return 1;
        } else if (i >= root.val && root.right != null) {
            k = 3;
            t = insert(root.right, i);
        } else if (i >= root.val && root.right == null) {
            k = 4;
            root.right = new TreeNode(i);
            return 1;
        }
        if (t == 2) {
            //说明当前节点的子节点insert了
            if(k==1){
//                getNodeBalace(root);
            }
//            if (root>)

                t = 0;
        }
        //平衡操作
        if (t == 1) {
            //说明是在下一层完成的赋值操作，应该是放在了当前root的left/right
            t++;
        }
        return t;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.buildBinarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 20, 21});
        binaryTree.traverse(root);
        System.out.println();
        System.out.println(binaryTree.getDepth(root, 1));

        //insert binaryTree

    }
}
