package Collections;
import java.util.Arrays; 
import java.util.List;

class ArrayCollection {
    private  void compute(){
        Integer [] intArray = new Integer[]{0,3,3,8};
        int[] intArray2 = new int[100];
        List<Integer> fixedArrayList = Arrays.asList(intArray);
        fixedArrayList.add(1);
    }

    public static void main(String[] args){
        ArrayCollection ac = new ArrayCollection();
        ac.compute();
    }
}