package lesson5;

public class Main{

    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) {
        withoutTreads();
        withTreads();
    }

    static void withoutTreads() {
        float[] arr = new float[SIZE];
        for (float a : arr) {
            a = 1;
        }
        long time = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    static void withTreads() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[H];
        float[] arr2 = new float[H];
        for (float a : arr) {
            a = 1;
        }
        long time = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);
        MyTread tread1 = new MyTread(arr1);
        MyTread tread2 = new MyTread(arr2);
        tread1.run();
        tread2.run();
        System.arraycopy(tread1.getArr(),0,arr,0,H);
        System.arraycopy(tread2.getArr(),0,arr,H,H);
        System.out.println(System.currentTimeMillis() - time);
    }
}
