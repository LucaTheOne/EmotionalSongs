
package emotionalsongs.HeapSorter;

import emotionalsongs.BasicsStructure.Playlist;
import emotionalsongs.*;

/**
 *
 * @author big
 */
public class HeapSortPlaylistSet {
    public void sort(Playlist[] playlistsSetArray){
	int N = playlistsSetArray.length;

	// Build heap (rearrange array)
	for (int i = N / 2 - 1; i >= 0; i--) buildHeap(playlistsSetArray, N, i);

	// One by one extract an element from heap
	for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            Playlist temp = playlistsSetArray[0];
            playlistsSetArray[0] = playlistsSetArray[i];
            playlistsSetArray[i] = temp;

            // call max buildHeap on the reduced heap
            buildHeap(playlistsSetArray, i, 0);
	}
    }

	// To buildHeap a subtree rooted with node i which is
	// an index in playlistsSetArray[]. n is size of heap
    void buildHeap(Playlist[] playlistsSetArray, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && playlistsSetArray[l].compareTo(playlistsSetArray[largest])>0) largest = l;

        // If right child is larger than largest so far
        if (r < N && playlistsSetArray[r].compareTo(playlistsSetArray[largest])>0) largest = r;

        // If largest is not root
        if (largest != i) {
            Playlist swap = playlistsSetArray[i];
            playlistsSetArray[i] = playlistsSetArray[largest];
            playlistsSetArray[largest] = swap;

            // Recursively buildHeap the affected sub-tree
            buildHeap(playlistsSetArray, N, largest);
        }
    }
}
