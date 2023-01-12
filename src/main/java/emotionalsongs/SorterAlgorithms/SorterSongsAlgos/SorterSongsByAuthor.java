//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionalsongs.SorterAlgorithms.SorterSongsAlgos;

import emotionalsongs.BasicsStructure.*;

public class SorterSongsByAuthor {
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
            if (L[i].compareAuthors(R[j])<=0) {
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