//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs.SorterAlgorithms.generalSortingAlgos;

/**
 *
 * @author big
 */
public class HeapSortString {
    
    boolean caseSensitive;
    
    public HeapSortString(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }
    
    public void sort(String[] string) {
	int N = string.length;

	// Build heap (rearrange array)
	for (int i = N / 2 - 1; i >= 0; i--) 
            heapify(string, N, i);

	// One by one extract an element from heap
	for (int i = N - 1; i > 0; i--) {
            // Move current root to end
		String temp = string[0];
		string[0] = string[i];
		string[i] = temp;

		// call max heapify on the reduced heap
		heapify(string, i, 0);
	}
    }

    // To heapify a subtree rooted with node i which is
    // an index in stringArray[]. n is size of heap
    void heapify(String[] stringArray, int N, int i) {
	int largest = i; // Initialize largest as root
	int l = 2 * i + 1; // left = 2*i + 1
	int r = 2 * i + 2; // right = 2*i + 2

	// If left child is larger than root
	if (l < N && caseSensitive ? stringArray[l].compareTo(stringArray[largest])>0 : stringArray[l].compareToIgnoreCase(stringArray[largest])>0) 
            largest = l;

	// If right child is larger than largest so far
	if (r < N && caseSensitive ? stringArray[r].compareTo(stringArray[largest])>0 : stringArray[r].compareToIgnoreCase(stringArray[largest])>0)
            largest = r;

	// If largest is not root
	if (largest != i) {
            String swap = stringArray[i];
            stringArray[i] = stringArray[largest];
            stringArray[largest] = swap;

            // Recursively heapify the affected sub-tree
		heapify(stringArray, N, largest);
	}
    }
    
    public static void main(String[] args) {
        String[] stringhe = {"Papera","alemanno","heapSort"};
        HeapSortString string = new HeapSortString(true);
        string.sort(stringhe);
        for (int i = 0; i < 3; i++) {
            System.out.println(stringhe[i]);
        }
    }
}
