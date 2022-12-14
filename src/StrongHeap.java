import java.util.*;
public class StrongHeap {
    /**
     * Time Complexity:
     * Space Complexity:
     * Determines whether the binary tree with the given root node is a "strong
     * binary heap", as described in the assignment task sheet.
     * <p>
     * A strong binary heap is a binary tree which is: - a complete binary tree,
     * AND - its values satisfy the strong heap property.
     *
     * @param root root of a binary tree, cannot be null.
     *
     * @return true if the tree is a strong heap, otherwise false.
     */
    public static boolean isStrongHeap(BinaryTree<Integer> root) {
        Queue<BinaryTree> queue = new LinkedList();
        boolean nullVal = false;
        queue.add(root);

        //Traverse tree level ordered.
        while (!queue.isEmpty()){
            BinaryTree<Integer> current = queue.poll();

            if (current == null){
                nullVal = true;
            }
            else {
                if (nullVal) {
                    return false;
                }
                queue.add(current.getLeft());
                queue.add(current.getRight());
                if (!compareNodes(current)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Time Complexity:
     * Space Complexity:
     *
     * @param current
     * @return
     */
    private static boolean compareNodes (BinaryTree<Integer> current){
        BinaryTree<Integer> leftChild = current.getLeft();
        BinaryTree<Integer> rightChild = current.getRight();
        //Check if left node + Parent < Grandparent
        if (leftChild != null){
            BinaryTree<Integer> leftChildChild = leftChild.getLeft();
            if (leftChildChild != null && leftChildChild.getValue()
                    + leftChild.getValue() >= current.getValue()){
                return false;
            }
            //check if left node is less than parent.
            if (leftChild.getValue() >= current.getValue()) {
                return false;
            }
        }
        //Check if right node + Parent < Grandparent
        if (rightChild != null){
            BinaryTree<Integer> rightChildChild = rightChild.getRight();
            if (rightChildChild != null && rightChildChild.getRight().getValue()
                    + rightChild.getValue() >= current.getValue()){
                return false;
            }

            //Check if right node is less than parent.
            if (rightChild.getValue() >= current.getValue()){
                return false;
            }
        }
        return true;
    }
}


