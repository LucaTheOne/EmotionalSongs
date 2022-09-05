package emotionalsongs.HeapSorter;

import emotionalsongs.BasicsStructure.User;

public class HeapSortId {
    public void sort(User[] usersArray){
	int N = usersArray.length;

	// Build heap (rearrange array)
	for (int i = N / 2 - 1; i >= 0; i--) buildHeap(usersArray, N, i);

	// One by one extract an element from heap
	for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            User temp = usersArray[0];
            usersArray[0] = usersArray[i];
            usersArray[i] = temp;

            // call max buildHeap on the reduced heap
            buildHeap(usersArray, i, 0);
	}
    }

	// To buildHeap a subtree rooted with node i which is
	// an index in usersArray[]. n is size of heap
    void buildHeap(User[] usersArray, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && usersArray[l].compareId(usersArray[largest])>0) largest = l;

        // If right child is larger than largest so far
        if (r < N && usersArray[r].compareId(usersArray[largest])>0) largest = r;

        // If largest is not root
        if (largest != i) {
            User swap = usersArray[i];
            usersArray[i] = usersArray[largest];
            usersArray[largest] = swap;

            // Recursively buildHeap the affected sub-tree
            buildHeap(usersArray, N, largest);
        }
    }
}

