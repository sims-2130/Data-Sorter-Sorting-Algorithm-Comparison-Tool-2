import java.util.Scanner;

public class Main {
    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }

    // Utility print method
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements to sort: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] arrBubble = arr.clone();
        int[] arrMerge = arr.clone();
        int[] arrQuick = arr.clone();

        System.out.println("\nOriginal array:");
        printArray(arr);

        // Bubble Sort timing
        long startBubble = System.nanoTime();
        bubbleSort(arrBubble);
        long endBubble = System.nanoTime();
        long timeBubble = endBubble - startBubble;

        System.out.println("Sorted by Bubble Sort:");
        printArray(arrBubble);
        System.out.println("Bubble Sort Time: " + timeBubble + " ns");

        // Merge Sort timing
        long startMerge = System.nanoTime();
        mergeSort(arrMerge, 0, arrMerge.length - 1);
        long endMerge = System.nanoTime();
        long timeMerge = endMerge - startMerge;

        System.out.println("\nSorted by Merge Sort:");
        printArray(arrMerge);
        System.out.println("Merge Sort Time: " + timeMerge + " ns");

        // Quick Sort timing
        long startQuick = System.nanoTime();
        quickSort(arrQuick, 0, arrQuick.length - 1);
        long endQuick = System.nanoTime();
        long timeQuick = endQuick - startQuick;

        System.out.println("\nSorted by Quick Sort:");
        printArray(arrQuick);
        System.out.println("Quick Sort Time: " + timeQuick + " ns");
    }
}
