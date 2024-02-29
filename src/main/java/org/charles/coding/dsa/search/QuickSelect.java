package org.charles.coding.dsa.search;

/**
 * Used to basically find the kth largest/smallest element
 */
public class QuickSelect {
    public static void main(String[] args) {
        int[] array = {0, 0, 24, 23, 87, 83, 8, 83, 68, 69};
        int k = 3;
        System.out.println(k + "th smallest element is: " + quickselect(k-1, array));
    }

    private static int quickselect(int searchableIndex, int[] array){
        return quickselect(searchableIndex, array, 0, array.length-1);
    }

    private static int quickselect(int searchableIndex, int[] array, int minIndex, int maxIndex){
        if (minIndex < maxIndex){
            int pivot = array[maxIndex];
            int lp = partition(array, maxIndex, pivot);
            if (searchableIndex == lp)
                return array[lp];
            else if (lp > searchableIndex)
                return quickselect(searchableIndex, array, minIndex, lp-1);
            else
                return quickselect(searchableIndex, array, lp+1, maxIndex);
        }
        return array[minIndex];
    }

    private static int partition(int[] array, int maxIndex, int pivot) {
        int lp=0, rp= maxIndex -1;
        while (lp < rp){
            while (array[lp] <= pivot && lp < rp)
                lp++;
            while (array[rp] >= pivot && lp < rp)
                rp--;
            swap(array, lp, rp);
        }
        swap(array, lp, maxIndex);
        return lp;
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
