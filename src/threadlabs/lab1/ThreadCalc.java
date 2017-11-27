package threadlabs.lab1;

import java.lang.Math;

public class ThreadCalc extends Thread {
    private double vecA[];
    private double vecB[];
    private int startIndex;
    private int endIndex;
    private double result;

    public ThreadCalc(double vecA[], double vecB[], int startIndex, int endIndex){
        this.vecA = vecA;
        this.vecB = vecB;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void run(){
        for(int i = startIndex; i<endIndex; i++){
            result+= Math.pow(vecA[i]+vecB[i],2);
        }
    }
}
