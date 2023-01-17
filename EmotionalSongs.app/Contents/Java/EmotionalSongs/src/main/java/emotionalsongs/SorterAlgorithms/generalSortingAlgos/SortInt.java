//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.SorterAlgorithms.generalSortingAlgos;

public class SortInt {
    
    public void sort(int[] arrayToSort) {	
	int currentSize;
	int leftStartIndex;
	for (currentSize = 1; currentSize <= arrayToSort.length-1; currentSize = 2*currentSize) {
            for (leftStartIndex = 0; leftStartIndex < arrayToSort.length-1;leftStartIndex += 2*currentSize) {
		int mid = Math.min(leftStartIndex + currentSize - 1, arrayToSort.length-1);
		int endIndex = Math.min(leftStartIndex + 2*currentSize - 1, arrayToSort.length-1);
		merge(arrayToSort, leftStartIndex, mid, endIndex);
            }
	}
    }
	
    private void merge(int[] arrayToSort, int leftIndex, int midIndex, int rightIndex) {
	int i, j, k;
	int sizeLeftPart = midIndex - leftIndex + 1;
	int sizeRightPart = rightIndex - midIndex;
	
	/* create temp arrays */
	int L[] = new int[sizeLeftPart];
	int R[] = new int[sizeRightPart];
	
	/* Copy data to temp arrays L[] and R[] */
	for (i = 0; i < sizeLeftPart; i++) L[i] = arrayToSort[leftIndex + i];
        for (j = 0; j < sizeRightPart; j++) R[j] = arrayToSort[midIndex + 1+ j];
	
	/* Merge the temp arrays back into arrayToSort[leftIndex..rightIndex]*/
	i = 0;
	j = 0;
	k = leftIndex;
	while (i < sizeLeftPart && j < sizeRightPart) {
            if (L[i] <= R[j]) {
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




