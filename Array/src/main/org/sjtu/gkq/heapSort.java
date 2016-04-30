package org.sjtu.gkq;


public class heapSort {
    int[] heap;
    int size;
    public heapSort(int[] array) {
        this.heap = array;
        this.size = array.length -1;
    }
    public void sift(int k) {
        int i = k, j = 2*k;
        while(j < size) {
            if(heap[j] < heap[j+1])
                j++;
            if(heap[i] > heap[j]) return;
            else {
                heap[0] = heap[i];
                heap[i] = heap[j];
                heap[j] = heap[0];
                i = j; j = 2*i;
            }
        }
    }
    public void buildHeap() {
        for(int i = size/2; i>0;i--){
            sift(i);
        }
    }
    public void sort() {
        buildHeap();
        for(int i=0; i<heap.length-1;i++)
        {
            heap[0] = heap[size];
            heap[size] = heap[1];
            heap[1] = heap[0];
            size --;
            sift(1);
        }
    }

}
