package threadlabs.lab3;

public class ArrayGenerator {
    private static int[] array;

    public static int[] generateArray(){
        array = new int[100];
        for(int i=0; i<100; i++){
            if(i%2 == 0)
                array[i] = 2;
            else array[i] = 1;
        }
        array[5] = 100;
        array[10] = 0;
        return  array;
    }
}
