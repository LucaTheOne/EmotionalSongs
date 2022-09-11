
package emotionalsongs.SorterAlgorithms.SorterRecordsAlgo;

import emotionalsongs.BasicsStructure.Record;

public class SorterRecords {
    public void mergeSort(Record[] arrayRecordsToSort) {	
        int currentSize;
        int leftStartIndex;
        for (currentSize = 1; currentSize <= arrayRecordsToSort.length-1; currentSize = 2*currentSize) {
            for (leftStartIndex = 0; leftStartIndex < arrayRecordsToSort.length-1;leftStartIndex += 2*currentSize) {
                int mid = Math.min(leftStartIndex + currentSize - 1, arrayRecordsToSort.length-1);
                int endIndex = Math.min(leftStartIndex + 2*currentSize - 1, arrayRecordsToSort.length-1);
                merge(arrayRecordsToSort, leftStartIndex, mid, endIndex);
            }
        }
    }
	
    private void merge(Record[] arrayRecordsToSort, int leftIndex, int midIndex, int rightIndex) {
        int i, j, k;
        int sizeLeftPart = midIndex - leftIndex + 1;
        int sizeRightPart = rightIndex - midIndex;
	
        /* create temp arrays */
        Record L[] = new Record[sizeLeftPart];
        Record R[] = new Record[sizeRightPart];
	
        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < sizeLeftPart; i++) L[i] = arrayRecordsToSort[leftIndex + i];
        for (j = 0; j < sizeRightPart; j++) R[j] = arrayRecordsToSort[midIndex + 1+ j];
	
        /* Merge the temp arrays back into arrayRecordsToSort[leftIndex..rightIndex]*/
        i = 0;
        j = 0;
        k = leftIndex;
        while (i < sizeLeftPart && j < sizeRightPart) {
            if (L[i].compareTo(R[j])<=0) {
                arrayRecordsToSort[k] = L[i];
                i++;
            } else {
                arrayRecordsToSort[k] = R[j];
                j++;
            }
            k++;            
        }
        /* Copy the remaining elements of L[], if there are any */
        while (i < sizeLeftPart) {
            arrayRecordsToSort[k] = L[i];
            i++;
            k++;
        }
	
	
        /* Copy the remaining elements of R[], if there are any */
        while (j < sizeRightPart) {
            arrayRecordsToSort[k] = R[j];
            j++;
            k++;
        }
    }
}