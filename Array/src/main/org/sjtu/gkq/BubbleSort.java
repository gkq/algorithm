package org.sjtu.gkq;

public class BubbleSort {
    int a[];
    public BubbleSort(int a[]){
        this.a = a;
    }
    public void sort() {
        for(int i=0; i<a.length-1; i++) {
            for(int j=0; j< a.length - 1-i; j++){
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }
    public void stableSort() {
        int bound = a.length - 1;
        while(bound !=0) {
            int rightMost = bound;
            bound = 0;
            for(int i=0; i< rightMost; i++){
                if(a[i] > a[i+1]) {
                    int tmp =a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                    bound = i;
                }
            }
        }
    }
    public void insertSort() {
        for(int i=1; i<a.length; i++){
            if(a[i] < a[i-1]) {
                int tmp = a[i];
                int j= i-1;
                for(; a[j]>=tmp && j>=0; j--) {
                    a[j+1] = a[j];
                }
                a[j+1] = tmp;
            }
        }
    }

    public void selectSort() {
        for(int i=0; i<a.length; i++) {
            int idx = i;
            for(int j=i+1; j<a.length; j++){
                if(a[j] < a[idx]) {
                    idx = j;
                }
            }
            if(idx != i) {
                int tmp = a[i];
                a[i] = a[idx];
                a[idx] = tmp;
            }
        }
    }

//    private void merge(int[] b, int[] tmp, int m, int n, int k) {
//        int i = m, j =n, s=i;
//        while(i<n && j<k) {
//            if(b[i] < b[j]) {
//                tmp[s++] = b[i++];
//            }
//            else tmp[s++] = b[j++];
//        }
//        while(i<n) tmp[s++] = b[i++];
//        while(j<k) tmp[s++] = b[j++];
//    }
//    public void mergeSort(int i, int j, int[] tmp) {
//        if(i==j) tmp[i] = a[i];
//        else {
//            int mid = i + (j-i)/2;
//            mergeSort(i, mid, tmp);
//            mergeSort(mid+1, j, tmp);
//            merge(a, tmp, i, mid, j);
//        }
//    }
}
