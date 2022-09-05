
package emotionalsongs.HeapSorter;

import emotionalsongs.BasicsStructure.Record;

public class HeapSortRecord {
    public void sort(Record[] recordsArray){
	int N = recordsArray.length;

	// Build heap (rearrange array)
	for (int i = N / 2 - 1; i >= 0; i--) buildHeap(recordsArray, N, i);

	// One by one extract an element from heap
	for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            Record temp = recordsArray[0];
            recordsArray[0] = recordsArray[i];
            recordsArray[i] = temp;

            // call max buildHeap on the reduced heap
            buildHeap(recordsArray, i, 0);
	}
    }

	// To buildHeap a subtree rooted with node i which is
	// an index in recordsArray[]. n is size of heap
    void buildHeap(Record[] recordsArray, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && recordsArray[l].compareTo(recordsArray[largest])>0) largest = l;

        // If right child is larger than largest so far
        if (r < N && recordsArray[r].compareTo(recordsArray[largest])>0) largest = r;

        // If largest is not root
        if (largest != i) {
            Record swap = recordsArray[i];
            recordsArray[i] = recordsArray[largest];
            recordsArray[largest] = swap;

            // Recursively buildHeap the affected sub-tree
            buildHeap(recordsArray, N, largest);
        }
    }
}