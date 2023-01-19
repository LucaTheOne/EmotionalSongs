//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs.sorting_algos.judgements_sorting_algo;

import emotionalsongs.basic_structures.UserJudgement;

public class SorterJudgements {
    public void sort(UserJudgement[] arrayJudgementsToSort) {	
        int currentSize;
        int leftStartIndex;
        for (currentSize = 1; currentSize <= arrayJudgementsToSort.length-1; currentSize = 2*currentSize) {
            for (leftStartIndex = 0; leftStartIndex < arrayJudgementsToSort.length-1;leftStartIndex += 2*currentSize) {
                int mid = Math.min(leftStartIndex + currentSize - 1, arrayJudgementsToSort.length-1);
                int endIndex = Math.min(leftStartIndex + 2*currentSize - 1, arrayJudgementsToSort.length-1);
                merge(arrayJudgementsToSort, leftStartIndex, mid, endIndex);
            }
        }
    }
	
    private void merge(UserJudgement[] arrayJudgementsToSort, int leftIndex, int midIndex, int rightIndex) {
        int i, j, k;
        int sizeLeftPart = midIndex - leftIndex + 1;
        int sizeRightPart = rightIndex - midIndex;
	
        /* create temp arrays */
        UserJudgement L[] = new UserJudgement[sizeLeftPart];
        UserJudgement R[] = new UserJudgement[sizeRightPart];
	
        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < sizeLeftPart; i++) L[i] = arrayJudgementsToSort[leftIndex + i];
        for (j = 0; j < sizeRightPart; j++) R[j] = arrayJudgementsToSort[midIndex + 1+ j];
	
        /* Merge the temp arrays back into arrayJudgementsToSort[leftIndex..rightIndex]*/
        i = 0;
        j = 0;
        k = leftIndex;
        while (i < sizeLeftPart && j < sizeRightPart) {
            if (L[i].compareTo(R[j])<=0) {
                arrayJudgementsToSort[k] = L[i];
                i++;
            } else {
                arrayJudgementsToSort[k] = R[j];
                j++;
            }
            k++;            
        }
        /* Copy the remaining elements of L[], if there are any */
        while (i < sizeLeftPart) {
            arrayJudgementsToSort[k] = L[i];
            i++;
            k++;
        }
	
	
        /* Copy the remaining elements of R[], if there are any */
        while (j < sizeRightPart) {
            arrayJudgementsToSort[k] = R[j];
            j++;
            k++;
        }
    }
}