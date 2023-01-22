//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA

package emotionalsongs.sorting_algos.songs_sorting_algos;

import emotionalsongs.basic_structures.*;
/**
 * Classe contenente metodi per riordinare una array di canzoni, alfabeticalmente, in base ai loro tag.
 */
public class SorterSongsByTag {
    /**
     * Metodo per riordinare, alfabeticalmente, aun array di canzoni in base ai loro tag.
     * @param arraySongsToSort Array di canzoni da riordinare.
     */
    public void mergeSort(Song[] arraySongsToSort) {	
        int currentSize;
        int leftStartIndex;
        for (currentSize = 1; currentSize <= arraySongsToSort.length-1; currentSize = 2*currentSize) {
            for (leftStartIndex = 0; leftStartIndex < arraySongsToSort.length-1;leftStartIndex += 2*currentSize) {
                int mid = Math.min(leftStartIndex + currentSize - 1, arraySongsToSort.length-1);
                int endIndex = Math.min(leftStartIndex + 2*currentSize - 1, arraySongsToSort.length-1);
                merge(arraySongsToSort, leftStartIndex, mid, endIndex);
            }
        }
    }
	
    private void merge(Song[] arrayUsersToSort, int leftIndex, int midIndex, int rightIndex) {
        int i, j, k;
        int sizeLeftPart = midIndex - leftIndex + 1;
        int sizeRightPart = rightIndex - midIndex;
	
        /* create temp arrays */
        Song L[] = new Song[sizeLeftPart];
        Song R[] = new Song[sizeRightPart];
	
        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < sizeLeftPart; i++) L[i] = arrayUsersToSort[leftIndex + i];
        for (j = 0; j < sizeRightPart; j++) R[j] = arrayUsersToSort[midIndex + 1+ j];
	
        /* Merge the temp arrays back into arrayUsersToSort[leftIndex..rightIndex]*/
        i = 0;
        j = 0;
        k = leftIndex;
        while (i < sizeLeftPart && j < sizeRightPart) {
            if (L[i].compareTags(R[j])<=0) {
                arrayUsersToSort[k] = L[i];
                i++;
            } else {
                arrayUsersToSort[k] = R[j];
                j++;
            }
            k++;            
        }
        /* Copy the remaining elements of L[], if there are any */
        while (i < sizeLeftPart) {
            arrayUsersToSort[k] = L[i];
            i++;
            k++;
        }
	
	
        /* Copy the remaining elements of R[], if there are any */
        while (j < sizeRightPart) {
            arrayUsersToSort[k] = R[j];
            j++;
            k++;
        }
    }
}