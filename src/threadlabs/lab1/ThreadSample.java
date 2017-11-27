package threadlabs.lab1;

import threadlabs.lab1.ThreadCalc;

import java.lang.Math;

public class ThreadSample {
    public static int SIZE = 1000000;
    public static int NUMBER = 7;
    private static long serialExecute = 0;
    private static long parallelExecute = 0;

    public static void main(String[] args) throws InterruptedException {
        double vecA[] = new double[SIZE];
        double vecB[] = new double[SIZE];
        long start = 0;
        long end = 0;

        for(int i=0; i<SIZE; i++){
            vecA[i] = i;
            vecB[i] = 1;
        }

        double serialResult = 0;
        start = System.currentTimeMillis();
        for(int i = 0; i<SIZE; i++){
            serialResult+=Math.pow(vecA[i]+vecB[i], 2);
        }
        end = System.currentTimeMillis();
        serialExecute = end - start;
        System.out.println(serialResult);

        ThreadCalc threadArray[] = new ThreadCalc[NUMBER];
        start = System.currentTimeMillis();
        for(int i=0; i<NUMBER; i++){
            threadArray[i] = new ThreadCalc(vecA, vecB, SIZE/NUMBER*i, i==NUMBER-1 ? SIZE : SIZE/NUMBER*(i+1));
            threadArray[i].start();
        }

        for(int i=0; i<NUMBER; i++){ // let them all end before main thread ends
            threadArray[i].join();
        }
        end = System.currentTimeMillis();
        parallelExecute = end - start;

        double parallelResult = 0;
        for(int i = 0; i<NUMBER; i++){
            parallelResult+=threadArray[i].getResult();
        }
        System.out.println(parallelResult);

        System.out.println("Serial time - " + serialExecute);
        System.out.println("Parallel time - " + parallelExecute);
    }
}
