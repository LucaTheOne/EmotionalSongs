/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */



package emotionalsongs.sorting_algos.playlists_set_sorting_algo;

import emotionalsongs.basic_structures.*;

/**
 * Classe contenent metodi per riordinare un array di playlist,
 * alfabeticalmente, sulla base del nome delle playlist contenute.
 */
public class SorterPlaylistSet {
    /**
     * Metodo per riordinare, alfabeticalmente,un array di playlist in base al nome delle playlist che contiene.
     * @param playlistsToSort Array di playlist da ordinare.
     */
    public void mergeSort(Playlist[] playlistsToSort) {	
	int currentSize;
	int leftStartIndex;
	for (currentSize = 1; currentSize <= playlistsToSort.length-1; currentSize = 2*currentSize) {
            for (leftStartIndex = 0; leftStartIndex < playlistsToSort.length-1;leftStartIndex += 2*currentSize) {
		int mid = Math.min(leftStartIndex + currentSize - 1, playlistsToSort.length-1);
		int endIndex = Math.min(leftStartIndex + 2*currentSize - 1, playlistsToSort.length-1);
		merge(playlistsToSort, leftStartIndex, mid, endIndex);
            }
	}
    }
	
    private void merge(Playlist[] arrayToSort, int leftIndex, int midIndex, int rightIndex) {
	int i, j, k;
	int sizeLeftPart = midIndex - leftIndex + 1;
	int sizeRightPart = rightIndex - midIndex;
	
	/* create temp arrays */
	Playlist L[] = new Playlist[sizeLeftPart];
	Playlist R[] = new Playlist[sizeRightPart];
	
	/* Copy data to temp arrays L[] and R[] */
	for (i = 0; i < sizeLeftPart; i++) L[i] = arrayToSort[leftIndex + i];
        for (j = 0; j < sizeRightPart; j++) R[j] = arrayToSort[midIndex + 1+ j];
	
	/* Merge the temp arrays back into arrayToSort[leftIndex..rightIndex]*/
	i = 0;
	j = 0;
	k = leftIndex;
	while (i < sizeLeftPart && j < sizeRightPart) {
            if (L[i].compareTo(R[j])<=0) {
		arrayToSort[k] = L[i];
		i++;
            } else {
                arrayToSort[k] = R[j];
		j++;
            }
            k++;
	}
	/* Copy the remaining elements of L[], if there are any */
	while (i < sizeLeftPart) {
            arrayToSort[k] = L[i];
            i++;
            k++;
	}
	
	
        /* Copy the remaining elements of R[], if there are any */
	while (j < sizeRightPart) {
            arrayToSort[k] = R[j];
            j++;
            k++;
	}
    }
}
