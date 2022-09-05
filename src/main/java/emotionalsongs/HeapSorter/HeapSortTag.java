/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionalsongs.HeapSorter;

import emotionalsongs.BasicsStructure.Song;
import emotionalsongs.*;

public class HeapSortTag {
    public void sort(Song[] songsArray){
	int N = songsArray.length;

	// Build heap (rearrange array)
	for (int i = N / 2 - 1; i >= 0; i--) buildHeap(songsArray, N, i);

	// One by one extract an element from heap
	for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            Song temp = songsArray[0];
            songsArray[0] = songsArray[i];
            songsArray[i] = temp;

            // call max buildHeap on the reduced heap
            buildHeap(songsArray, i, 0);
	}
    }

	// To buildHeap a subtree rooted with node i which is
	// an index in songsArray[]. n is size of heap
    void buildHeap(Song[] songsArray, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && songsArray[l].compareTag(songsArray[largest])>0) largest = l;

        // If right child is larger than largest so far
        if (r < N && songsArray[r].compareTag(songsArray[largest])>0) largest = r;

        // If largest is not root
        if (largest != i) {
            Song swap = songsArray[i];
            songsArray[i] = songsArray[largest];
            songsArray[largest] = swap;

            // Recursively buildHeap the affected sub-tree
            buildHeap(songsArray, N, largest);
        }
    }
}