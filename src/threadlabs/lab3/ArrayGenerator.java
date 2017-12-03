package threadlabs.lab3;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ArrayGenerator {
    private static int[] array;

    public static int[] generateArray(int size){
        array = new int[size];
        for(int i=0; i<size; i++){
            if(i%2 == 0)
                array[i] = 2;
            else array[i] = 1;
        }
        array[size/2] = 100;
        array[size - 1] = 0;
        return  array;
    }

    public static byte[] convertFromInt(int[] array){
        ByteBuffer byteBuffer = ByteBuffer.allocate(array.length * 4);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(array);
        return byteBuffer.array();
    }
}
