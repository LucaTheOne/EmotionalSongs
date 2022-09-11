
package emotionalsongs.SorterAlgorithms.SorterPlaylistsSetAlgo;

import emotionalsongs.BasicsStructure.*;

/**
 *
 * @author big
 */
public class SorterPlaylistSet {
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
