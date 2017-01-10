package com.brianway.learning.algorithms.lectures.sort;

/**
 * Created by brian on 16/11/6.
 *
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，
 * 每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
 * 请选择一个合适的排序算法针对这个数据进行排序。
 * 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
 *
 * TODO F1
 */
public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        if (A == null || n == 0) {
            return null;
        }

        int[] aux = createMinHeap(A, k);

        for (int i = 0; i < n - k; i++) {
            A[i] = aux[1];
            aux[1] = A[i + k];
            sink(aux, 1, k);
        }

        for (int i = n - k; i < n; i++) {
            A[i] = aux[1];
            swap(aux, 1, k--);
            sink(aux, 1, k);
        }

        return A;

    }

    private int[] createMinHeap(int[] a, int k) {
        int[] aux = new int[k + 1];
        for (int i = 0; i < k; i++) {
            aux[i + 1] = a[i];
        }

        for (int i = k / 2; i > 0; i--) {
            sink(aux, i, k);
        }
        return aux;
    }

    private void sink(int[] a, int i, int len) {
        while (2 * i <= len) {
            int child = 2 * i;
            if (child < len && a[child] > a[child + 1]) {
                child++;
            }

            if (a[i] < a[child]) {
                break;
            }

            swap(a, i, child);
            i = child;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
        int[] b = new ScaleSort().sortElement(a, 10, 2);
        for (int i : b) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
