public class QuaternaryHeapsort{

    /**
     * Time Complexity: O(n log_4 n) Building the heap requires the array to
     * be traversed O(n). quaternaryDownheap requires O(log_4 n).
     * Space Complexity: O(1) array sorted inplace, no extra memory used.
     * Sorts the input array, in-place, using a quaternary heap sort.
     *
     * @param input to be sorted (modified in place)
     */
    public static <T extends Comparable<T>> void quaternaryHeapsort(T[] input) {
        int size = input.length;

        //Build the max heap.
        for(int i = size / 4 - 1; i >= 0; i--){
            quaternaryDownheap(input, i, size );
        }

        //Sort the heap.
        for (int i = size - 1; i >= 0; i--){
            swap(input, 0, i);
            quaternaryDownheap(input, 0,i);
        }
    }

    /**
     * Time Complexity: O(log_4 n). Height of the quaternary tree is log_4 n.
     * In the worst case, the leaf node needs to be swapped with the root
     * node, resulting in log_4(n) of comparisons and swaps in the tree.
     *
     * Space Complexity: O(1) array sorted inplace, no extra memory used.
     * Performs a downheap from the element in the given position on the given max heap array.
     *
     * A downheap should restore the heap order by swapping downwards as necessary.
     * The array should be modified in place.
     * 
     * You should only consider elements in the input array from index 0 to index (size - 1)
     * as part of the heap (i.e. pretend the input array stops after the inputted size).
     *
     * @param input array representing a quaternary max heap.
     * @param start position in the array to start the downheap from.
     * @param size the size of the heap in the input array, starting from index 0
     */
    public static <T extends Comparable<T>> void quaternaryDownheap(T[] input, int start, int size) {
        int largest = start;
        int left = 4 * start + 1;
        int leftMid = 4 * start + 2;
        int rightMid = 4 * start + 3;
        int right = 4 * start + 4;

        //Check each node and find the largest to become the root node.
        if (left < size && input[left].compareTo(input[largest]) > 0){
            largest = left;
        }
        if (leftMid < size && input[leftMid].compareTo(input[largest]) > 0){
            largest = leftMid;
        }
        if (rightMid < size && input[rightMid].compareTo(input[largest]) > 0){
            largest = rightMid;
        }
        if (right < size && input[right].compareTo(input[largest]) > 0){
            largest = right;
        }

        //Call Downheap again if root node is not the largest.
        if (largest != start){
            swap(input, start, largest);
            quaternaryDownheap(input, size ,largest);
        }
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Swaps the position between 2 indexes of a given array.
     * @param input The array to be modified in place.
     * @param pos1 First index to be swapped with.
     * @param pos2 Second index to be swapped with.
     */
    private static <T extends Comparable<T>> void swap(T[]input, int pos1,
                                                       int pos2){
        T temp = input[pos1];
        input[pos1] = input[pos2];
        input[pos2] = temp;
    }
}
