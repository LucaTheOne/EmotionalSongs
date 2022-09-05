
package emotionalsongs.HeapSorter;

import emotionalsongs.BasicsStructure.PlaylistSet;
import emotionalsongs.*;

/**
 *
 * @author big
 */
public class HeapSortDatabasePlaylists {
   public void sort(PlaylistSet[] setArray){
	int N = setArray.length;

	// Build heap (rearrange array)
	for (int i = N / 2 - 1; i >= 0; i--) buildHeap(setArray, N, i);

	// One by one extract an element from heap
	for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            PlaylistSet temp = setArray[0];
            setArray[0] = setArray[i];
            setArray[i] = temp;

            // call max buildHeap on the reduced heap
            buildHeap(setArray, i, 0);
	}
    }

	// To buildHeap a subtree rooted with node i which is
	// an index in setArray[]. n is size of heap
    void buildHeap(PlaylistSet[] setArray, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && setArray[l].compareTo(setArray[largest])>0) largest = l;

        // If right child is larger than largest so far
        if (r < N && setArray[r].compareTo(setArray[largest])>0) largest = r;

        // If largest is not root
        if (largest != i) {
            PlaylistSet swap = setArray[i];
            setArray[i] = setArray[largest];
            setArray[largest] = swap;

            // Recursively buildHeap the affected sub-tree
            buildHeap(setArray, N, largest);
        }
    } 
}
