
package emotionalsongs.SorterAlgorithms.SorterPlaylistsDatabaseAlgo;

import emotionalsongs.BasicsStructure.*;

/**
 *
 * @author big
 */
public class SorterDatabasePlaylists {
    public void mergeSort(PlaylistSet[] arraySetsToSort) {	
        int currentSize;
        int leftStartIndex;
        for (currentSize = 1; currentSize <= arraySetsToSort.length-1; currentSize = 2*currentSize) {
            for (leftStartIndex = 0; leftStartIndex < arraySetsToSort.length-1;leftStartIndex += 2*currentSize) {
                int mid = Math.min(leftStartIndex + currentSize - 1, arraySetsToSort.length-1);
                int endIndex = Math.min(leftStartIndex + 2*currentSize - 1, arraySetsToSort.length-1);
                merge(arraySetsToSort, leftStartIndex, mid, endIndex);
            }
        }
    }
	
    private void merge(PlaylistSet[] arraySetsToSort, int leftIndex, int midIndex, int rightIndex) {
        int i, j, k;
        int sizeLeftPart = midIndex - leftIndex + 1;
        int sizeRightPart = rightIndex - midIndex;
	
        /* create temp arrays */
        PlaylistSet L[] = new PlaylistSet[sizeLeftPart];
        PlaylistSet R[] = new PlaylistSet[sizeRightPart];
	
        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < sizeLeftPart; i++) L[i] = arraySetsToSort[leftIndex + i];
        for (j = 0; j < sizeRightPart; j++) R[j] = arraySetsToSort[midIndex + 1+ j];
	
        /* Merge the temp arrays back into arraySetsToSort[leftIndex..rightIndex]*/
        i = 0;
        j = 0;
        k = leftIndex;
        while (i < sizeLeftPart && j < sizeRightPart) {
            if (L[i].compareTo(R[j])<=0) {
                arraySetsToSort[k] = L[i];
                i++;
            } else {
                arraySetsToSort[k] = R[j];
                j++;
            }
            k++;            
        }
        /* Copy the remaining elements of L[], if there are any */
        while (i < sizeLeftPart) {
            arraySetsToSort[k] = L[i];
            i++;
            k++;
        }
	
	
        /* Copy the remaining elements of R[], if there are any */
        while (j < sizeRightPart) {
            arraySetsToSort[k] = R[j];
            j++;
            k++;
        }
    }
}
