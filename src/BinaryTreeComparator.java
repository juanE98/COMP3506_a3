import java.util.Comparator;

/**
 * A comparator for Binary Trees.
 */
public class BinaryTreeComparator<E extends Comparable<E>> implements Comparator<BinaryTree<E>> {

    /**
     * Compares two binary trees with the given root nodes.
     *
     * Two nodes are compared by their left childs, their values, then their right childs,
     * in that order. A null is less than a non-null, and equal to another null.
     *
     * @param tree1 root of the first binary tree, may be null.
     * @param tree2 root of the second binary tree, may be null.
     * @return -1, 0, +1 if tree1 is less than, equal to, or greater than tree2, respectively.
     */
    @Override
    public int compare(BinaryTree<E> tree1, BinaryTree<E> tree2) {
        if (tree1 == null){
            return -1;
        }

        compare(tree1.getLeft(),tree2.getLeft());
        if (tree1.getValue().compareTo(tree2.getValue()) > 0){
            return 1;
        }
        else if (tree1.getValue().compareTo(tree2.getValue()) < 0){
            return -1;
        }

        if (comparison(tree1.getRight(),tree2.getRight()) != 0) {
            return comparison(tree1.getRight(),tree2.getRight());
        }

        return 0;
    }

    private int comparison(BinaryTree<E> tree1, BinaryTree<E> tree2){
        if (tree1 == null && tree2 != null){
            return -1;
        }
        if (tree1 != null && tree2 == null){
            return 1;
        }
        if (tree1 != null && tree2 != null) {
            if (tree1.getValue().compareTo(tree2.getValue()) > 0) {
                return 1;
            }
            else if (tree1.getValue().compareTo(tree2.getValue()) < 0) {
                return -1;
            }
        }
        return 0;
    }


}
