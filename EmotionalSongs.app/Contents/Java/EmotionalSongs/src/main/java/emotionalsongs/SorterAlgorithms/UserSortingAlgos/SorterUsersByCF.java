//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs.SorterAlgorithms.UserSortingAlgos;

import emotionalsongs.BasicsStructure.*;

/**
 *
 * @author big
 */
    public class SorterUsersByCF {
        public void mergeSort(User[] arrayUsersToSort) {	
            int currentSize;
            int leftStartIndex;
            for (currentSize = 1; currentSize <= arrayUsersToSort.length-1; currentSize = 2*currentSize) {
                for (leftStartIndex = 0; leftStartIndex < arrayUsersToSort.length-1;leftStartIndex += 2*currentSize) {
                    int mid = Math.min(leftStartIndex + currentSize - 1, arrayUsersToSort.length-1);
                    int endIndex = Math.min(leftStartIndex + 2*currentSize - 1, arrayUsersToSort.length-1);
                    merge(arrayUsersToSort, leftStartIndex, mid, endIndex);
                }
            }
        }
	
        private void merge(User[] arrayUsersToSort, int leftIndex, int midIndex, int rightIndex) {
            int i, j, k;
            int sizeLeftPart = midIndex - leftIndex + 1;
            int sizeRightPart = rightIndex - midIndex;
	
            /* create temp arrays */
            User L[] = new User[sizeLeftPart];
            User R[] = new User[sizeRightPart];
	
            /* Copy data to temp arrays L[] and R[] */
            for (i = 0; i < sizeLeftPart; i++) L[i] = arrayUsersToSort[leftIndex + i];
            for (j = 0; j < sizeRightPart; j++) R[j] = arrayUsersToSort[midIndex + 1+ j];
	
            /* Merge the temp arrays back into arrayUsersToSort[leftIndex..rightIndex]*/
            i = 0;
            j = 0;
            k = leftIndex;
            while (i < sizeLeftPart && j < sizeRightPart) {
                if (L[i].compareCf(R[j])<=0) {
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
