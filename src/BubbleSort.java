import java.util.Random;
import java.util.Arrays;

import java.io.FileWriter;  
import java.io.IOException; 

public class BubbleSort {
    public static void main(String [] args){
        Random g = new Random();
        int [] number = new int [10];
        FileWriter myWriter;
        System.out.println();

        try {
            myWriter = new FileWriter("random-integers.txt");    

            for (int d = 0 ; d<number.length ; d++){
                number[d] = g.nextInt(100)+1;

                try {
                    
                    myWriter.write(new Integer(number[d]).toString());  
                    myWriter.write("\r\n");
                    System.out.println(number[d]);

                } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }
            }
            
            myWriter.close();

        } catch (IOException e1) {
           
            e1.printStackTrace();
        }

        System.out.print("\nunsorted Numbers:" + Arrays.toString(number));
        System.out.print("\nSorted Numbers:  " + Arrays.toString(sort(number)));
        System.out.print("\n\n");

    }

    private BubbleSort() { }
   
    public static int[] sort(int[] number) {
        boolean swapped = true;
        int length = number.length;

        while (swapped) {
            swapped = false;
            for (int i = 1; i < length; i++) {
                if (number[i] > number[i - 1]) {
                    swap(i, i - 1, number);
                    swapped = true;
                }
            }
            length--;
        }
        return number;
    }

    
    private static void swap(int index1, int index2, int[] unsorted) {
        int value = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = value;
    }

}


