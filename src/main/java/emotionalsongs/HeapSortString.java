
package emotionalsongs;

/**
 *
 * @author big
 */
public class HeapSortString {
    
    boolean caseSensitive;
    
    public HeapSortString(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }
    
    public void sort(String[] string) {
	int N = string.length;

	// Build heap (rearrange array)
	for (int i = N / 2 - 1; i >= 0; i--) heapify(string, N, i);

	// One by one extract an element from heap
	for (int i = N - 1; i > 0; i--) {
            // Move current root to end
		String temp = string[0];
		string[0] = string[i];
		string[i] = temp;

		// call max heapify on the reduced heap
		heapify(string, i, 0);
	}
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(String arr[], int N, int i) {
	int largest = i; // Initialize largest as root
	int l = 2 * i + 1; // left = 2*i + 1
	int r = 2 * i + 2; // right = 2*i + 2

	// If left child is larger than root
	if (l < N && caseSensitive ? arr[l].compareTo(arr[largest])>0 : arr[l].compareToIgnoreCase(arr[largest])>0) 
            largest = l;

	// If right child is larger than largest so far
	if (r < N && caseSensitive ? arr[r].compareTo(arr[largest])>0 : arr[r].compareToIgnoreCase(arr[largest])>0)
            largest = r;

	// If largest is not root
	if (largest != i) {
            String swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
		heapify(arr, N, largest);
	}
    }
    
}
