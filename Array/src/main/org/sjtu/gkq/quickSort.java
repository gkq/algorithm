package org.sjtu.gkq;


public class quickSort {
    int a[];
    public quickSort(int a[]) {
        this.a = a;
    }
    public int partition(int i, int j) {
        int pivot = a[i];
        while(i<j) {
            while(a[j]>=pivot && j > i)
                j--;
            a[i] = a[j];
            while (a[i] <=pivot && j>i) i++;
            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }
    public void sort(int i, int j) {
        if(i<j) {
            int m = partition(i, j);
            sort(i, m-1);
            sort(m+1, j);
        }
    }
}
