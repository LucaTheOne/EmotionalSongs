package emotionalsongs.HeapSorter;

public class HeapSortInt {
    
    public void sort(int[] intsArray) {
	int N = intsArray.length;

	// Build heap (rearrange array)
	for (int i = N / 2 - 1; i >= 0; i--)
		heapify(intsArray, N, i);

	// One by one extract an element from heap
	for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = intsArray[0];
            intsArray[0] = intsArray[i];
            intsArray[i] = temp;

            // call max heapify on the reduced heap
            heapify(intsArray, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in intsArray[]. n is size of heap
	
    void heapify(int[] intsArray, int N, int i) {
	int largest = i; // Initialize largest as root
	int l = 2 * i + 1; // left = 2*i + 1
	int r = 2 * i + 2; // right = 2*i + 2

	// If left child is larger than root
	if (l < N && intsArray[l] > intsArray[largest])
		largest = l;

	// If right child is larger than largest so far
	if (r < N && intsArray[r] > intsArray[largest])
		largest = r;

	// If largest is not root
	if (largest != i) {
		int swap = intsArray[i];
		intsArray[i] = intsArray[largest];
		intsArray[largest] = swap;

		// Recursively heapify the affected sub-tree
		heapify(intsArray, N, largest);
	}
    }
    
    public static void main(String[] args) {
        HeapSortInt heap = new HeapSortInt();
        int[] interi = {98,56,23,97,102};
        heap.sort(interi);
        for (int i = 0; i < 5; i++) {
            System.out.println(interi[i]);
        }
    }
}

