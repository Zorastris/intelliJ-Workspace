public class Quick2D {
    /* This class is the classic quick sort algorithm with a slight modification.
     * It takes two arrays instead of just one and sorts the first array while preserving
     * data integrity between the two arrays
     *  */
    public Quick2D() {
    }

    public static void QuickSort(double[] a, int[] y) {
        //ints left and right
        int l = 0;
        int r = a.length - 1;
        //Sorting recursively while preserving data integrity of y array
        QuickSort(a, l, r, y);
        assert isSorted(a);
    }


    private static void QuickSort(double[] a, int l, int r, int[] y) {
        int i;
        if (r > l) {
            i = partition(a, l, r, y);
            QuickSort(a, l, i - 1, y);
            QuickSort(a, i + 1, r, y);
        }
    }

    //This method partitions the array into smaller arrays and sorts them
    private static int partition(double[] a, int l, int r, int[] y) {
        double v = a[r];
        int i = l;
        int j = r;
        double tempA;
        int tempB;
        while (i < j) {
            while (a[i] < v) {
                i = i + 1;
            }
            while ((i < j) && (a[j] >= v)) {
                j = j - 1;
            }
            tempA = a[i];
            tempB = y[i];
            if (i < j) {
                a[i] = a[j];
                a[j] = tempA;
               /* While we swap the two values of the original array,
                we also swap the elements of the second array*/
                y[i] = y[j];
                y[j] = tempB;

            } else {
                a[i] = a[r];
                a[r] = tempA;
                y[i] = y[r];
                y[r] = tempB;

            }
        }
        return i;
    }

    //Checks if the first given array is sorted
    private static boolean isSorted(double[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1])
                return false;
        return true;
    }


}
